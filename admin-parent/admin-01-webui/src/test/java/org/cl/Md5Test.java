package org.cl;

import cn.hutool.crypto.SecureUtil;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author chenlin
 * @create 2020-05-21 21:54
 * @description: TODO
 * @version：1.0
 **/
public class Md5Test {

    @Test
    public void md5Test(){
        String str = "123456";
        System.out.println(SecureUtil.md5(str));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);
    }
}
