package org.gastpro.api.common.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.gastpro.api.restaurants.domain.Restaurant;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public EmailService(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    public void sendRestaurantWelcomeEmail(String resName, String ownerEmail, String ownerFirstName) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        Context context = new Context();
        context.setVariable("restaurantName", resName);
        context.setVariable("firstName",ownerFirstName);
        String htmlContent = templateEngine.process("restaurant-onboard-email.html", context);

        helper.setTo(ownerEmail);
        helper.setSubject("Restaurant Welcome Email");
        helper.setText(htmlContent,true);

        mailSender.send(mimeMessage);
    }

    public void sendEmployeeOnboardReminder(String employeeEmail) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        Context context = new Context();
        String htmlEmail = templateEngine.process("employee-onboard-email.html",context);
        helper.setTo(employeeEmail);
        helper.setSubject("Complete Employee Account Setup");
        helper.setText(htmlEmail, true);
        mailSender.send(mimeMessage);
    }
}
