package email.application.usecase;


import email.application.usecase.test.adapter.EmailSenderSpyTestAdapter;
import org.example.email.application.SendEmailUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SendEmailUseCaseTest {

    private final EmailSenderSpyTestAdapter emailSender = new EmailSenderSpyTestAdapter();
    private final SendEmailUseCase sendEmailUseCase = new SendEmailUseCase(emailSender);


    @Test
    public void should_send_email_when_passed_new_user_email(){
        String testEmail = "jose@jose.com";

        sendEmailUseCase.execute(testEmail);

        Assertions.assertTrue(emailSender.methodHasBeenExecuteXTimesOrMore(1));
    }
}
