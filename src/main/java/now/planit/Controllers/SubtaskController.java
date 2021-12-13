package now.planit.Controllers;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.ProjectRepo;
import now.planit.Data.Repo.SubtaskRepo;
import now.planit.Domain.Models.Subtask;
import now.planit.Domain.Models.User;
import now.planit.Domain.Services.SubtaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class SubtaskController {
  User user;
  String taskName;
  SubtaskService subtaskService = new SubtaskService(new FacadeMySQL(new SubtaskRepo(new MapperDB())));
  ArrayList<Subtask> subtasks = new ArrayList();


  //Endpoint to pass and connect data(id) from createTask site to createSubtask site.
  @GetMapping("/rerun/{id}")
  public String loadSubtasks(@PathVariable(value = "id") String id, WebRequest request, Model model) {
    taskName = id;
   updateSubtasks(request, model, taskName);
    return "redirect:/createSubtask";
  }

  //Endpoint to dynamic display(loop) all task and display user information
  @GetMapping("/createSubtask")
  public String createSubtasks(WebRequest request, Model model) {
    if (user == null){
      return "login/login";
    }
    updateSubtasks(request, model, taskName);
    return "/project/createSubtask";
  }


  //Endpoint that stores parameters from task and pass them down to the service.
  @PostMapping("/createSubtaskParam")
  public String createSubtask(WebRequest request, Model model) {
    subtaskService.createSubtask
        (request.getParameter("subtaskName"),
            request.getParameter("hours"),
            Integer.parseInt(request.getParameter("cost")),
            taskName);
    return "redirect:/createSubtask";
  }

  @GetMapping("/removeSubtask/{id}")
  public String deleteTask(@PathVariable(value = "id") String id, Model model, WebRequest request) {
    subtaskService.deleteSubtask(taskName, id, user);
    updateSubtasks(request, model, taskName);
    return "redirect:/createSubtask";
  }

  public void updateSubtasks(WebRequest request, Model model, String taskName) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    subtasks = subtaskService.getSubtasks(taskName, user);
    model.addAttribute("subtasks", subtasks);
    model.addAttribute("userName", user.getName());
  }

}