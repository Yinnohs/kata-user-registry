package org.example.user.infrastructure.adapter;

import org.example.email.application.SendEmailUseCase;
import org.example.user.application.ports.in.UserEmailSender;

public class UserEmailSenderAdapter implements UserEmailSender {

    private final SendEmailUseCase sendEmailUseCase;

    public UserEmailSenderAdapter(SendEmailUseCase sendEmailUseCase) {
        this.sendEmailUseCase = sendEmailUseCase;
    }

    @Override
    public void sendEmailToNewCreatedUser(String email) {
        sendEmailUseCase.execute(email);
    }
}
