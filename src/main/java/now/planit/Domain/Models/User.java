package now.planit.Domain.Models;


import java.util.ArrayList;

public class User {
  private  String name;
  private  String email;
  private  String password;
  private ArrayList<Project> projects = new ArrayList<>();

  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public User(String name, String email, String password, ArrayList<Project> projects) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.projects = projects;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public ArrayList<Project> getProjects() {
    return projects;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setProjects(ArrayList<Project> projects) {
    this.projects = projects;
  }

  @Override
  public String toString() {
    return name + " Email: " + email + "Password: " + password;
  }
}
