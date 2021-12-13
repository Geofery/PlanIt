package now.planit.Data.Repo;

import now.planit.Domain.Models.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TaskRepo {
  MapperDB mapperDB;
  ArrayList<String> parameters = new ArrayList<>();
  String query;
  ArrayList<Task> tasks = new ArrayList<>();
  int getInt;


  //Dependency injection constructor.
  public TaskRepo(MapperDB mapperDB) {
    this.mapperDB = mapperDB;
  }


  //Manipulate Resultset to data we can use
  public ArrayList<Task> loadTasks(ResultSet rs) {
    try {
      tasks.clear();
      while (rs.next()) {
        tasks.add(new Task(rs.getString(1), rs.getString(2),
            rs.getString(3), rs.getInt(4), rs.getInt(5)));

      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return tasks;
  }

  public int getInt(ResultSet rs) {
    try {
      while (rs.next()) {
        getInt = rs.getInt(1);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return getInt;
  }

  //Db Do something.
  public ArrayList<Task> getTasks(int projectId) {
    query = "SELECT name, start, finish, hours, cost FROM planit.tasks WHERE project_Id = ?";
    parameters.clear();
    parameters.add(String.valueOf(projectId));
    tasks = loadTasks(mapperDB.load(query, parameters));
    return tasks;
  }

  public void createTask(String taskName, String startDate, String finishDate, int projectId) {
    query = "INSERT INTO planit.tasks (name, start, finish, project_id) VALUES(?, ?, ?, ?)";
    parameters.clear();
    parameters.add(taskName);
    parameters.add(startDate);
    parameters.add(finishDate);
    parameters.add(String.valueOf(projectId));
    mapperDB.save(query, parameters);
  }

  public int getTaskId(String taskName, int projectId) {
    query = "SELECT id FROM planit.tasks WHERE name = ? AND project_id = ?";
    parameters.clear();
    parameters.add(taskName);
    parameters.add(String.valueOf(projectId));
    return getInt(mapperDB.load(query, parameters));
  }

  public void deleteTask(int taskId, int projectId) {
    query = "DELETE FROM planit.tasks WHERE id = ? AND project_id = ?";
    parameters.clear();
    parameters.add(String.valueOf(taskId));
    parameters.add(String.valueOf(projectId));
    mapperDB.save(query, parameters);
  }

  public int getTaskId2(int subtaskId, int projectId) {
    query = "SELECT id FROM planit.tasks WHERE id = ? AND project_id = ?";
    parameters.clear();
    parameters.add(String.valueOf(subtaskId));
    parameters.add(String.valueOf(projectId));
    return getInt(mapperDB.load(query, parameters));
  }

  public int getProjectID(String taskName) {
    query = "SELECT project_id FROM planit.tasks WHERE name = ?";
    parameters.clear();
    parameters.add(taskName);
    return getInt(mapperDB.load(query, parameters));
  }

  public int getHours(int taskId, int projectId){
    query = "SELECT hours from planit.tasks WHERE id = ? AND project_id = ?";
    parameters.clear();
    parameters.add(String.valueOf(taskId));
    parameters.add(String.valueOf(projectId));
    return getInt(mapperDB.load(query,parameters));
  }

  public int getCost(int taskId, int projectId){
    query = "SELECT cost FROM planit.tasks WHERE id = ? AND project_id = ?";
    parameters.clear();
    parameters.add(String.valueOf(taskId));
    parameters.add(String.valueOf(projectId));
    return getInt(mapperDB.load(query,parameters));
  }

  public void addHours(int hours, String taskName, int projectId) {
    query = "UPDATE planit.tasks SET tasks.hours = tasks.hours + ? WHERE name = ? AND project_id = ?";
    parameters.clear();
    parameters.add(String.valueOf(hours));
    parameters.add(taskName);
    parameters.add(String.valueOf(projectId));
    mapperDB.save(query, parameters);
  }

  public void addActualCost(int cost, String taskName, int projectId) {
    query = "UPDATE planit.tasks SET tasks.cost = tasks.cost + ?  WHERE tasks.name = ? AND tasks.project_id = ? ";
    parameters.clear();
    parameters.add(String.valueOf(cost));
    parameters.add(taskName);
    parameters.add(String.valueOf(projectId));
    mapperDB.save(query, parameters);
  }

  public void subtractHours(int hours, String taskName, int projectId) {
    query = "UPDATE planit.tasks SET tasks.hours = tasks.hours - ? WHERE name = ? AND tasks.project_id = ?";
    parameters.clear();
    parameters.add(String.valueOf(hours));
    parameters.add(taskName);
    parameters.add(String.valueOf(projectId));
    mapperDB.save(query, parameters);
  }

  public void subtractCost(int cost, String taskName, int projectId) {
    query = "UPDATE planit.tasks SET cost = tasks.cost - ?  WHERE tasks.name = ? AND tasks.Project_id = ?";
    parameters.clear();
    parameters.add(String.valueOf(cost));
    parameters.add(taskName);
    parameters.add(String.valueOf(projectId));
    mapperDB.save(query, parameters);
  }
}



