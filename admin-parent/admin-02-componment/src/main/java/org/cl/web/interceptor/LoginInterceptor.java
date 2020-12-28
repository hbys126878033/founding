package org.cl.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.cl.constant.SystemConstant;
import org.cl.entity.Admin;
import org.cl.exception.AccessForbiddenException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author chenlin
 * @create 2020-05-22 15:07
 * @description: 登录拦截器
 * @version：1.0
 **/
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.从request中获取session对象
        HttpSession session = request.getSession();

        // 2 尝试从session中获取Admin对象
        Admin admin = (Admin)session.getAttribute(SystemConstant.ATTR_NAME_LOGIN_ADMIN);

        // 3 判断admin对象是否为空
        if(admin == null){
            // 4 为空，则抛出异常
            throw new AccessForbiddenException(SystemConstant.MESSAGE_ACCESS_FORBIDDEN);
        }
        // 5如果Admin对象不为null，则返回true放行
        log.info("访问的URL："+request.getRequestURI());
        return true;
    }
}
