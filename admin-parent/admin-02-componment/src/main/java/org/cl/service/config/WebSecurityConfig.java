package org.cl.service.config;

import org.cl.constant.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenlin
 * @create 2020-07-28 9:57
 * @description: Spring Security 配置类
 * @version：1.0
 **/

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    /**认证逻辑*/
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        // super.configure(builder);
        /**
         * AuthenticationManagerBuilder用来配置全局的认证相关的信息，
         * 其实就是AuthenticationProvider和UserDetailsService，
         * 前者是认证服务提供者，后者是认证用户（及其权限）。
         * */

        /** 在SpringSecurity环境下用户登录相关，即用户密码是怎么匹配的*/

        // 临时使用内存版登录的模式测试代码
        // builder.inMemoryAuthentication().withUser("tom").password("123123").roles("ADMIN");

        // 正式功能中使用基于数据库的认证
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);
        /** 在SpringSecurity环境下请求授权相关的，授权逻辑*/
        /**
         * HttpSecurity 具体的权限控制规则配置。一个这个配置相当于xml配置中的一个标签。
         * 各种具体的认证机制的相关配置，OpenIDLoginConfigurer、AnonymousConfigurer、FormLoginConfigurer、HttpBasicConfigurer
         * LogoutConfigurer
         * RequestMatcherConfigurer：spring mvc style、ant style、regex style
         * HeadersConfigurer：
         * CorsConfigurer、CsrfConfigurer
         * SessionManagementConfigurer：
         * PortMapperConfigurer：
         * JeeConfigurer：
         * X509Configurer：
         * RememberMeConfigurer：
         * ExpressionUrlAuthorizationConfigurer：
         * RequestCacheConfigurer：
         * ExceptionHandlingConfigurer：
         * SecurityContextConfigurer：
         * ServletApiConfigurer：
         * ChannelSecurityConfigurer：
         *
         * */
        http.authorizeRequests()	// 对请求进行授权
                //.antMatchers("/login.jsp")
                //.permitAll()
                .antMatchers("/admin/to/loginPage")	// 针对登录页进行设置
                .permitAll()			// 无条件访问
                .antMatchers("/resource/bootstrap/**")	// 针对静态资源进行设置，无条件访问
                .permitAll()                    // 针对静态资源进行设置，无条件访问
                .antMatchers("/resource/crowd/**")       // 针对静态资源进行设置，无条件访问
                .permitAll()                    // 针对静态资源进行设置，无条件访问
                .antMatchers("/resource/css/**")         // 针对静态资源进行设置，无条件访问
                .permitAll()                    // 针对静态资源进行设置，无条件访问
                .antMatchers("/resource/fonts/**")       // 针对静态资源进行设置，无条件访问
                .permitAll()                    // 针对静态资源进行设置，无条件访问
                .antMatchers("/resource/img/**")         // 针对静态资源进行设置，无条件访问
                .permitAll()                    // 针对静态资源进行设置，无条件访问
                .antMatchers("/resource/jquery/**")      // 针对静态资源进行设置，无条件访问
                .permitAll()                    // 针对静态资源进行设置，无条件访问
                .antMatchers("/resource/layer/**")       // 针对静态资源进行设置，无条件访问
                .permitAll()                    // 针对静态资源进行设置，无条件访问
                .antMatchers("/resource/script/**")      // 针对静态资源进行设置，无条件访问
                .permitAll()                    // 针对静态资源进行设置，无条件访问
                .antMatchers("/resource/ztree/**")       // 针对静态资源进行设置，无条件访问
                .permitAll()
                //.antMatchers("/admin/get/page")	// 针对分页显示Admin数据设定访问控制
                //.access("hasRole('经理') OR hasAuthority('user:get')")	// 要求具备“经理”角色和“user:get”权限二者之一
                .anyRequest()					// 其他任意请求
                .authenticated()				// 认证后访问
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new AccessDeniedHandler() {

                    @Override
                    public void handle(HttpServletRequest request, HttpServletResponse response,
                                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
                        request.setAttribute("exception", new Exception(SystemConstant.MESSAGE_ACCESS_DENIED));
                        request.getRequestDispatcher("/WEB-INF/system-error.jsp").forward(request, response);
                    }
                })
                .and()
                .csrf()							// 防跨站请求伪造功能
                .disable()						// 禁用
                .formLogin()					// 开启表单登录的功能
                .loginPage("/admin/to/loginPage")	// 指定登录页面
                .loginProcessingUrl("/security/do/login")	// 指定处理登录请求的地址
                .defaultSuccessUrl("/admin/to/admin-main")	// 指定登录成功后前往的地址
                .usernameParameter("loginAcct")	// 账号的请求参数名称
                .passwordParameter("userPswd")	// 密码的请求参数名称
                .and()
                .logout()						// 开启退出登录功能
                .logoutUrl("/security/do/logout")			// 指定退出登录地址
                .logoutSuccessUrl("/admin/to/admin-main")	// 指定退出成功以后前往的地址
        ;


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        /**
         * 可以设置全局的忽略规则的配置，比如静态文件，注册页面，登录页面等等，
         * 全局HttpFirewall配置、是否debug配置、全局SecurityFilterChain配置、
         * privilegeEvaluator、expressionHandler、securityInterceptor
         */
       /* web.ignoring().antMatchers(
                "/layui/**",
                "/favicon.ico");*/
    }
}
