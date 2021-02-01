package org.cl.member.web;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.cl.constant.SystemConstant;
import org.cl.member.api.MySQLRemoteService;
import org.cl.member.entity.vo.MemberConfirmInfoVO;
import org.cl.member.entity.vo.MemberLoginVO;
import org.cl.member.entity.vo.ProjectVO;
import org.cl.member.entity.vo.ReturnVO;
import org.cl.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @Author: CL
 * @Date: 2021/1/29 12:13
 * @Version: 1.0
 */

@Controller
public class ProjectController {


    @Value("${uploadPath}")
    private String uploadPath;

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    /**
     * 保存数据到数据库中
     *
     * @author CL
     * @param modelMap
     * @param session
     * @param memberConfirmInfoVO
     * @return java.lang.String
     * @date 2021/1/29 12:16
     */
    @RequestMapping("/create/confirm")
    public String saveConfirm(ModelMap modelMap, HttpSession session, MemberConfirmInfoVO memberConfirmInfoVO) {

        // 1.从Session域读取之前临时存储的ProjectVO对象
        ProjectVO projectVO = (ProjectVO) session.getAttribute(SystemConstant.ATTR_NAME_TEMPLE_PROJECT);

        // 2.如果projectVO为null
        if(projectVO == null) {
            throw new RuntimeException(SystemConstant.MESSAGE_TEMPLE_PROJECT_MISSING);
        }

        // 3.将确认信息数据设置到projectVO对象中
        projectVO.setMemberConfirmInfoVO(memberConfirmInfoVO);

        // 4.从Session域读取当前登录的用户
        MemberLoginVO memberLoginVO = (MemberLoginVO) session.getAttribute(SystemConstant.ATTR_NAME_LOGIN_MEMBER);

        Integer memberId = memberLoginVO.getId();

        // 5.调用远程方法保存projectVO对象
        ResultEntity<String> saveResultEntity = mySQLRemoteService.saveProjectVORemote(projectVO, memberId);

        // 6.判断远程的保存操作是否成功
        String result = saveResultEntity.getSuccess();
        if(ResultEntity.FAILED.equals(result)) {

            modelMap.addAttribute(SystemConstant.ATTR_NAME_MESSAGE, saveResultEntity.getMessage());

            return "project-confirm";
        }

        // 7.将临时的ProjectVO对象从Session域移除
        session.removeAttribute(SystemConstant.ATTR_NAME_TEMPLE_PROJECT);

        String baseUrl = (String)session.getAttribute("fountPageUrl");
        if (StringUtils.hasText(baseUrl)) {
            return "redirect:"+baseUrl+"/project/create/success";
        }
        // 8.如果远程保存成功则跳转到最终完成页面
        return "redirect:http://www.crowd.com/project/create/success";
    }

    @ResponseBody
    @RequestMapping("/create/save/return")
    public ResultEntity<String> saveReturn(ReturnVO returnVO, HttpSession session) {

        try {
            // 1.从session域中读取之前缓存的ProjectVO对象
            ProjectVO projectVO = (ProjectVO) session.getAttribute(SystemConstant.ATTR_NAME_TEMPLE_PROJECT);

            // 2.判断projectVO是否为null
            if(projectVO == null) {
                return ResultEntity.failed(SystemConstant.MESSAGE_TEMPLE_PROJECT_MISSING);
            }

            // 3.从projectVO对象中获取存储回报信息的集合
            List<ReturnVO> returnVOList = projectVO.getReturnVOList();

            // 4.判断returnVOList集合是否有效
            if(returnVOList == null || returnVOList.size() == 0) {

                // 5.创建集合对象对returnVOList进行初始化
                returnVOList = new ArrayList<>();
                // 6.为了让以后能够正常使用这个集合，设置到projectVO对象中
                projectVO.setReturnVOList(returnVOList);
            }

            // 7.将收集了表单数据的returnVO对象存入集合
            returnVOList.add(returnVO);

            // 8.把数据有变化的ProjectVO对象重新存入Session域，以确保新的数据最终能够存入Redis
            session.setAttribute(SystemConstant.ATTR_NAME_TEMPLE_PROJECT, projectVO);

            // 9.所有操作成功完成返回成功
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            e.printStackTrace();

            return ResultEntity.failed(e.getMessage());
        }

    }

