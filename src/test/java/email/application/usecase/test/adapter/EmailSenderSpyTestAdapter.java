package email.application.usecase.test.adapter;

import org.example.email.application.ports.out.EmailSender;

public class EmailSenderSpyTestAdapter implements EmailSender {

    private long methodExecuteTimes = 0L;

    @Override
    public void sendEmail(String email) {
        System.out.println("EMAIL SENDED TO: " + email);
        methodExecuteTimes ++;
    }

    public boolean methodHasBeenExecuteXTimesOrMore(long expectedExecutions){
        return expectedExecutions <= methodExecuteTimes;
    }
}
