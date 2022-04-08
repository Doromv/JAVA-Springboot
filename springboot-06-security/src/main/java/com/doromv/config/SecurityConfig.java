package com.doromv.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Doromv
 * @create 2022-03-13-9:20
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    //授权
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasAnyRole("vip1")
                .antMatchers("/level2/**").hasAnyRole("vip2")
                .antMatchers("/level3/**").hasAnyRole("vip3");
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login").usernameParameter("user").passwordParameter("pwd");
        http.csrf().disable();
        http.rememberMe().rememberMeParameter("rememberMe");
        http.logout().deleteCookies("remove").invalidateHttpSession(true).logoutSuccessUrl ("/");
    }
    @Override
    //认证
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("Doromv").password( new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3").and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1").and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3");
    }

}
