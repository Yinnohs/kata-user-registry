package user.infrastructure;

import org.example.user.application.GetAllUsers;
import org.example.user.application.RegisterUser;
import org.example.user.application.ports.out.UserRepository;
import org.example.user.domain.entities.User;
import org.example.user.infrastructure.controller.UserController;
import org.example.user.infrastructure.repository.UserInMemoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AcceptanceRegistrationTests {
    @Test
    public void should_register_an_user_when_passed_correct_email_password(){
        //given
        UserRepository repository = new UserInMemoryRepository();
        RegisterUser registerUseCase = new RegisterUser(repository);
        GetAllUsers getAllUsersUseCase = new GetAllUsers(repository);
        UserController  controller = new UserController(getAllUsersUseCase,registerUseCase);

        String correctEmail = "jose@jose.com";
        String correctPassword = "jose_123";
        //when

        var result = controller.registerUser(correctEmail, correctPassword);

        //then
        Assertions.assertInstanceOf(User.class, result);
    }
}
