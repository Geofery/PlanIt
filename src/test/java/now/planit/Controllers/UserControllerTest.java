package now.planit.Controllers;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.UsersRepo;
import now.planit.Domain.Models.User;
import now.planit.Domain.Services.UserService;
import now.planit.Exceptions.UserNotExistException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author roed
 */
class UserControllerTest {
  UserService userService = new UserService(new FacadeMySQL(new UsersRepo(new MapperDB())));
  User user = userService.validateLogin("test@test.com", "test");
  User wrongUser = userService.validateLogin("test@test.com", "21321");
  String expected;

  @Test
  void ValidateCorrectLogin() {
    assertNotNull(user);
  }

  @Test
  void ValidateFailedLogin() {
    assertNull(wrongUser);
  }

  @Test
  void validateLoginEmail() {
    expected = user.getEmail();
    assertEquals(expected, userService.validateLogin("test@test.com", "test").getEmail());
  }

  @Test
  void validateLoginPassword() {
    expected = user.getPassword();
    assertEquals(expected, userService.validateLogin("test@test.com", "test").getPassword());
  }

  @Test
  void registerUser() throws UserNotExistException {
    userService.deleteUser("user@testing.com", "testing");
    userService.registerUser("Junit test", "user@testing.com", "testing");
    assertNotNull(userService.validateLogin("user@testing.com", "testing"));
  }
}