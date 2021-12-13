package now.planit.Domain.Services;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.SubtaskRepo;
import now.planit.Domain.Models.Subtask;
import now.planit.Domain.Models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author roed
 */
class SubtaskServiceTest {
  FacadeMySQL facadeMySQL = new FacadeMySQL(new SubtaskRepo(new MapperDB()));
  User user = facadeMySQL.validateLogin("user@testing.com", "testing");
  Subtask subtask = new Subtask("Junit Subtask", 10, 5000);
  String expected;

  @Test
  void createSubtask() {
    facadeMySQL.createSubtask("Junit Subtask", 10, 5000, "Junit Task");
    expected = "Junit Subtask";
    assertEquals(expected, facadeMySQL.getSubtasks("Junit task", user).get(0).getSubtaskName());
    facadeMySQL.deleteSubtask("Junit test", "Junit Subtask", user);
  }

  @Test
  void deleteSubtask() {
    facadeMySQL.createSubtask("Junit Subtask", 10, 5000, "Junit Task");
facadeMySQL.deleteSubtask("Junit Task", "Junit Subtask", user);
assertFalse(facadeMySQL.getSubtasks("Junit Task", user).contains(subtask));
  }
}