//package com.dev.comapp;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends  WebSecurityConfigurerAdapter {
// 
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		return bCryptPasswordEncoder;
//	}
//	
//	
//    @Override
//    protected void configure(AuthenticationManagerBuilder  auth)
//      throws Exception {
//        auth
//          .inMemoryAuthentication()
//          .withUser("user")
//            .password(new BCryptPasswordEncoder().encode("123"))
//            .roles("USER")
//            .and()
//          .withUser("admin")
//            .password(new BCryptPasswordEncoder().encode("123"))
//            .roles("USER", "ADMIN");
//    }
// 
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//          .authorizeRequests()          
//          .antMatchers("/**").hasRole("ADMIN")
//          .and()
//          .formLogin()
//          .loginPage("/login").permitAll()
//          .and()
//          .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
//    }
//}