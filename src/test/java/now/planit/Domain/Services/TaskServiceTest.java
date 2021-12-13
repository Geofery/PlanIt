package now.planit.Domain.Services;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.TaskRepo;
import now.planit.Domain.Models.Task;
import now.planit.Domain.Models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author roed
 */
class TaskServiceTest {
  FacadeMySQL facadeMySQL = new FacadeMySQL(new TaskRepo(new MapperDB()));
  User user = facadeMySQL.validateLogin("user@testing.com", "testing");
  ArrayList<Task> tasks = facadeMySQL.getTasks("Junit Project", user);
  String expected;

  @Test
  void createTaskName() {
    facadeMySQL.deleteTask("Junit Project", "Junit Task", user);
    facadeMySQL.createTask("Junit Task","2021-12-13","2021-12-14", "Junit Project", user);
  expected = "Junit Task";
    for (int i = 0; i < tasks.size(); i++) {
      if (tasks.get(i).getTaskName().equals(expected)){
        assertEquals(expected, tasks.get(i).getTaskName());
      }
    }
  }

  @Test
  void createTaskStart() {
    facadeMySQL.deleteTask("Junit Project", "Junit Task", user);
    facadeMySQL.createTask("Junit Task","2021-12-13","2021-12-14", "Junit Project", user);
    expected = "2021-12-13";
    for (int i = 0; i < tasks.size(); i++) {
      if (tasks.get(i).getTaskName().equals(expected)){
        assertEquals(expected, tasks.get(i).getStartDate());
      }
    }
  }

  @Test
  void createTaskFinish() {
    facadeMySQL.deleteTask("Junit Project", "Junit Task", user);
    facadeMySQL.createTask("Junit Task","2021-12-13","2021-12-14", "JUnit Project", user);
    expected = "2021-12-14";
    for (int i = 0; i < tasks.size(); i++) {
      if (tasks.get(i).getTaskName().equals(expected)){
        assertEquals(expected, tasks.get(i).getFinishDate());
      }
    }
  }

  @Test
  void deleteTask() {
    facadeMySQL.deleteTask("Junit Project", "Junit Task", user);
    expected = "Junit Task";
    for (int i = 0; i < tasks.size(); i++) {
      if (tasks.get(i).getTaskName().equals("Junit Task")){
        assertEquals(expected, tasks.get(i).getTaskName());
      }
    }
    facadeMySQL.createTask("Junit Task","2021-12-13","2021-12-14", "Junit Project", user);
  }
}