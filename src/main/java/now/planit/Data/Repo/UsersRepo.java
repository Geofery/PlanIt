package now.planit.Data.Repo;

import now.planit.Domain.Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsersRepo {
  MapperDB mapperDB;
  User user;
  String query;
  ArrayList<String> parameters = new ArrayList<>();
  int getInt;

  //Dependency injection constructor.
  public UsersRepo(MapperDB mapperDB) {
    this.mapperDB = mapperDB;
  }


  //Manipulate ResultSet to other type of data
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

  //Builder pattern, hvis der er mange attributter i en konstruktør.
  public User getUser(ResultSet rs) {
    try {
      user = null;
      while (rs.next()) {
        user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return user;
  }




  public int registerUser(String name, String email, String password) {
    //Makes sure there is no shadow data in the ResultSet.
    mapperDB = new MapperDB();

    query = "INSERT INTO planit.users(name, email, password) VALUES(?,?,?)";
    parameters.clear();
    parameters.add(name);
    parameters.add(email);
    parameters.add(password);
    return mapperDB.saveUpdate(query, parameters);
  }

  public User validateLogin(String email, String password) {
    query = "SELECT name, email, password FROM planit.users WHERE email = ? AND password = ?";
    parameters.clear();
    parameters.add(email);
    parameters.add(password);
    return getUser(mapperDB.load(query, parameters));
  }


  public int getUserId(User user) {
    query = "SELECT id FROM planit.users WHERE email = ? AND password = ?";
    parameters.clear();
    parameters.add(user.getEmail());
    parameters.add(user.getPassword());
    return getInt(mapperDB.load(query, parameters));
  }

  public void editName(String newName, int userId) {
    query = "UPDATE planit.users SET name = ? WHERE id = ?";
    parameters.clear();
    parameters.add(newName);
    parameters.add(String.valueOf(userId));
    mapperDB.save(query, parameters);
  }

  public void editEmail(String newEmail, int userId) {
    query = "UPDATE planit.users SET email = ? WHERE id = ?";
    parameters.clear();
    parameters.add(newEmail);
    parameters.add(String.valueOf(userId));
    mapperDB.save(query, parameters);
  }

  public void editPassword(String newPassword, int userId) {
    query = "UPDATE planit.users SET password = ? WHERE id = ?";
    parameters.clear();
    parameters.add(newPassword);
    parameters.add(String.valueOf(userId));
    mapperDB.save(query, parameters);
  }

  public void deleteUser(String email, String password) {
    query = "DELETE FROM planit.users WHERE email = ? AND password = ?";
    parameters.clear();
    parameters.add(email);
    parameters.add(password);
    mapperDB.save(query, parameters);
  }
}
