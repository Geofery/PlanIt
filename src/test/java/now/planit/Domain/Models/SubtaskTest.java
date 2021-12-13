package now.planit.Domain.Models;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author roed
 */
class SubtaskTest {
  Subtask subtask = new Subtask("Test", 10, 1000);
  String expected;
  int expectedInt;


  @Test
  void getSubtaskName() {
    expected = "Test";
    assertEquals(expected, subtask.getSubtaskName());
  }

  @Test
  void wrongGetSubtaskName() {
    expected = "est";
    assertNotEquals(expected, subtask.getSubtaskName());
  }


  @Test
  void getHours() {
    expectedInt = 10;
    assertEquals(expectedInt, subtask.getHours());
  }

  @Test
  void getCost() {
    expectedInt = 1000;
    assertEquals(expectedInt, subtask.getCost());
  }
}