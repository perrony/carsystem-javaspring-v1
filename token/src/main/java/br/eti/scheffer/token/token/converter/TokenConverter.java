package br.eti.scheffer.token.token.converter;

import br.eti.scheffer.core.property.JwtConfiguration;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.SignedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.text.ParseException;


@Service
public class TokenConverter {
	
	private static final Logger log = LoggerFactory.getLogger(TokenConverter.class);
	
	@Autowired
	private JwtConfiguration jwtConfiguration;

	/**
	 * Descript token to token signed
	 * 
	 * @param encryptedToken
	 * @return
	 */
	public String decryptToken(String encryptedToken) {
		log.info("Decrypting token");
		
		try {
			JWEObject jweObject = JWEObject.parse(encryptedToken);
			
			DirectDecrypter directDecrypter = new DirectDecrypter(jwtConfiguration.getPrivateKey().getBytes());
			jweObject.decrypt(directDecrypter);
			log.info("Token decrypted, returning signed token");
			return jweObject.getPayload().toSignedJWT().serialize();
			
			
		} catch (ParseException |  JOSEException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
	/**
	 * Validando assinatura do token
	 * 
	 * @param signedToken
	 */
	public void validateTokenSignature(String signedToken) {
		log.info("Starting method to validate token signature");
		
		try {
			SignedJWT signedJWT = SignedJWT.parse(signedToken);
			log.info("Token parsed! Retrieving public key from signed token");
			RSAKey publicKey = RSAKey.parse(signedJWT.getHeader().getJWK().toJSONObject());
			log.info("Public key retrieved, validating signature");
			
			if(!signedJWT.verify(new RSASSAVerifier(publicKey))) {
				throw new AccessDeniedException("Invalid token signature!");
			}
			
			log.info("The token has a valid signature");
			
		} catch (ParseException | AccessDeniedException | JOSEException e) {
			e.printStackTrace();
		}
		
	}
}
