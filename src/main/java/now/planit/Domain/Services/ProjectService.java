package now.planit.Domain.Services;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Domain.Models.Project;
import now.planit.Domain.Models.User;

import java.util.ArrayList;

public class ProjectService {
  FacadeMySQL facadeMySQL;

  public ProjectService(FacadeMySQL facadeMySQL) {
    this.facadeMySQL = facadeMySQL;
  }

  public void createProject(String projectName, String start, String finish, int budget, User user) {
    facadeMySQL.createProject(projectName, start, finish, budget, user);
  }

  public ArrayList<Project> getProjects(User user) {
    return facadeMySQL.getProjects(user);
  }


  public void deleteProject(String projectName, User user) {
    facadeMySQL.deleteProject(projectName, user);
  }
}
