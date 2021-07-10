package br.eti.scheffer.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;


@Slf4j
public class PasswordUtils {
	
	public PasswordUtils() {
	}
	
	public static String gerarBCrypt(String password) {

		if (password == null) {
			return password;
		}

		log.info("Gerando hash com o BCrypt.");
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(password);
	}

    public static String encode64(String password){
		return Base64.getEncoder().encodeToString(password.getBytes());
	}

	public static String decode64(String password){
		return new String(Base64.getDecoder().decode(password));
	}

}
