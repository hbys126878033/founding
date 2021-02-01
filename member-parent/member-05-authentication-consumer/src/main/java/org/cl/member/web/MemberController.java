package org.cl.member.web;

import lombok.extern.slf4j.Slf4j;
import org.cl.constant.SystemConstant;
import org.cl.member.api.MySQLRemoteService;
import org.cl.member.api.RedisRemoteService;
import org.cl.member.entity.po.MemberPO;
import org.cl.member.entity.vo.MemberLoginVO;
import org.cl.member.entity.vo.MemberVO;
import org.cl.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: CL
 * @Date: 2021/1/27 10:26
 * @Version: 1.0
 */

@Controller
@Slf4j
public class MemberController {

    @Autowired
    private RedisRemoteService redisRemoteService;
    @Autowired
    private MySQLRemoteService mySQLRemoteService;


    @RequestMapping("/auth/member/logout")
    public String logout(HttpSession session) {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String baseUrl = (String) request.getSession().getAttribute("fountPageUrl");

        log.info("logout baseUrl = {}",baseUrl);

        session.invalidate();
        if (StringUtils.hasText(baseUrl)) {
            return "redirect:"+baseUrl;
        }
        return "redirect:http://localhost/";
    }
    @ResponseBody
    @RequestMapping("/auth/member/send/short/message")
    public ResultEntity<String> sendMessage(@RequestParam("phoneNum") String phoneNum) {

        StringBuilder code = new StringBuilder();
        Integer item = null;
        for (int i = 0; i < 4; i++  ){
            item = new Random().nextInt(10);
            code.append(item.toString());
        }


        String key = SystemConstant.REDIS_CODE_PREFIX + phoneNum;

        log.info("Redis: key = {}, value = {} ",key,code);

        // 调用远程接口存入Redis
        ResultEntity<String> saveCodeResultEntity = redisRemoteService.setRedisKeyValueRemoteWithTimeout(key, code.toString(), 15, TimeUnit.MINUTES);

        // 判断结果
        if(ResultEntity.SUCCESS.equals(saveCodeResultEntity.getSuccess())) {

            return ResultEntity.successWithData(code.toString());
        }else {
            return saveCodeResultEntity;
        }
    }

    @RequestMapping("/auth/member/do/login")
    public String login(
            @RequestParam("loginacct") String loginacct,
            @RequestParam("userpswd") String userpswd,
            ModelMap modelMap,
            HttpSession session) {

        // 1.调用远程接口根据登录账号查询MemberPO对象
        ResultEntity<MemberPO> resultEntity =
                mySQLRemoteService.getMemberPOByLoginAcctRemote(loginacct);

        if(ResultEntity.FAILED.equals(resultEntity.getSuccess())) {

            modelMap.addAttribute(SystemConstant.ATTR_NAME_MESSAGE, resultEntity.getMessage());

            return "member-login";

        }

        MemberPO memberPO = resultEntity.getData();

        if(memberPO == null) {
            modelMap.addAttribute(SystemConstant.ATTR_NAME_MESSAGE, SystemConstant.MESSAGE_LOGIN_FAILED);

            return "member-login";
        }

        // 2.比较密码
        String userpswdDataBase = memberPO.getUserpswd();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        boolean matcheResult = passwordEncoder.matches(userpswd, userpswdDataBase);

        if(!matcheResult) {
            modelMap.addAttribute(SystemConstant.ATTR_NAME_MESSAGE, SystemConstant.MESSAGE_LOGIN_FAILED);

            return "member-login";
        }

        // 3.创建MemberLoginVO对象存入Session域
        MemberLoginVO memberLoginVO = new MemberLoginVO(memberPO.getId(), memberPO.getUsername(), memberPO.getEmail());
        session.setAttribute(SystemConstant.ATTR_NAME_LOGIN_MEMBER, memberLoginVO);

        // redisRemoteService.setKey(SystemConstant.ATTR_NAME_LOGIN_MEMBER,memberLoginVO);

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String baseUrl = (String) request.getSession().getAttribute("fountPageUrl");

        log.info("login baseUrl = {}",baseUrl);
        if (StringUtils.hasText(baseUrl)) {
            return "redirect:"+baseUrl+"/auth/member/to/center/page";
        }
        return "redirect:http://localhost/auth/member/to/center/page";
    }

    @RequestMapping("/auth/do/member/register")
    public String register(MemberVO memberVO, ModelMap modelMap) {

        // 1.获取用户输入的手机号
        String phoneNum = memberVO.getPhoneNum();

        // 2.拼Redis中存储验证码的Key
        String key = SystemConstant.REDIS_CODE_PREFIX + phoneNum;

        // 3.从Redis读取Key对应的value
        ResultEntity<String> resultEntity = redisRemoteService.getRedisStringValueByKeyRemote(key);

        // 4.检查查询操作是否有效
        String result = resultEntity.getSuccess();
        if(ResultEntity.FAILED.equals(result)) {

            modelMap.addAttribute(SystemConstant.ATTR_NAME_MESSAGE, resultEntity.getMessage());

            return "member-reg";
        }

        String redisCode = resultEntity.getData();

        if(redisCode == null) {

            modelMap.addAttribute(SystemConstant.ATTR_NAME_MESSAGE, SystemConstant.MESSAGE_CODE_NOT_EXISTS);

            return "member-reg";
        }

        // 5.如果从Redis能够查询到value则比较表单验证码和Redis验证码
        String formCode = memberVO.getCode();

        if(!Objects.equals(formCode, redisCode)) {

            modelMap.addAttribute(SystemConstant.ATTR_NAME_MESSAGE, SystemConstant.MESSAGE_CODE_INVALID);

            return "member-reg";
        }

        // 6.如果验证码一致，则从Redis删除
        redisRemoteService.removeRedisKeyRemote(key);

        // 7.执行密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String userpswdBeforeEncode = memberVO.getUserpswd();

        String userpswdAfterEncode = passwordEncoder.encode(userpswdBeforeEncode);

        memberVO.setUserpswd(userpswdAfterEncode);

        // 8.执行保存
        // ①创建空的MemberPO对象
        MemberPO memberPO = new MemberPO();

        // ②复制属性
        BeanUtils.copyProperties(memberVO, memberPO);

        // ③调用远程方法
        ResultEntity<String> saveMemberResultEntity = mySQLRemoteService.saveMember(memberPO);

        if(ResultEntity.FAILED.equals(saveMemberResultEntity.getSuccess())) {

            modelMap.addAttribute(SystemConstant.ATTR_NAME_MESSAGE, saveMemberResultEntity.getMessage());

            return "member-reg";
        }
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String baseUrl = (String) request.getSession().getAttribute("fountPageUrl");

        log.info("register baseUrl = {}",baseUrl);
        if (StringUtils.hasText(baseUrl)) {
            return "redirect:"+baseUrl+"/auth/member/to/login/page";
        }
        // 使用重定向避免刷新浏览器导致重新执行注册流程
        return "redirect:http://localhost/auth/member/to/login/page";
    }
}
