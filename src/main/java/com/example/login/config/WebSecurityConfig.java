package com.example.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf().disable()      //CSRF 공격에 대한 방어를 '해제'
                .authorizeRequests()  //권한 부여 시작
                .antMatchers("/user/**").authenticated()  //인증필요 URI
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")// (권한) 인가 필요 URI
                .anyRequest().permitAll()
                .and()
                .formLogin() // 폼 로그인에 의한... 아래 정보 세팅 가능
                .loginPage("/login")// 리다이렉트 to 로그인 페이지
                .loginProcessingUrl("/loginProc")
                .defaultSuccessUrl("/")
                .and().build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
