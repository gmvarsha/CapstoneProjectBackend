package com.example.userManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
    private JavaMailSender emailSender;

	@Async
    public void sendCheckInNotification(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("capstone16071997@gmail.com");
        message.setTo(to);
        message.setCc("capstone16071997@gmail.com");
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
