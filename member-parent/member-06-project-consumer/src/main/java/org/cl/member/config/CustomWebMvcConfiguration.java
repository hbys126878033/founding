package org.cl.member.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: CL
 * @Date: 2021/1/28 22:51
 * @Version: 1.0
 */
@Component
public class CustomWebMvcConfiguration implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        // view-controller是在project-consumer内部定义的，所以这里是一个不经过Zuul访问的地址，所以这个路径前面不加路由规则中定义的前缀：“/project”
        registry.addViewController("/agree/protocol/page").setViewName("project-agree");
        registry.addViewController("/launch/project/page").setViewName("project-launch");
        registry.addViewController("/return/info/page").setViewName("project-return");

    }


}
