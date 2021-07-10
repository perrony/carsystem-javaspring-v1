package br.eti.scheffer.token.config;



import br.eti.scheffer.core.property.JwtConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	protected JwtConfiguration jwtConfiguration;

	@Autowired
	protected CorsConfigurationSource corsConfigurationSource;
	
	public SecurityTokenConfig(JwtConfiguration jwtConfiguration) {
		super();
		this.jwtConfiguration = jwtConfiguration;
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.cors()
			.configurationSource(corsConfigurationSource)
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.exceptionHandling().authenticationEntryPoint((req,resp,e)->resp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
			.and()
			.authorizeRequests()
			.antMatchers(jwtConfiguration.getLoginUrl(),"/**/swagger-ui.html").permitAll()
			.antMatchers(HttpMethod.GET,"/**/swagger-resources/**","/**/webjars/springfox-swagger-ui/**","/**/v2/api-docs/**").permitAll()
			.antMatchers("/auth/user/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/register/**").permitAll()
			.antMatchers("/fipe/**").authenticated()
			.antMatchers("/empresa/**").authenticated()
			.antMatchers("/roles/**").authenticated()
			.antMatchers("/confirm/**").permitAll()
				.antMatchers("/cep/**").permitAll()
			.anyRequest().authenticated();
			
			
	}
	
	
	  @Bean
	  public CorsConfigurationSource corsConfigurationSource() {
	  
		  CorsConfiguration configuration = new CorsConfiguration();
		  configuration.setAllowCredentials(true);
		  configuration.applyPermitDefaultValues();
		  configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT","DELETE"));
		  configuration.setAllowedHeaders(Arrays.asList("X-Requested-With","Origin","Content-Type","Accept","Authorization", "Access-Control-Allow-Origin"));
		  
		  // This allow us to expose the headers
		  configuration.setExposedHeaders(Arrays.asList("Access-Control-Allow-Headers",
		  "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
		  "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers"));
		  
		  UrlBasedCorsConfigurationSource source = new
		  UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
		  configuration); return source; 
	  }
	 
		/*
		 * .antMatchers("/roles/**").hasRole("ADMIN")
		 * .antMatchers("/contatocliente/**").hasRole("ADMIN")
		 * .antMatchers("/users/**").hasRole("ADMIN")
		 */

	
}
