package user.infrastructure;

import org.example.user.application.GetAllUsers;
import org.example.user.application.RegisterUser;
import org.example.user.application.ports.out.UserRepository;
import org.example.user.domain.entities.User;
import org.example.user.domain.exceptions.IncorrectCredentialsException;
import org.example.user.infrastructure.controller.UserController;
import org.example.user.infrastructure.repository.UserInMemoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class AcceptanceRegistrationTests {
    @Test
    public void should_register_an_user_when_passed_correct_email_and_password(){
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

    @Test
    public void should_not_register_when_passed_only_numerical_password(){
        //given
        UserRepository repository = new UserInMemoryRepository();
        RegisterUser registerUseCase = new RegisterUser(repository);
        GetAllUsers getAllUsersUseCase = new GetAllUsers(repository);
        UserController  controller = new UserController(getAllUsersUseCase,registerUseCase);

        String correctEmail = "jose@jose.com";
        String wrongPassword= "12345678";
        //when

         Executable result = ()-> controller.registerUser(correctEmail, wrongPassword);

        Assertions.assertThrows(IncorrectCredentialsException.class, result);
    }

    @Test
    public void should_not_register_when_passed_only_characters_password(){
        //given
        UserRepository repository = new UserInMemoryRepository();
        RegisterUser registerUseCase = new RegisterUser(repository);
        GetAllUsers getAllUsersUseCase = new GetAllUsers(repository);
        UserController  controller = new UserController(getAllUsersUseCase,registerUseCase);

        String correctEmail = "jose@jose.com";
        String wrongPassword= "abcdefghijk";
        //when

        Executable result = ()-> controller.registerUser(correctEmail, wrongPassword);

        Assertions.assertThrows(IncorrectCredentialsException.class, result);
    }

    @Test
    public void should_not_register_when_passed_password_without_underscore(){
        //given
        UserRepository repository = new UserInMemoryRepository();
        RegisterUser registerUseCase = new RegisterUser(repository);
        GetAllUsers getAllUsersUseCase = new GetAllUsers(repository);
        UserController  controller = new UserController(getAllUsersUseCase,registerUseCase);

        String correctEmail = "jose@jose.com";
        String wrongPassword= "jose1234";
        //when

        Executable result = ()-> controller.registerUser(correctEmail, wrongPassword);

        Assertions.assertThrows(IncorrectCredentialsException.class, result);
    }

    @Test
    public void should_not_register_when_passed_password_has_less_than_eight_characters(){
        //given
        UserRepository repository = new UserInMemoryRepository();
        RegisterUser registerUseCase = new RegisterUser(repository);
        GetAllUsers getAllUsersUseCase = new GetAllUsers(repository);
        UserController  controller = new UserController(getAllUsersUseCase,registerUseCase);

        String correctEmail = "jose@jose.com";
        String wrongPassword= "123_jos";
        //when

        Executable result = ()-> controller.registerUser(correctEmail, wrongPassword);

        Assertions.assertThrows(IncorrectCredentialsException.class, result);
    }

    @Test
    public void should_not_register_when_passed_wrong_email(){
        //given
        UserRepository repository = new UserInMemoryRepository();
        RegisterUser registerUseCase = new RegisterUser(repository);
        GetAllUsers getAllUsersUseCase = new GetAllUsers(repository);
        UserController  controller = new UserController(getAllUsersUseCase,registerUseCase);

        String correctEmail = "josejose.com";
        String wrongPassword= "123_jose";
        //when

        Executable result = ()-> controller.registerUser(correctEmail, wrongPassword);

        Assertions.assertThrows(IncorrectCredentialsException.class, result);
    }

    @Test
    public void should_find_user_when_created(){
        //given
        UserRepository repository = new UserInMemoryRepository();
        RegisterUser registerUseCase = new RegisterUser(repository);
        GetAllUsers getAllUsersUseCase = new GetAllUsers(repository);
        UserController  controller = new UserController(getAllUsersUseCase,registerUseCase);

        String correctEmail = "jose@jose.com";
        String correctPassword = "jose_123";
        var expectedUser = controller.registerUser(correctEmail, correctPassword);
        //when

        var result = controller.findAllUsers();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedUser, result.get(0));
    }
}
