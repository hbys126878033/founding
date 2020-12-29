package org.cl.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cl.constant.SystemConstant;
import org.cl.entity.Admin;
import org.cl.entity.AdminExample;
import org.cl.entity.AdminExample.Criteria;
import org.cl.exception.BusinessException;
import org.cl.exception.LoginFailedException;
import org.cl.mapper.AdminMapper;
import org.cl.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author chenlin
 * @create 2020-05-06 21:53
 * @description: TODO
 * @version：1.0
 **/
@Service
public class AdminServiceImpl implements AdminService {

    private static final Log logger = LogFactory.getLog(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void saveAdmin(Admin admin) {
        try {
            admin.setUserPswd(SecureUtil.md5(admin.getUserPswd()));
            admin.setCreateTime(DateUtil.now());
            adminMapper.insert(admin);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("异常全类名="+e.getClass().getName());
            if(e instanceof DuplicateKeyException){
                throw new BusinessException(SystemConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
        }
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    @Override
    public Admin getAdminByLoginAcct(String loginAcct, String userPswd) {
        // 1.根据登录账号查询Admin对象
        // ①创建AdminExample对象
        AdminExample example = new AdminExample();
        // ②创建Criteria对象
        Criteria criteria = example.createCriteria();
        // ③在Criteria对象中封装查询条件
        criteria.andLoginAcctEqualTo(loginAcct);

        // ④调用AdminMapper的方法执行查询
        List<Admin> list = adminMapper.selectByExample(example);

        // 2.判断Admin对象是否为null
        if(list == null || list.size() == 0) {
            throw new LoginFailedException(SystemConstant.MESSAGE_LOGIN_FAILED);
        }

        if(list.size() > 1) {
            throw new RuntimeException(SystemConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }
        Admin admin = list.get(0);

        // 3.如果Admin对象为null则抛出异常
        if(admin == null) {
            throw new LoginFailedException(SystemConstant.MESSAGE_LOGIN_FAILED);
        }

        // 4.如果Admin对象不为null则将数据库密码从Admin对象中取出
        String userPswdDB = admin.getUserPswd();

        // 5.将表单提交的明文密码进行加密
        String userPswdForm = SecureUtil.md5(userPswd);

        // 6.对密码进行比较
        if(!Objects.equals(userPswdDB, userPswdForm)) {
            // 7.如果比较结果是不一致则抛出异常
            throw new LoginFailedException(SystemConstant.MESSAGE_LOGIN_FAILED);
        }

        // 8.如果一致则返回Admin对象
        return admin;
    }

    @Override
    public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        // 1.调用PageHelper的静态方法开启分页功能
        // 这里充分体现了PageHelper的“非侵入式”设计：原本要做的查询不必有任何修改
        PageHelper.startPage(pageNum, pageSize);

        // 2.执行查询
        List<Admin> list = adminMapper.selectAdminByKeyword(keyword);

        // 3.封装到PageInfo对象中
        return new PageInfo<>(list);
    }

    @Override
    public void remove(Integer adminId) {
        adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public Admin getAdminByPrimaryKey(Integer id) {
        return this.adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Admin admin) {
        try {
            this.adminMapper.updateByPrimaryKeySelective(admin);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("异常全类名="+e.getClass().getName());
            if(e instanceof DuplicateKeyException){
                throw new BusinessException(SystemConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
        }
    }

    @Override
    public void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList) {

        // 旧数据如下：
        // adminId	roleId
        // 1		1（要删除）
        // 1		2（要删除）
        // 1		3
        // 1		4
        // 1		5
        // 新数据如下：
        // adminId	roleId
        // 1		3（本来就有）
        // 1		4（本来就有）
        // 1		5（本来就有）
        // 1		6（新）
        // 1		7（新）
        // 为了简化操作：先根据adminId删除旧的数据，再根据roleIdList保存全部新的数据

        // 1.根据adminId删除旧的关联关系数据
        adminMapper.deleteOLdRelationship(adminId);

        // 2.根据roleIdList和adminId保存新的关联关系
        if(roleIdList != null && roleIdList.size() > 0) {
            adminMapper.insertNewRelationship(adminId, roleIdList);
        }
    }

    @Override
    public Admin getAdminByLoginAcct(String username) {

        AdminExample example = new AdminExample();

        Criteria criteria = example.createCriteria();

        criteria.andLoginAcctEqualTo(username);

        List<Admin> list = adminMapper.selectByExample(example);

        Admin admin = list.get(0);

        return admin;
    }
}
