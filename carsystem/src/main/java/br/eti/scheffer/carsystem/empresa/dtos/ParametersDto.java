package br.eti.scheffer.carsystem.empresa.dtos;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParametersDto {


    private Long id;

    @NotNull(message = "Definiçao do servidor SMTP nao pode ser vazio")
    private String smtp;

    @NotNull(message = "A porta do servidor SMTP nao pode ser vazio")
    private Integer port;

    @NotNull(message = "Email do remetente nao pode ser vazio")
    private String addressFrom;

    @NotNull(message = "Nome de usuario na autenticaçao do SMTP nao pode ser vazio")
    private String username;

    @NotNull(message = "Senha do usuario e requerido")
    private String password;

}
