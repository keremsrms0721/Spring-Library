package com.ozguryazilim.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ozguryazilim.business.service.impl.UserDetailsServiceImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
		securedEnabled = true
	)
public class SecurityMatcher extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
			
	        .authorizeRequests()
		.antMatchers
				("/",
				"/home",
				"/frontend/login",
				"/frontend/signup",
				"/photos/**",
				"/mycss/**",
				"/js/**").permitAll()
		.antMatchers("/user/**","/frontend/**").hasAnyRole("USER","ADMIN","DEPOCU")
		.antMatchers("/admin/publisher/**").hasAnyRole("DEPOCU","ADMIN")
		.antMatchers("/rest/publisher/save").hasAnyRole("DEPOCU","ADMIN")
		.antMatchers("/admin/**","/rest/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
			.formLogin()
			.loginPage("/frontend/login")
			.defaultSuccessUrl("/frontend/home")
			.and()
			.logout()
			.logoutSuccessUrl("/frontend/logout")
			.and()
			.csrf().disable().cors();
	}
	@Autowired
	public void createUser(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.userDetailsService(service())
			.passwordEncoder(passwordEncoder())
			
			;
	}
	@Bean
	public UserDetailsService service() {
		return new UserDetailsServiceImpl();	
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
