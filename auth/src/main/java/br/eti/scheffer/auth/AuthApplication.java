package br.eti.scheffer.auth;

import br.eti.scheffer.core.property.JwtConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan({
        "br.eti.scheffer.core.entities"
})
@EnableJpaRepositories({
        "br.eti.scheffer.core.repositories"
})
@ComponentScan("br.eti.scheffer")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties(value = JwtConfiguration.class)
@EnableEurekaClient
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
