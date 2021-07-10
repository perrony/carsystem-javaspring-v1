package br.eti.scheffer.core.mail;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class PreMail {

    private String nameFrom;
    private String addressFrom;
    private String nameTo;
    private String addressTo;
    private String bodyHtml;
    private String subject;
    private String smtp;
    private Integer port;
    private String username;
    private String password;


}
