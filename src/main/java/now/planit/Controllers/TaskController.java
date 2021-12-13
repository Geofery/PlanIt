package now.planit.Controllers;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.ProjectRepo;
import now.planit.Data.Repo.TaskRepo;
import now.planit.Domain.Models.Task;
import now.planit.Domain.Models.User;
import now.planit.Domain.Services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import java.util.ArrayList;

@Controller
public class TaskController {
  User user;
  String projectName;
  TaskService taskService = new TaskService(new FacadeMySQL(new TaskRepo(new MapperDB())));
  ArrayList<Task> tasks = new ArrayList();

  //Endpoint to dynamic display(loop) all task and display user information
  @GetMapping("/createTask")
  public String createTasks(WebRequest request, Model model) {
    if (user == null){
      return "login/login";
    }
    updateTasks(request, model, projectName);
    model.addAttribute("userName", user.getName());
    return "/project/createTask";
  }

  //Endpoint to pass and connect data(id) from myProjects site to createtask site.
  @GetMapping("/update/{id}")
  public String updateProject(@PathVariable(value = "id") String id, WebRequest request, Model model)  {
    projectName = id;
   updateTasks(request, model, projectName);
    return "redirect:/createTask";
  }

  //Endpoint that stores parameters from task and pass them down to the service.
  @PostMapping("/createTaskParam")
  public String createTask(WebRequest request)  {
    taskService.createTask
            (request.getParameter("taskName"),
            request.getParameter("startDate"),
            request.getParameter("finishDate"),
            projectName, user);
    return "redirect:/createTask";
  }

  @GetMapping("/removeTask/{id}")
  public String deleteTask(@PathVariable(value = "id") String id, Model model, WebRequest request) {
    if (user == null){
      return "login/login";
    }
    taskService.deleteTask(projectName, id, user);
    updateTasks(request, model, projectName);
    return "redirect:/createTask";
  }

  public void updateTasks(WebRequest request, Model model, String projectName)  {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    tasks = taskService.getTasks(projectName, user);
    model.addAttribute("tasks", tasks);
  }
}
