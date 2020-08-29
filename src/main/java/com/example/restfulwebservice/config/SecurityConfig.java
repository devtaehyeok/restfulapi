package com.example.restfulwebservice.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //{noop} 인코딩 x
        // 보안을 위해 적절한 인코딩 알고리즘 활용 !
        auth.inMemoryAuthentication().withUser("thlim").password("{noop}1234").roles("USER");


    }


}