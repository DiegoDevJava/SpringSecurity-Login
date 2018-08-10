package br.com.devjava.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDetailsServiceImpl usuarioDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		if (auth != null)
			auth.userDetailsService(usuarioDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		if (http != null) {

			http.authorizeRequests()
				.antMatchers("/", "/home").hasAnyAuthority("ROLE_ADMIN", "ROLE_PACIENTE", "ROLE_MEDICO")
				.anyRequest()
				.authenticated();

			http
				.exceptionHandling().accessDeniedPage("/acessonegado")
			.and()
				.formLogin()
					.loginPage("/login").permitAll();

			/* Arquivos estaticos */
			http.authorizeRequests().antMatchers("/css/**").permitAll().anyRequest().permitAll();

		}
	}
}
