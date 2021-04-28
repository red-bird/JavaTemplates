package com.redbird.lesson24.notifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmailNotifier implements NotifyService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailNotifier(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String email;


    @Async
    @Override
    public void send(String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(email);
        mailMessage.setTo(email);
        mailMessage.setSubject("lesson21 server: adding entity");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }

}
