package org.example.email.application;

import org.example.email.application.ports.out.EmailSender;

public class SendEmailUseCase {
    private final EmailSender emailSender;

    public SendEmailUseCase(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void execute (String email) {
        emailSender.sendEmail(email);
    }
}
