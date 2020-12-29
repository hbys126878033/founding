package org.cl.service.api;

import com.github.pagehelper.PageInfo;
import org.cl.entity.Role;

import java.util.List;

/**
 * @author chenlin
 * @create 2020-06-09 9:29
 * @description: TODO
 * @version：1.0
 **/
public interface RoleService {

    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword);

    void save(Role role);

    void updateRole(Role role);

    void delete(List<Integer> ids);


    List<Role> getAssignedRole(Integer adminId);

    List<Role> getUnAssignedRole(Integer adminId);



}
