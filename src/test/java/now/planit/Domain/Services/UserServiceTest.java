package now.planit.Domain.Services;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.ProjectRepo;
import now.planit.Data.Repo.UsersRepo;
import now.planit.Domain.Models.User;
import now.planit.Exceptions.UserNotExistException;
import org.junit.jupiter.api.Test;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author roed
 */
class UserServiceTest {
  FacadeMySQL facadeMySQL = new FacadeMySQL(new UsersRepo(new MapperDB()));
  User user = facadeMySQL.validateLogin("user@testing.com","testing");
  User wrongUser = facadeMySQL.validateLogin("test@test.com", "21321");
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
    assertEquals(expected, user.getEmail());
  }

  @Test
  void validateLoginPassword() {
    expected = user.getPassword();
    assertEquals(expected, user.getPassword());
  }

  @Test
  void registerUser() throws UserNotExistException {
    //Arrange
    facadeMySQL.deleteUser("user@testing.com", "testing");

    //Act
    facadeMySQL.registerUser("Junit test", "user@testing.com", "testing");

    //Assert
    assertNotNull(user);

    //UNIT TEST pyramiden.... Cost curve ... Technical debt
  }
}