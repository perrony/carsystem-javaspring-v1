package br.eti.scheffer.token.token.creator;


import br.eti.scheffer.core.entities.ApplicationUser;
import br.eti.scheffer.core.property.JwtConfiguration;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Slf4j
@AllArgsConstructor
public class TokenCreator {
	

	protected JwtConfiguration jwtConfiguration;

	public SignedJWT createSignedJWT(Authentication auth) {
		log.info("Starting to create the signed JWT");
		
		ApplicationUser applicationUser = (ApplicationUser) auth.getPrincipal();
		JWTClaimsSet jwtClaimSet = createJWTClaimsSet(auth, applicationUser);
		
		KeyPair rsaKeys = generateKeyPair();
		
		log.info("Building JWK from the RSA Keys");
		
		JWK jwk = new RSAKey.Builder((RSAPublicKey) rsaKeys.getPublic()).keyID(UUID.randomUUID().toString()).build();
		
		SignedJWT signedJWT = new SignedJWT(new JWSHeader.Builder(JWSAlgorithm.RS256).jwk(jwk).type(JOSEObjectType.JWT).build(), jwtClaimSet);
		
		log.info("Signing the token with the private RSA Key");
		
		RSASSASigner signer = new RSASSASigner(rsaKeys.getPrivate());
		
		try {
			signedJWT.sign(signer);
			log.info("Serialized token '{}'", signedJWT.serialize());
			
			return signedJWT;
		} catch (JOSEException e) {
			e.getMessage();
			return null;
		}
		
		
	}
	
	private JWTClaimsSet createJWTClaimsSet(Authentication auth, ApplicationUser applicationUser) {
		log.info("Creating the JwtClaimSet Object for '{}'", applicationUser);
		return new JWTClaimsSet.Builder()
				.subject(applicationUser.getUsername())
				.claim("authorities", auth.getAuthorities()
						.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.claim("userId", applicationUser.getId())
				.issuer("http://www.scheffer.eti.br")
				.issueTime(new Date())
				.expirationTime(new Date(System.currentTimeMillis() + (jwtConfiguration.getExpiration() * 1000)))
				.build();
	}

	private KeyPair generateKeyPair() {
		log.info("Generating RSA 2048 bits Keys");
		
		KeyPairGenerator generator;
		try {
			generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);
			return generator.genKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.getMessage();
			return null;
		}
		
		
	}
	
	public String encryptToken(SignedJWT signedJWT) throws KeyLengthException {
		
		log.info("Starting the encrypToken method");
		
		DirectEncrypter encrypter = new DirectEncrypter(jwtConfiguration.getPrivateKey().getBytes());
		
		JWEObject jweObject = new JWEObject(new JWEHeader.Builder(JWEAlgorithm.DIR, EncryptionMethod.A128CBC_HS256)
				.contentType("JWT")
				.build(), new Payload(signedJWT));
		
		log.info("Encrypting token with system's private key");
		
		try {
			jweObject.encrypt(encrypter);
		} catch (JOSEException e) {
			e.printStackTrace();
		}
		
		return jweObject.serialize();
		
	}
	
}
