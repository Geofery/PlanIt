package now.planit.Domain.Models;


import java.util.ArrayList;

public class Task {
  private String taskName;
  private String startDate;
  private String finishDate;
  private int hours;
  private int cost;
  ArrayList<Subtask> subtasks = new ArrayList<>();

  public Task(String taskName, String startDate, String finishDate, int cost) {
    this.taskName = taskName;
    this.startDate = startDate;
    this.finishDate = finishDate;
    this.cost = cost;
  }

  public Task(String taskName, String startDate, String finishDate, int hours, int cost) {
    this.taskName = taskName;
    this.startDate = startDate;
    this.finishDate = finishDate;
    this.hours = hours;
    this.cost = cost;
  }

  public Task(String taskName, String startDate, String finishDate, int hours, int cost, ArrayList<Subtask> subtasks) {
    this.taskName = taskName;
    this.startDate = startDate;
    this.finishDate = finishDate;
    this.hours = hours;
    this.cost = cost;
    this.subtasks = subtasks;
  }

  public String getTaskName() {
    return taskName;
  }

  public String getStartDate() {
    return startDate;
  }


  public String getFinishDate() {
    return finishDate;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public int getHours() {
    return hours;
  }

  public void setHours(int hours) {
    this.hours = hours;
  }

  public ArrayList<Subtask> getSubtasks() {
    return subtasks;
  }

  public void setSubtasks(ArrayList<Subtask> subtasks) {
    this.subtasks = subtasks;
  }

  @Override
  public String toString() {
    return taskName + ", startDate: " + startDate + ", finishDate: " + finishDate +
        ", hours: " + hours +
        ", cost: " + cost;
  }
}
