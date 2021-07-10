package br.eti.scheffer.auth.security.config;

import br.eti.scheffer.auth.security.filter.JwtUsernameAndPasswordAuthenticationFilter;

import br.eti.scheffer.core.property.JwtConfiguration;
import br.eti.scheffer.token.config.SecurityTokenConfig;
import br.eti.scheffer.token.filter.JwtTokenAuthorizationFilter;
import br.eti.scheffer.token.token.converter.TokenConverter;
import br.eti.scheffer.token.token.creator.TokenCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityCredentialsConfig extends SecurityTokenConfig {

	@Qualifier("userDetailsServiceImpl")
	private UserDetailsService userDetailsService;
	
	private TokenCreator tokenCreator;
	
	private TokenConverter tokenConverter;
	
	
	public SecurityCredentialsConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService, TokenCreator tokenCreator,
                                     JwtConfiguration jwtConfiguration) {
		super(jwtConfiguration);
		this.userDetailsService = userDetailsService;
		this.tokenCreator = tokenCreator;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			
			.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(),jwtConfiguration, tokenCreator))
			.addFilterAfter(new JwtTokenAuthorizationFilter(jwtConfiguration, tokenConverter), UsernamePasswordAuthenticationFilter.class);
		super.configure(http);
		
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
