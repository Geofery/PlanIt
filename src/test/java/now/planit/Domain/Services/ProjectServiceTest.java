package now.planit.Domain.Services;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.ProjectRepo;
import now.planit.Domain.Models.Project;
import now.planit.Domain.Models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author roed
 */
class ProjectServiceTest {
  FacadeMySQL facadeMySQL = new FacadeMySQL(new ProjectRepo(new MapperDB()));
  User user = facadeMySQL.validateLogin("user@testing.com","testing");
  Project project = new Project("Junit Project", "2021-12-10", "2021-12-17", 20000);
  ArrayList<Project> actual = facadeMySQL.getProjects(user);
  String expected;

  @Test
  void createProject() {
    facadeMySQL.deleteProject(project.getName(), user);
    //Expected
    facadeMySQL.createProject("Junit Project", "2021-12-10", "2021-12-17", 20000, user);
    for (int i = 0; i < actual.size(); i++) {
      if (actual.get(i).equals(project)) {
        assertEquals(project, actual.get(i));
      }
    }
  }

  @Test
  void deleteProject() {
    facadeMySQL.createProject("Junit Project", "2021-12-10", "2021-12-17", 20000, user);
    facadeMySQL.deleteProject(project.getName(), user);

    expected = null;
    for (int i = 0; i < actual.size(); i++) {
      if (actual.get(i).getName().equals("Junit Project")) {
        assertEquals(expected, actual.get(i).getName());
      }
    }
    facadeMySQL.createProject("Junit Project", "2021-12-10", "2021-12-17", 20000, user);
  }
}