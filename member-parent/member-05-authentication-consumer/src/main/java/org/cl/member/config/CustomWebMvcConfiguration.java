package org.cl.member.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: CL
 * @Date: 2021/1/26 19:12
 * @Version: 1.0
 */
@Configuration
public class CustomWebMvcConfiguration implements WebMvcConfigurer {


    /**
     * 添加路由，作用是访问URL时，返回一个具体的页面，
     *
     * @author CL
     * @param registry
     * @return void
     * @date 2021/1/26 19:15
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 添加viewController, 注册的页面
        registry.addViewController("/auth/member/to/reg/page").setViewName("member-reg");

        registry.addViewController("/auth/member/to/login/page").setViewName("member-login");

        registry.addViewController("/auth/member/to/center/page").setViewName("member-center");

        registry.addViewController("/member/my/crowd").setViewName("member-crowd");
    }
}
