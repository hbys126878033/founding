package org.cl.web.config;

import lombok.EqualsAndHashCode;
import org.cl.entity.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;


/**
 * @author chenlin
 * @create 2020-12-27 14:10
 * @description: 考虑到User对象中仅仅包含账号和密码，为了能够获取到原始的Admin(用户实体)对象，专门创建这个类对User类进行扩展
 * @version：1.0
 **/
@EqualsAndHashCode(callSuper = true)
public class SecurityAdmin extends User {
    // 原始的Admin对象，包含Admin对象的全部属性
    private Admin originalAdmin;


    /**
     * 方法作用：
     * @param originalAdmin 传入原始的Admin对象
     * @param authorities 创建角色、权限信息的集合
     * @return:
     * @createDate:  2020/12/27 14:13
     * @createAuthor: chenlin
     * @updateDate:  2020/12/27 14:13
     * @updateAuthor:  修改作者
     * @updateRemark:  修改内容
     **/
    public SecurityAdmin(Admin originalAdmin, List<GrantedAuthority> authorities) {

        /** 调用父类构造器 */
        super(originalAdmin.getLoginAcct(), originalAdmin.getUserPswd(), authorities);

        /** 给本类的this.originalAdmin赋值 */
        this.originalAdmin = originalAdmin;

        /** 将原始Admin对象中的密码擦除*/
        this.originalAdmin.setUserPswd(null);

    }

    // 对外提供的获取原始Admin对象的getXxx()方法
    public Admin getOriginalAdmin() {
        return originalAdmin;
    }
}
