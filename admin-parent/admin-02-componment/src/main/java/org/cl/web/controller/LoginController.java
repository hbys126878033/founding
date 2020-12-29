package org.cl.web.controller;

import org.cl.constant.SystemConstant;
import org.cl.entity.Admin;
import org.cl.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author chenlin
 * @create 2020-05-20 21:50
 * @description: TODO
 * @version：1.0
 **/
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/admin/do/login")
    public String doLogin(String loginAcct, String userPswd, HttpSession session){

        Admin admin = adminService.getAdminByLoginAcct(loginAcct, userPswd);
        session.setAttribute(SystemConstant.ATTR_NAME_LOGIN_ADMIN,admin);

        return "redirect:/admin/to/admin-main";
    }

    @RequestMapping(value="/admin/do/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/admin/to/loginPage";
    }

    
}
