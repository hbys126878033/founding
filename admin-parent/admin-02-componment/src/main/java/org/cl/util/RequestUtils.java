package org.cl.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.FrameworkServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author chenlin
 * @create 2019-06-21 9:03
 * @description: HttpServletRequest帮助类
 * @version：1.0
 **/
public class RequestUtils {

    /**
     * 方法作用：获取name参数的值
     *
     * @param name 参数名称
     * @return: java.lang.String 参数值的类型
     * @createDate: 2019/6/21 15:50
     * @createAuthor: chenlin
     * @updateDate: 2019/6/21 15:50
     * @updateAuthor: 修改作者
     * @updateRemark: 修改内容
     **/
    public static String getParameter(String name) {

        return getRequest().getParameter(name);
    }



    /**
     * 方法作用：获取HttpRequest对象
     *
     * @param
     * @return: javax.servlet.http.HttpServletRequest
     * @createDate: 2019/6/21 15:54
     * @createAuthor: chenlin
     * @updateDate: 2019/6/21 15:54
     * @updateAuthor: 修改作者
     * @updateRemark: 修改内容
     **/
    public static HttpServletRequest getRequest() {

        return getRequestAttributes().getRequest();
    }

    /**
     * 方法作用：获取HttpResponse对象
     *
     * @param
     * @return: javax.servlet.http.HttpServletResponse
     * @createDate: 2019/6/21 15:54
     * @createAuthor: chenlin
     * @updateDate: 2019/6/21 15:54
     * @updateAuthor: 修改作者
     * @updateRemark: 修改内容
     **/
    public static HttpServletResponse getResponse() {

        return getRequestAttributes().getResponse();
    }

    /**
     * 方法作用：获取HttpSession对象
     *
     * @param
     * @return: javax.servlet.http.HttpSession
     * @createDate: 2019/6/21 15:55
     * @createAuthor: chenlin
     * @updateDate: 2019/6/21 15:55
     * @updateAuthor: 修改作者
     * @updateRemark: 修改内容
     **/
    public static HttpSession getSession() {

        return getRequest().getSession();
    }

    /**
     * 方法作用：获取调用方法时的所有属性，
     * 在DispatcherServlet的父类
     * {@link FrameworkServlet#processRequest(HttpServletRequest, HttpServletResponse)}
     * 中，会设置此属性
     *
     * @param
     * @return: org.springframework.web.context.request.ServletRequestAttributes
     * @createDate: 2019/6/21 15:48
     * @createAuthor: chenlin
     * @updateDate: 2019/6/21 15:48
     * @updateAuthor: 修改作者
     * @updateRemark: 修改内容
     **/
    public static ServletRequestAttributes getRequestAttributes() {

        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 方法作用：将字符串渲染到客户端
     *
     * @param response
     * @param string
     * @return: java.lang.String
     * @createDate: 2019/6/21 15:47
     * @createAuthor: chenlin
     * @updateDate: 2019/6/21 15:47
     * @updateAuthor: 修改作者
     * @updateRemark: 修改内容
     **/
    public static String renderString(HttpServletResponse response, String string) {

        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 方法作用：根据HttpServletRequest对象，获取客户端的真实IP。
     *
     * @param request
     * @return: java.lang.String
     * @createDate: 2019/6/21 9:08
     * @createAuthor: chenlin
     * @updateDate: 2019/6/21 9:08
     * @updateAuthor: 修改作者
     * @updateRemark: 修改内容
     **/
    public static String getIpAddr(HttpServletRequest request) {

        if (request == null) {
            return "unknown";
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String getIpAddr() {
        return getIpAddr(getRequest());

    }


    /**
     * 方法作用：判断HttpRequest是否是AJAX请求
     *
     * @param request httpRequest对象
     * @return: boolean
     * @createDate: 2019/6/21 10:17
     * @createAuthor: chenlin
     * @updateDate: 2019/6/21 10:17
     * @updateAuthor: 修改作者
     * @updateRemark: 修改内容
     **/
    public static boolean isAjaxRequest(HttpServletRequest request) {

        String accept = request.getHeader("accept");
        if (accept != null && accept.indexOf("application/json") != -1) {
            return true;
        }

        String xRequestedWith = request.getHeader("X-Requested-With");
        if (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1) {
            return true;
        }
        return false;
    }

    public static boolean isAjaxRequest(){
        return isAjaxRequest(getRequest());
    }

    /**
     * 方法作用：
     * @param
     * @return: java.lang.String
     * @createDate:  2019/9/19 10:48
     * @createAuthor: chenlin
     * @updateDate:  2019/9/19 10:48
     * @updateAuthor:  修改作者
     * @updateRemark:  修改内容
     **/
    public static String translateParameterMap2String(){
        return translateParameterMap2String(getRequest());
    }
    /**
     * 方法作用：把请求参数装成String
     * @param request
     * @return: java.lang.String
     * @createDate:  2019/9/19 10:48
     * @createAuthor: chenlin
     * @updateDate:  2019/9/19 10:48
     * @updateAuthor:  修改作者
     * @updateRemark:  修改内容
     **/
    public static String translateParameterMap2String(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (!parameterMap.isEmpty()) {
            StringBuilder sb = new StringBuilder(parameterMap.size()*10);

            for (Entry<String, String[]> entry : parameterMap.entrySet()) {
                entry.getKey();
                String[] value = entry.getValue();
                sb.append(entry.getKey() +" = "+ Arrays.toString(entry.getValue())+",");
            }
            if(sb.length() > 1){
                return sb.deleteCharAt(sb.length()-1).toString();
            }else{
                return sb.toString();
            }
        } else {
            return null;
        }
    }

}
