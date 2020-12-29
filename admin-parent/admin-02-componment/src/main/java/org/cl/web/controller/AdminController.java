package org.cl.web.controller;

import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cl.constant.SystemConstant;
import org.cl.entity.Admin;
import org.cl.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenlin
 * @create 2020-05-22 16:38
 * @description: TODO
 * @version：1.0
 **/
@Controller
public class AdminController {

    private static final Log logger = LogFactory.getLog(AdminController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/admin/get/page")
    public String getPageInfo(
            // 使用@RequestParam注解的defaultValue属性，指定默认值，在请求中没有携带对应参数时使用默认值
            // keyword默认值使用空字符串，和SQL语句配合实现两种情况适配
            @RequestParam(value="keyword",defaultValue = "") String keyword,
            // pageNum默认值使用1
            @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize,
            // pageSize默认值使用5
            @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
            ModelMap modelMap){

        logger.info("keyword = "+ keyword+",pageNum = "+ pageNum+",pageSize = "+ pageSize);

        // 调用Service方法获取PageInfo对象
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);

        // 将PageInfo对象存入模型
        modelMap.addAttribute(SystemConstant.ATTR_NAME_PAGE_INFO, pageInfo);

        return "admin-page";
    }


    @RequestMapping("/admin/remove/{adminId}/{pageNum}/{keyword}")
    public String remove(
            @PathVariable("adminId") Integer adminId,
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("keyword") String keyword
    ) {

        // 执行删除
        adminService.remove(adminId);

        // 页面跳转：回到分页页面

        // 尝试方案1：直接转发到admin-page.jsp会无法显示分页数据
        // return "admin-page";

        // 尝试方案2：转发到/admin/get/page.html地址，一旦刷新页面会重复执行删除浪费性能
        // return "forward:/admin/get/page.html";

        // 尝试方案3：重定向到/admin/get/page.html地址
        // 同时为了保持原本所在的页面和查询关键词再附加pageNum和keyword两个请求参数
        return "redirect:/admin/get/page?pageNum="+pageNum+"&keyword="+keyword;
    }

    @RequestMapping(value="/admin/save")
    public String add(Admin admin){
        this.adminService.saveAdmin(admin);
        return "redirect:/admin/get/page?pageNum="+Integer.MAX_VALUE;
    }
    @RequestMapping(value="/admin/to/editPage")
    public String getAdminById(
            @RequestParam(value="id")Integer id,
            ModelMap map){

        Admin admin = adminService.getAdminByPrimaryKey(id);
        map.addAttribute("admin",admin);
        return "admin-edit";
    }

    @RequestMapping(value="/admin/update")
    public String editAdmin(Admin admin,
                            @RequestParam(value="keyword") String keyword,
                            @RequestParam(value="pageNum") Integer pageNum){
        adminService.update(admin);

        return "redirect:/admin/get/page?pageNum="+pageNum+"&keyword="+keyword;
    }


}
