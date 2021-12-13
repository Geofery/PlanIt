package now.planit.Domain.Services;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.ProjectRepo;
import now.planit.Data.Repo.TaskRepo;
import now.planit.Domain.Models.Task;
import now.planit.Domain.Models.User;

import java.util.ArrayList;

public class TaskService {
    FacadeMySQL facadeMySQL;

    public TaskService(FacadeMySQL facadeMySQL) {
        this.facadeMySQL = facadeMySQL;
    }

    public ArrayList<Task> getTasks(String projectName, User user) {
        return facadeMySQL.getTasks(projectName, user);
    }

    public void createTask(String taskName, String startDate, String finishDate,  String projectName, User user) {
        facadeMySQL.createTask(taskName, startDate, finishDate,  projectName, user);
    }

    public void deleteTask(String projectName, String taskName, User user) {
        facadeMySQL.deleteTask(projectName, taskName, user);
    }
}
