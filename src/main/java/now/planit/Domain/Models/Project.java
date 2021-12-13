package now.planit.Domain.Models;


import java.util.ArrayList;

public class Project {
  private String name;
  private String start;
  private String finish;
  private int hours;
  private int cost;
  private int budget;
  ArrayList<Task> tasks = new ArrayList<>();

  public Project(String name, String start, String finish, int budget) {
    this.name = name;
    this.start = start;
    this.finish = finish;
    this.budget = budget;
  }

  public Project(String name, String start, String finish, int cost, int budget, int hours) {
    this.name = name;
    this.start = start;
    this.finish = finish;
    this.cost = cost;
    this.budget = budget;
    this.hours = hours;
  }

  public Project(String name, String start, String finish, int hours, int cost, int budget, ArrayList<Task> tasks) {
    this.name = name;
    this.start = start;
    this.finish = finish;
    this.hours = hours;
    this.cost = cost;
    this.budget = budget;
    this.tasks = tasks;
  }

  public String getName() {
    return name;
  }

  public String getStart() {
    return start;
  }

  public String getFinish() {
    return finish;
  }

  public int getBudget() {
    return budget;
  }

  public int getHours() {
    return hours;
  }

  public int getCost() {
    return cost;
  }

  public ArrayList<Task> getTasks() {
    return tasks;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public void setFinish(String finish) {
    this.finish = finish;
  }

  public void setHours(int hours) {
    this.hours = hours;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public void setTasks(ArrayList<Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public String toString() {
    return "Project{" +
            ", name='" + name + '\'' +
            ", start='" + start + '\'' +
            ", finish='" + finish + '\'' +
            ", budget='" + budget + '\'' +
            '}';
  }
}
