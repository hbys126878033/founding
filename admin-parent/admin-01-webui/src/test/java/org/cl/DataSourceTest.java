package org.cl;

import org.cl.entity.Admin;
import org.cl.mapper.AdminMapper;
import org.cl.service.api.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author chenlin
 * @create 2020-05-05 15:35
 * @description: TODO
 * @version：1.0
 **/

@ContextConfiguration(value={"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DataSourceTest {
    @Autowired
    public DataSource dataSource;

    @Autowired
    public AdminMapper adminMapper;

    @Autowired
    public AdminService adminService;

    @Test
    public void getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        System.out.println(connection.getClass());
        System.out.println(adminMapper);
        System.out.println(adminMapper.getClass());
    }


    @Test
    public void batchInsertAdmin(){
        for(int i = 1;i < 288;i++){
            Admin admin = new Admin(null,"cl"+i,"Test1111","管理员"+i,"863533952@qq.com","2020-05-05 22:00:00");
            adminMapper.insert(admin);
        }
    }

    @Test
    public void insertAdminTest(){
        Admin admin = new Admin(null,"cl","Test1111","管理员","863533952@qq.com","2020-05-05 22:00:00");
        adminMapper.insert(admin);
    }

    @Test
    public void saveAdminByTxTest(){
        Admin admin = new Admin(null,"kitty","kitty","KITTY","369522616@qq.com","2020-05-06 10:20:30");

        adminService.saveAdmin(admin);
    }
}
