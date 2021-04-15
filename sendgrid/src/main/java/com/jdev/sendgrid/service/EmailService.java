package com.jdev.sendgrid.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    @Value("${app.sendgrid.templateId}")
    private String templateId;
    @Autowired
    SendGrid sendGrid;

    public String sendEmail(String email) {
        try {
            Mail mail = prepareMail(email);

            Request request = new Request();

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sendGrid.api(request);
            if(response!=null){
                System.out.println("response code from sendgrid " + response.getStatusCode());
            }
        }
        catch (IOException ie) {
            ie.printStackTrace();
            return "error while sending";
        }
        return "mail sent check inbox";
    }
    public Mail prepareMail(String email) {
        Mail mail = new Mail();
        Email fromEmail = new Email();

        fromEmail.setEmail("itsabhihereman@gmail.com");
        mail.setFrom(fromEmail);
        mail.setReplyTo(fromEmail);
        Email to = new Email();
        to.setEmail(email);
        Personalization personalization = new Personalization();
        personalization.addTo(to);

        mail.addPersonalization(personalization);
        mail.setTemplateId(templateId);

        return mail;
    }
}
