package now.planit.Data.Repo;

import now.planit.Domain.Models.Subtask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SubtaskRepo {
    MapperDB mapperDB;
    ArrayList<String> parameters = new ArrayList<>();
    String query;
    ArrayList<Subtask> subtasks = new ArrayList<>();
    int getInt;

    //Dependency injection constructor.
    public SubtaskRepo(MapperDB mapperDB) {
        this.mapperDB = mapperDB;
    }

    //Manipulate Resultset to data we can use
    public ArrayList<Subtask> loadSubtasks(ResultSet rs){
        try {
            subtasks.clear();
            while (rs.next()) {
                subtasks.add(new Subtask(rs.getString(1), rs.getInt(2)
                        , rs.getInt(3)));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return subtasks;
    }

    private int getInt(ResultSet rs) {
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
    public ArrayList<Subtask> getSubtasks(int taskId){
        query ="SELECT name, estimated_hours, cost FROM planit.subtasks WHERE task_id = ?";
        parameters.clear();
        parameters.add(String.valueOf(taskId));
        return loadSubtasks(mapperDB.load(query,parameters));
    }

    public void createSubtask(String subtaskName, int hours, int cost, int taskId) {
        query ="INSERT INTO planit.subtasks (task_id, name, estimated_hours, cost) VALUES (?, ?, ?, ?)";
        parameters.clear();
        parameters.add(String.valueOf(taskId));
        parameters.add(subtaskName);
        parameters.add(String.valueOf(hours));
        parameters.add(String.valueOf(cost));
        mapperDB.save(query,parameters);
    }

    public int getSubtaskId(String subtaskName, int taskId) {
        query ="SELECT id FROM planit.subtasks WHERE name = ? AND task_id = ?";
        parameters.clear();
        parameters.add(subtaskName);
        parameters.add(String.valueOf(taskId));
        return getInt(mapperDB.load(query,parameters));
    }

    public void deleteSubtask(int subtaskId, int taskId) {
        query = "DELETE from planit.subtasks WHERE id = ? AND task_id = ?";
        parameters.clear();
        parameters.add(String.valueOf(subtaskId));
        parameters.add(String.valueOf(taskId));
        mapperDB.save(query, parameters);
    }

    public int getHours(int subtaskId, int taskId){
        query = "SELECT estimated_hours FROM planit.subtasks WHERE id = ? AND task_id = ?";
        parameters.clear();
        parameters.add(String.valueOf(subtaskId));
        parameters.add(String.valueOf(taskId));
       return getInt(mapperDB.load(query,parameters));
    }

    public int getCost(int subtaskId, int taskId){
        query = "SELECT cost FROM planit.subtasks WHERE id = ? AND task_id = ?";
        parameters.clear();
        parameters.add(String.valueOf(subtaskId));
        parameters.add(String.valueOf(taskId));
        return getInt(mapperDB.load(query,parameters));
    }
}