    // JavaScript代码：formData.append("returnPicture", file);
    // returnPicture是请求参数的名字
    // file是请求参数的值，也就是要上传的文件
    @ResponseBody
    @RequestMapping("/create/upload/return/picture")
    public ResultEntity<String> uploadReturnPicture(

            // 接收用户上传的文件
            @RequestParam("returnPicture") MultipartFile returnPicture) throws IOException {

        // 1.执行文件上传
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String path = uploadPath + "//" + f.format(LocalDate.now());
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = UUID.randomUUID().toString().replace("-","") + "." + FilenameUtils.getExtension(returnPicture.getName());
        File file = new File(fileName);
        FileUtils.copyInputStreamToFile(returnPicture.getInputStream(),file);
        // 2.返回上传的结果
        return ResultEntity.successWithoutData();
    }

    @RequestMapping("/create/project/information")
    public String saveProjectBasicInfo(

            // 接收除了上传图片之外的其他普通数据
            ProjectVO projectVO,

            // 接收上传的头图
            MultipartFile headerPicture,

            // 接收上传的详情图片
            List<MultipartFile> detailPictureList,

            // 用来将收集了一部分数据的ProjectVO对象存入Session域
            HttpSession session,

            // 用来在当前操作失败后返回上一个表单页面时携带提示消息
            ModelMap modelMap
    ) throws IOException {

        // 一、完成头图上传
        // 1.获取当前headerPicture对象是否为空
        boolean headerPictureIsEmpty = headerPicture.isEmpty();

        if(headerPictureIsEmpty) {

            // 2.如果没有上传头图则返回到表单页面并显示错误消息
            modelMap.addAttribute(SystemConstant.ATTR_NAME_MESSAGE, SystemConstant.MESSAGE_HEADER_PIC_EMPTY);

            return "project-launch";

        }

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String path = uploadPath + "//" + f.format(LocalDate.now());
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = path+"//"+ UUID.randomUUID().toString().replace("-","") + "." + FilenameUtils.getExtension(headerPicture.getName());
        File file = new File(fileName);
        FileUtils.copyInputStreamToFile(headerPicture.getInputStream(),file);
        projectVO.setHeaderPicturePath(fileName);

        // 二、上传详情图片
        // 1.创建一个用来存放详情图片路径的集合
        List<String> detailPicturePathList = new ArrayList<String>();

        // 2.检查detailPictureList是否有效
        if(detailPictureList == null || detailPictureList.size() == 0) {
            modelMap.addAttribute(SystemConstant.ATTR_NAME_MESSAGE, SystemConstant.MESSAGE_DETAIL_PIC_EMPTY);

            return "project-launch";
        }

        // 3.遍历detailPictureList集合
        for (MultipartFile detailPicture : detailPictureList) {

            // 4.当前detailPicture是否为空
            if(detailPicture.isEmpty()) {

                // 5.检测到详情图片中单个文件为空也是回去显示错误消息
                modelMap.addAttribute(SystemConstant.ATTR_NAME_MESSAGE, SystemConstant.MESSAGE_DETAIL_PIC_EMPTY);

                return "project-launch";
            }

            // 6.执行上传
            String detailFileName = path+"//"+ UUID.randomUUID().toString().replace("-","") + "." + FilenameUtils.getExtension(detailPicture.getName());
            File detailFile = new File(fileName);
            FileUtils.copyInputStreamToFile(detailPicture.getInputStream(),detailFile);
                // 8.收集刚刚上传的图片的访问路径
            detailPicturePathList.add(detailFileName);
        }

        // 10.将存放了详情图片访问路径的集合存入ProjectVO中
        projectVO.setDetailPicturePathList(detailPicturePathList);

        // 三、后续操作
        // 1.将ProjectVO对象存入Session域
        session.setAttribute(SystemConstant.ATTR_NAME_TEMPLE_PROJECT, projectVO);


        String baseUrl = (String)session.getAttribute("fountPageUrl");
        if (StringUtils.hasText(baseUrl)) {
            return "redirect:"+baseUrl+"/project/return/info/page";
        }
        // 2.以完整的访问路径前往下一个收集回报信息的页面
        return "redirect:http://localhost/project/return/info/page";
    }
}
