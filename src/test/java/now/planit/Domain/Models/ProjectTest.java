package now.planit.Domain.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author roed
 */
class ProjectTest {
  Project project = new Project("Test","2021-11-29","2021-12-16", 10000);
  String expected;
  int expectedInt;


  @Test
  void getProjectName() {
    expected = "Test";
    assertEquals(expected, project.getName());
  }

  @Test
  void wrongGetProject() {
    expected = "est";
    assertNotEquals(expected, project.getName());
  }

  @Test
  void getStart() {
    expected = "2021-11-29";
    assertEquals(expected, project.getStart());
  }

  @Test
  void getFinish() {
    expected = "2021-12-16";
    assertEquals(expected, project.getFinish());
  }

  @Test
  void getBudget() {
    expectedInt = 10000;
    assertEquals(expectedInt, project.getBudget());
  }
}