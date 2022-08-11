package com.flightbook.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
		return authenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/auth", "/user", "/rest/flight/{from}/{to}").permitAll()
			.antMatchers("/rest/flight").hasRole("ADMIN")
			.antMatchers("/rest/booking", "/rest/cancelbooking/{user_id}/{booking_id}", "/rest/editbooking").hasRole("USER")
			
			.antMatchers("/signup", "/registration", "/registeruser", "/showflight", "/role", "/addrole").permitAll()
			.antMatchers("/flight", "/addflight",  "/delflight/{flightId}", "/editflight/{flightId}").hasRole("ADMIN")
			.antMatchers("/bookflight/{flightId}(flightId = ${flight.flightId})", "/booking", "/mybooking", "/editBooking/{bookingId}", "/editBooking/{bookingId}", "/mybooking/{bookingId}").hasRole("USER")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/")
			.permitAll()
			.and()
			.logout().permitAll();
	}

	@Override
    public void configure(WebSecurity web) throws Exception {
        web
        	.ignoring()
        	.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**");
    }
}
