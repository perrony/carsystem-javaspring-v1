package br.eti.scheffer.auth.security.filter;

import br.eti.scheffer.core.entities.ApplicationUser;
import br.eti.scheffer.core.property.JwtConfiguration;
import br.eti.scheffer.token.token.creator.TokenCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Slf4j
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtConfiguration jwtConfiguration;
	
	@Autowired
	private TokenCreator tokenCreator;

	public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager,
                                                      JwtConfiguration jwtConfiguration,
                                                      TokenCreator tokenCreator) {
		this.authenticationManager = authenticationManager;
		this.jwtConfiguration = jwtConfiguration;
		this.tokenCreator = tokenCreator;
	}
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		log.info("Attempting authentication...");
		
			try {
				
				ApplicationUser applicationUser  = new ObjectMapper().readValue(request.getInputStream(), ApplicationUser.class);
				
				log.info("Creating the authentication object for the user '{}' and calling UserDetailServiceImpl loadUserByUsername", applicationUser.getEmail());

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
				new UsernamePasswordAuthenticationToken(applicationUser.getEmail(), applicationUser.getPassword(), Collections.emptyList());
				
				usernamePasswordAuthenticationToken.setDetails(applicationUser);
				
				return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
				
			} catch (IOException e) {
				throw new UsernameNotFoundException("Unable to retrieve the username or password " + e.getMessage());
			}
		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		log.info("Authentication was successful for the user '{}', generating JWE token ", auth.getName());

		SignedJWT signedJWT = tokenCreator.createSignedJWT(auth);
		
		try {
			String encryptedToken = tokenCreator.encryptToken(signedJWT);
			log.info("Token generated successfully, adding it to the response header");
			
			response.addHeader("Access-Control-Expose-header", "XSRF-TOKEN, "+jwtConfiguration.getHeader().getName());
			
			response.addHeader(jwtConfiguration.getHeader().getName(), jwtConfiguration.getHeader().getPrefix() + encryptedToken);
			
			
		} catch (KeyLengthException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
