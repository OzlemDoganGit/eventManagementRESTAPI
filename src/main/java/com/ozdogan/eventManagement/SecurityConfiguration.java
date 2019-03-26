package com.ozdogan.eventManagement;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder user = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(user.username("ozlem").password("ozlem").roles("USER"))		
		.withUser(user.username("admin").password("admin").roles("ADMIN"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.POST, "/events").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/events/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.PATCH, "/events/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/events").hasRole("USER")
		.and().csrf().disable();

	}

}
