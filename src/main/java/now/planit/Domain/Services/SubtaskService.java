package now.planit.Domain.Services;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.ProjectRepo;
import now.planit.Data.Repo.SubtaskRepo;
import now.planit.Domain.Models.Subtask;
import now.planit.Domain.Models.User;

import java.util.ArrayList;

public class SubtaskService {
    FacadeMySQL facadeMySQL;

   public SubtaskService(FacadeMySQL facadeMySQL) {
        this.facadeMySQL = facadeMySQL;
    }

    public ArrayList<Subtask> getSubtasks(String taskName, User user) {
        return facadeMySQL.getSubtasks(taskName, user);
    }

    public void createSubtask(String subtaskName, String hours, int cost, String taskName) {
        facadeMySQL.createSubtask(subtaskName, Integer.parseInt(hours), cost, taskName);
    }

    public void deleteSubtask(String taskName, String subtaskName, User user) {
        facadeMySQL.deleteSubtask(taskName, subtaskName, user);
    }
}