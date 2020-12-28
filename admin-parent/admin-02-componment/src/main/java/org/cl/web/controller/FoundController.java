package org.cl.web.controller;

import org.cl.entity.Admin;
import org.cl.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author chenlin
 * @create 2020-05-07 9:13
 * @description: TODO
 * @version：1.0
 **/
@Controller
public class FoundController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/testFound")
    public String foundAll(Model model){
        List<Admin> adminList = adminService.getAll();
        model.addAttribute("adminList",adminList);
        return "target";
    }
}

