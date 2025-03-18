package org.example.user.application;

import org.example.user.application.ports.out.EmailSender;

public class SendEmailUseCase {
    private final EmailSender emailSender;

    public SendEmailUseCase(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void execute (String email) {
        emailSender.sendEmail(email);
    }
}
