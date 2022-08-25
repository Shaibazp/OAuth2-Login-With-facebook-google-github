package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter
{
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.inMemoryAuthentication().withUser("www").password("{noop}www").authorities("ADMIN");
	}

	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests()
		.antMatchers("/all", "/data").permitAll()
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		
		.and()
		.oauth2Login()
		
		.and()
		.csrf().disable();
	}
}
