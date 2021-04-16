package tn.mi.spring.service;

import java.io.File;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tn.mi.spring.entities.Mail;

@Service
public class MailServiceImpl {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(Mail mail) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getSendTo());
        msg.setFrom(mail.getFrom());
        msg.setSubject(mail.getSubject());
        msg.setText(mail.getMessage());

        javaMailSender.send(msg);

}
	public void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo("khouloudabd513@gmail.com");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for document pdf!</h1>", true);

		// hard coded a file path
        FileSystemResource file = new FileSystemResource(new File("file:///C:/Users/USER/Documents/Document-sans-titre.pdf"));

        helper.addAttachment("Document-sans-titre.pdf", file);

        javaMailSender.send(msg);

    }
	

}
