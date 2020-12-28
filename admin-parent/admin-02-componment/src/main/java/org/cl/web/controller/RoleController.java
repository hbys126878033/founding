package org.cl.web.controller;

import com.github.pagehelper.PageInfo;
import org.cl.entity.Role;
import org.cl.service.api.RoleService;
import org.cl.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author chenlin
 * @create 2020-06-09 9:49
 * @description: TODO
 * @version：1.0
 **/
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/role/get/page/info")
    public ResultEntity<PageInfo<Role>> getPageInfo(@RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
                                                    @RequestParam(value="pageSize", defaultValue="5") Integer pageSize,
                                                    @RequestParam(value="keyword", defaultValue="") String keyword) {
        // 调用 Service 方法获取分页数据
        PageInfo<Role> pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);
        // 封装到 ResultEntity 对象中返回（如果上面的操作抛出异常，交给异常映射机制处理）
        return ResultEntity.successWithData(pageInfo);
    }


    @ResponseBody
    @RequestMapping(value="/role/save")
    public ResultEntity<String> saveRole(Role role){
        roleService.save(role);
        return ResultEntity.successWithoutData();
    }


    @ResponseBody
    @RequestMapping("/role/update")
    public ResultEntity<String> updateRole(Role role) {
        roleService.updateRole(role);
        return ResultEntity.successWithoutData();
    }


    @ResponseBody
    @RequestMapping(value="/role/remove/by/role/id/array")
    public ResultEntity<String> delete(@RequestBody List<Integer> ids){
        roleService.delete(ids);
        return ResultEntity.successWithoutData();
    }

}
