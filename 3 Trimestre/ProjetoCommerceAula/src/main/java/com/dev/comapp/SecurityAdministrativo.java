package com.dev.comapp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityAdministrativo extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// neste método que vamos tratar os usuários
		// do banco....
		// auth.inMemoryAuthentication().withUser("user")
		// .password(new BCryptPasswordEncoder().encode("123")).roles("USER")
		// .and().withUser("admin")
		// .password(new BCryptPasswordEncoder()
		// .encode("admin")).roles("USER", "ADMIN");
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select email as username, senha as password, 1 as enable from funcionario where email=?")
				.authoritiesByUsernameQuery(
						"select funcionario.email as username, papel.cargo as authority from permissoes_funcionario inner join funcionario on funcionario.id=permissoes_funcionario.funcionario_id inner join papel on permissoes_funcionario.papel_id=papel.id where funcionario.email=?")
				.passwordEncoder(new BCryptPasswordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/administrativo").hasAnyAuthority("Administrador","Funcionario").
		antMatchers(
				
				"/administrativo/estado/adicionarEstado",
				"/administrativo/estado/estados",
				"/administrativo/cidade/adicionarCidade",
				"/administrativo/cidade/cidades",
				"/administrativo/funcionario/adicionarFuncionario",
				"/administrativo/funcionario/funcionarios",
				"/administrativo/permissoesFuncionario/adicionarPermFunc",
				"/administrativo/permissoesFuncionario/permissoesFuncionarios",
				"/administrativo/papel/adicionarPapeis",
				"/administrativo/papel/papeis",
				"/administrativo/cupomDesconto/AdicionarCupomDes",
				"/administrativo/cupomDesconto/cuponsDes"
				
				
				
				
				).hasAnyAuthority("Administrador").and().formLogin()
				.loginPage("/login").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").and()
				.exceptionHandling().accessDeniedPage("/negado");

	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/login").permitAll()
//		.antMatchers("/administrativo/cadastrar/**").hasAnyAuthority("Administrador")
//		.antMatchers("/administrativo/**").authenticated()
//		.and().formLogin().loginPage("/login").failureUrl("/login").loginProcessingUrl("/administrativo").usernameParameter("username")
//		.passwordParameter("password")
//		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		.logoutSuccessUrl("/login").deleteCookies("JSESSIONID")
//		.and().exceptionHandling().accessDeniedPage("/negado")
//		.and().csrf().disable();
//	}
}
