package com.algaworks.gp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
@Configuration
public class InMemorySecurityConfig {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder//configurando dois usuários
			.inMemoryAuthentication()
			.withUser("carlos").password("123").roles("PG_PROJETOS","PG_REL_CUSTOS", "PG_REL_EQUIPE")//regras referente ao webSecurityConfig
			.and()
			.withUser("flavio").password("123").roles("PG_REL_EQUIPE");
	}

}
