package org.cl.service.api;

import com.github.pagehelper.PageInfo;
import org.cl.entity.Admin;

import java.util.List;

/**
 * @author chenlin
 * @create 2020-05-06 21:52
 * @description: TODO
 * @version：1.0
 **/
public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> getAll();

    public Admin getAdminByLoginAcct(String loginAcct,String userPswd);

    public PageInfo<Admin> getPageInfo(String keyword,Integer pageNum,Integer pageSize);

    void remove(Integer adminId);

    Admin getAdminByPrimaryKey(Integer id);

    void update(Admin admin);

    void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList);

    Admin getAdminByLoginAcct(String username);

}
