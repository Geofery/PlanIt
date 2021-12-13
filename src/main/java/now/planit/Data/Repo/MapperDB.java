package now.planit.Data.Repo;

import now.planit.Data.Utility.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author roed
 */
public class MapperDB {
  Connection connection;
  PreparedStatement ps;
  ResultSet rs;
  int validate = 0;

  //Check connection with DBManager
  public PreparedStatement checkConnection(String sqlCommand)  {
    try {
      connection = DBManager.getConnection();
      ps = connection.prepareStatement(sqlCommand);
    } catch (SQLException e) {
      System.out.println("Database unavaiable for checkConnection method");
      e.printStackTrace();
    }
    return ps;
  }

  //Loads Parameters into Prepared statement
  public PreparedStatement setParameters(ArrayList<String> parameters) {
  //Should we use ResultsetFailException here
    try {
      for (int i = 0; i < parameters.size(); i++) {
        ps.setString(i + 1, parameters.get(i));
      }
    } catch (SQLException e) {
      System.out.println("Database unavaiable for setParameters method");
      e.printStackTrace();
    }
    return ps;
  }

  //Used to do something on the Database, Save or delete.
  public void save(String sqlCommand, ArrayList<String> parameters) {
    try {
      ps = checkConnection(sqlCommand);
      setParameters(parameters).execute();
    } catch (SQLException e) {
      System.out.println("Database unavaiable for save method!");
      e.printStackTrace();
    }
  }

  //Used to recieve something from the database, will always return ResultSet.
  public ResultSet load(String sqlCommand, ArrayList<String> parameters) {
    try {
      ps = checkConnection(sqlCommand);
      rs = setParameters(parameters).executeQuery();
    }
    catch (SQLException e) {
      System.out.println("Database unavaiable for load method!");
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
    return rs;
  }

  public int saveUpdate(String sqlCommand, ArrayList<String> parameters) {
    try {
      ps = checkConnection(sqlCommand);
      validate = setParameters(parameters).executeUpdate();
    }
    catch (SQLException e) {
      System.out.println("Database unavaiable for load method!");
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
    return validate;
  }
}