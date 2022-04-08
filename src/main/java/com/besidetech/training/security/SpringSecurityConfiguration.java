package com.besidetech.training.security;

import com.besidetech.training.restmodel.restresources.RestResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration  extends WebSecurityConfigurerAdapter{


    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
            .authorizeRequests()
            .antMatchers(RestResources.REST_USER + "/**").hasRole("ADMIN")
            .antMatchers(RestResources.REST_CHARGE + RestResources.GET_ALL).hasAnyRole("ADMIN")
            .antMatchers(RestResources.REST_CHARGE +RestResources.FIND+RestResources.ID).hasAnyRole("USER")
            .antMatchers("/hellouser").hasAnyRole("ADMIN","USER")
            .and().httpBasic();
    }

}