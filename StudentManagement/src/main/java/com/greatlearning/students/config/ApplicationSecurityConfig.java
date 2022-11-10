package com.greatlearning.students.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.students.service.UserDetailsServiceImpl;

@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Bean
	public UserDetailsService userDetailService()
	{
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService());
		provider.setPasswordEncoder(passwordEncoder());	
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception 
	{		
		authenticationManagerBuilder.authenticationProvider(authenticationProvider());
	}

	//authorization
	@Override
	public void configure(WebSecurity web) throws Exception 
	{
		web.ignoring().antMatchers("/h2-console/**");
	}
	
	//authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests()
		.antMatchers("/", "/student/save","/student/showFormForAdd", "/student/403").hasAnyAuthority("USER", "ADMIN")
		.antMatchers("/student/showFormForUpdate","/student/delete").hasAnyAuthority("ADMIN")
		.anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login").successForwardUrl("/student/list").permitAll()
		.and().exceptionHandling().accessDeniedPage("/student/403")
		.and().cors().and().csrf().disable();
	}
}
