package com.formmailly.service;

import com.formmailly.dto.ContactFormDTO;
import com.formmailly.util.EmailTemplateBuilder;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailTemplateBuilder emailTemplateBuilder;

    public EmailService(JavaMailSender mailSender, EmailTemplateBuilder emailTemplateBuilder) {
        this.mailSender = mailSender;
        this.emailTemplateBuilder = emailTemplateBuilder;
    }

    public void sendHtmlEmail(ContactFormDTO form) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setTo("ajaynegi3345@gmail.com");
        helper.setSubject("New Contact from: " + form.getName());
        String htmlBody = emailTemplateBuilder.buildEmail(
                form.getName(), form.getEmail(), form.getReason(), form.getMessage()
        );
        helper.setText(htmlBody, true);
        mailSender.send(mimeMessage);
    }
}

