package org.cl.member.web;

import lombok.extern.slf4j.Slf4j;
import org.cl.constant.SystemConstant;
import org.cl.member.entity.po.MemberPO;
import org.cl.member.service.api.MemberService;
import org.cl.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class MemberProviderHandler {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping("/save/member/remote")
	public ResultEntity<String> saveMember(
			@RequestBody MemberPO memberPO) {

		log.info(memberPO.toString());

		try {

			memberService.saveMember(memberPO);

			return ResultEntity.successWithoutData();

		}catch(Exception e) {

			if(e instanceof DuplicateKeyException) {
				return ResultEntity.failed(SystemConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
			}

			return ResultEntity.failed(e.getMessage());
		}

	}
	
	@RequestMapping("/get/memberpo/by/login/acct/remote")
	public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct) {
		
		try {
			
			// 1.调用本地Service完成查询
			MemberPO memberPO = memberService.getMemberPOByLoginAcct(loginacct);
			
			// 2.如果没有抛异常，那么就返回成功的结果
			return ResultEntity.successWithData(memberPO);
		} catch (Exception e) {
			e.printStackTrace();
			
			// 3.如果捕获到异常则返回失败的结果
			return ResultEntity.failed(e.getMessage());
		}
		
	}

}
