package now.planit.Domain.Models;

public class Subtask {
    private String subtaskName;
    private int hours;
    private int cost;


    public Subtask(String subtaskName, int hours, int cost) {
        this.subtaskName = subtaskName;
        this.hours = hours;
        this.cost = cost;
    }

    public String getSubtaskName() {
        return subtaskName;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return subtaskName + ", hours: " + hours + ", cost: " + cost;
    }
}