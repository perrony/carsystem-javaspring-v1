package br.eti.scheffer.token.filter;


import br.eti.scheffer.core.property.JwtConfiguration;
import br.eti.scheffer.token.token.converter.TokenConverter;
import br.eti.scheffer.token.util.SecurityContextUtil;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@RequiredArgsConstructor
public class JwtTokenAuthorizationFilter extends OncePerRequestFilter{
	
	@Autowired
	protected JwtConfiguration jwtConfiguration;
	
	@Autowired
	protected TokenConverter tokenConverter;
	

	@Override
	@SneakyThrows
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain)
			throws ServletException, IOException {
		String header = request.getHeader(jwtConfiguration.getHeader().getName());
		
		if(header == null || !header.startsWith(jwtConfiguration.getHeader().getPrefix())) {
			chain.doFilter(request, response);
			return;
		}
		
		String token = header.replace(jwtConfiguration.getHeader().getPrefix(), "").trim();
		
		SecurityContextUtil.setSecurityContext(StringUtils.equalsIgnoreCase("signed", jwtConfiguration.getType()) ? validate(token) : decryptValidating(token));
		
		chain.doFilter(request, response);
		
	}
	
	private SignedJWT decryptValidating(String encryptedToken) throws ParseException {
		String signedToken = tokenConverter.decryptToken(encryptedToken);
		tokenConverter.validateTokenSignature(signedToken);
		return SignedJWT.parse(signedToken);
	}
	
	private SignedJWT validate(String signedToken) throws ParseException {
		tokenConverter.validateTokenSignature(signedToken);
		return SignedJWT.parse(signedToken);
		
	}

	public JwtTokenAuthorizationFilter(JwtConfiguration jwtConfiguration, TokenConverter tokenConverter) {
		super();
		this.jwtConfiguration = jwtConfiguration;
		this.tokenConverter = tokenConverter;
	}

}
