<%--
  Created by IntelliJ IDEA.
  User: 86353
  Date: 2020/5/19
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html lang="zh-CN">
<jsp:include page="include-head.jsp"/>
<body>
    <jsp:include page="include-nav.jsp"/>
    <div class="container-fluid">
        <div class="row">

            <jsp:include page="include-sidebar.jsp"/>

            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <h1 class="page-header">控制面板</h1>
                Credentials：<security:authentication property="credentials"/><br/>
                <p>显示出来才发现，principal原来是我们自己封装的SecurityAdmin对象</p>
                <p>SpringSecurity处理完登录操作之后把登录成功的User对象以principal属性名存入了UsernamePasswordAuthenticationToken对象</p>
                Principal：<security:authentication property="principal.class.name"/><br/>
                Principal中的密码：<security:authentication property="principal.password"/><br/>
                访问SecurityAdmin对象的属性：<security:authentication property="principal.originalAdmin.loginAcct"/><br/>
                访问SecurityAdmin对象的属性：<security:authentication property="principal.originalAdmin.userPswd"/><br/>
                访问SecurityAdmin对象的属性：<security:authentication property="principal.originalAdmin.userName"/><br/>
                访问SecurityAdmin对象的属性：<security:authentication property="principal.originalAdmin.email"/><br/>
                访问SecurityAdmin对象的属性：<security:authentication property="principal.originalAdmin.createTime"/><br/>

                <div class="row placeholders">
                    <security:authorize access="hasRole('经理')">
                        <div class="col-xs-6 col-sm-3 placeholder">
                            <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
                            <h4>Label</h4>
                            <span class="text-muted">Something else</span>
                        </div>
                    </security:authorize>

                    <div class="col-xs-6 col-sm-3 placeholder">
                        <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
                        <h4>Label</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                    <div class="col-xs-6 col-sm-3 placeholder">
                        <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
                        <h4>Label</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                    <div class="col-xs-6 col-sm-3 placeholder">
                        <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
                        <h4>Label</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">

    </script>

</body>
</html>
