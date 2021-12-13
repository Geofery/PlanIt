package now.planit.Domain.Models;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author roed
 */
class TaskTest {
  Task task = new Task("New Task", "2021-12-07", "2021-12-08", 8, 1000);
  String expected;
  int expectedInt;

  @Test
  void taskNotNull() {
    assertNotNull(task);
  }

  @Test
  void getTaskName() {
    expected = "New Task";
    assertEquals(expected, task.getTaskName());
  }

  @Test
  void wrongGetTaskName() {
    expected = "New";
    assertNotEquals(expected, task.getTaskName());
  }

  @Test
  void getStartDate() {
    expected = "2021-12-07";
    assertEquals(expected, task.getStartDate());
  }

  @Test
  void wrongGetStartDate() {
    expected = "2021-12-10";
    assertNotEquals(expected, task.getStartDate());
  }

  @Test
  void getFinishDate() {
    expected = "2021-12-08";
    assertEquals(expected, task.getFinishDate());
  }

  @Test
  void wrongGetFinishDate() {
    expected = "2021-12-10";
    assertNotEquals(expected, task.getFinishDate());
  }

  @Test
  void getHours() {
    expectedInt = 8;
    assertEquals(expectedInt, task.getHours());
  }

  @Test
  void wrongGetHours() {
    expectedInt = 10;
    assertNotEquals(expectedInt, task.getHours());
  }

  @Test
  void getCost() {
    expectedInt = 1000;
    assertEquals(expectedInt, task.getCost());
  }

  @Test
  void wrongGetCost() {
    expectedInt = 5000;
    assertNotEquals(expectedInt, task.getCost());
  }
}