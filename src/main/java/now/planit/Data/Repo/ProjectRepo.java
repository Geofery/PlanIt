package now.planit.Data.Repo;

import now.planit.Domain.Models.Project;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ProjectRepo {
  MapperDB mapperDB;
  String query;
  ArrayList<String> parameters = new ArrayList<>();
  ArrayList<Project> projects = new ArrayList<>();
  int projectId;
  String projectName;

  //Dependency injection constructor.
  public ProjectRepo(MapperDB mapperDB) {
    this.mapperDB = mapperDB;
  }

//Manipulate ResultSet to data we can use.
  public int getId(ResultSet rs){
    try {
      while (rs.next()) {
        projectId = rs.getInt(1);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return projectId;
  }

  public ArrayList<Project> loadProjects(ResultSet rs) {
    try {
      projects.clear();
      while (rs.next()) {
        projects.add(new Project(rs.getString(1), rs.getString(2),
            rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return projects;
  }

  private String getProjectName(ResultSet rs) {
    try {
      while (rs.next()) {
        projectName = rs.getString(1);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return projectName;
  }

  //DB do something
  public ArrayList<Project> getProjects(int userId) {
    query = "SELECT name, start, finish, actual_cost, budget, actual_hours FROM planit.projects WHERE User_id = ?";
    parameters.clear();
    parameters.add(String.valueOf(userId));
    return loadProjects(mapperDB.load(query, parameters));
  }

  public void createProject(String projectName, String start, String finish, int budget, int userId) {
    query = "INSERT INTO planit.projects(name, start, finish, budget, User_id) VALUES(?,?,?,?,?)";
    parameters.clear();
    parameters.add(projectName);
    parameters.add(start);
    parameters.add(finish);
    parameters.add(String.valueOf(budget));
    parameters.add(String.valueOf(userId));
    mapperDB.save(query, parameters);
  }

  public int getProjectId(String projectName, int userId) {
    query ="SELECT id FROM planit.projects WHERE name = ? AND user_id = ?";
    parameters.clear();
    parameters.add(projectName);
    parameters.add(String.valueOf(userId));
    return getId(mapperDB.load(query,parameters));
  }

  public void deleteProject(int projectId, int userId) {
    query = "DELETE FROM planit.projects WHERE id = ? AND User_id = ?";
    parameters.clear();
    parameters.add(String.valueOf(projectId));
    parameters.add(String.valueOf(userId));
    mapperDB.save(query, parameters);
  }

  public int getProjectId2(int taskId, int userId) {
    query ="SELECT id FROM planit.projects WHERE id = ? AND user_id = ?";
    parameters.clear();
    parameters.add(String.valueOf(taskId));
    parameters.add(String.valueOf(userId));
    return getId(mapperDB.load(query,parameters));
  }

  public String getProjectName(String taskName) {
    query = "SELECT planit.projects.name from planit.projects JOIN planit.tasks ON planit.projects.id=planit.tasks.project_id WHERE planit.tasks.name = ?";
    parameters.clear();
    parameters.add(taskName);
    return getProjectName(mapperDB.load(query, parameters));
  }

  public void addActualHours(int hours, int projectId) {
    query = "UPDATE planit.projects SET actual_hours = projects.actual_hours + ?  WHERE projects.id = ?";
    parameters.clear();
    parameters.add(String.valueOf(hours));
    parameters.add(String.valueOf(projectId));
    mapperDB.save(query,parameters);
  }

  public void addActualCost(int cost, int projectId){
    query = "UPDATE planit.projects SET actual_cost = projects.actual_cost + ?  WHERE projects.id = ?";
    parameters.clear();
    parameters.add(String.valueOf(cost));
    parameters.add(String.valueOf(projectId));
    mapperDB.save(query,parameters);
  }
  public void subtractHours(int hours, int projectId) {
    query = "UPDATE planit.projects SET actual_hours = actual_hours - ? WHERE id = ?";
    parameters.clear();
    parameters.add(String.valueOf(hours));
    parameters.add(String.valueOf(projectId));
    mapperDB.save(query, parameters);
  }

  public void subtractCost(int cost, int projectId) {
    query = "UPDATE planit.projects SET actual_cost = actual_cost - ?  WHERE id = ?";
    parameters.clear();
    parameters.add(String.valueOf(cost));
    parameters.add(String.valueOf(projectId));
    mapperDB.save(query, parameters);
  }
}
