package org.example.email.infrastructure.adapter;

import org.example.email.application.ports.out.EmailSender;

public class EmailSenderMockAdapter implements EmailSender {

    @Override
    public void sendEmail(String email) {
        System.out.println("SENDED EMAIL TO: " + email);
    }
}
