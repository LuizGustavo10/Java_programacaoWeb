package com.algaworks.gp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()
				.anyRequest()//para qualquer url
				.authenticated()//autenticar
			.and()
			.formLogin() //através de um formulário login pronto do próprio spring
				.loginPage("/entrar") //agora tem pagina própria
				.permitAll();//permite acesso
			
			
			
	}

}
