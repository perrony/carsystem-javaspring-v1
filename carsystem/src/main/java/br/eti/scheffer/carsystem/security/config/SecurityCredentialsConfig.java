package br.eti.scheffer.carsystem.security.config;

import br.eti.scheffer.core.property.JwtConfiguration;

import br.eti.scheffer.token.config.SecurityTokenConfig;
import br.eti.scheffer.token.filter.JwtTokenAuthorizationFilter;
import br.eti.scheffer.token.token.converter.TokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityCredentialsConfig extends SecurityTokenConfig {


	@Autowired
	private TokenConverter tokenConverter;
	
	public SecurityCredentialsConfig(UserDetailsService userDetailsService, TokenConverter tokenConverter,
                                     JwtConfiguration jwtConfiguration) {
		super(jwtConfiguration);
		this.tokenConverter = tokenConverter;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAfter(new JwtTokenAuthorizationFilter(jwtConfiguration, tokenConverter), UsernamePasswordAuthenticationFilter.class);
		super.configure(http);
		
			
	}
}
