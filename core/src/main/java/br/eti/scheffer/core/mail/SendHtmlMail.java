package br.eti.scheffer.core.mail;



import br.eti.scheffer.core.exception.BadRequestException;

import lombok.extern.slf4j.Slf4j;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;


@Slf4j
public class SendHtmlMail {

    public void send(PreMail preMail){

        Email email = EmailBuilder.startingBlank()
                .from(preMail.getNameFrom(),preMail.getAddressFrom())
                .to(preMail.getNameTo(),preMail.getAddressTo())
                .withHTMLText(preMail.getBodyHtml())
                .withSubject(preMail.getSubject())
                .buildEmail();

        try {
            MailerBuilder.withSMTPServer(preMail.getSmtp(),preMail.getPort(),preMail.getUsername(),preMail.getPassword())
                    .buildMailer()
                    .sendMail(email);
            log.info("Email enviado");
        } catch (Exception e){
            throw new BadRequestException("Falha ao enviar email");
        }

    }


}
