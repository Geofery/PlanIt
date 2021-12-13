package now.planit.Domain.Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author roed
 */
class UserTest {
  User user = new User("Torben", "test@test.com", "1234");
  String expected;

  @Test
  void userIsNull() {
    User userNull = null;
    assertNull(userNull);
  }

  @Test
  void userNotNull() {
    assertNotNull(user);
  }

  @Test
  void getName() {
    expected = "Torben";
    assertEquals(expected, user.getName());
  }

  @Test
  void wrongGetName() {
    expected = "Jens";
    assertNotEquals(expected, user.getName());
  }

  @Test
  void getEmail() {
    expected = "test@test.com";
    assertEquals(expected, user.getEmail());
  }

  @Test
  void wrongGetEmail() {
    expected = "test@test";
    assertNotEquals(expected, user.getEmail());
  }


  @Test
  void getPassword() {
    expected = "1234";
    assertEquals(expected, user.getPassword());
  }

  @Test
  void WrongGetPassword() {
    expected = "5678";
    assertNotEquals(expected, user.getPassword());
  }
}