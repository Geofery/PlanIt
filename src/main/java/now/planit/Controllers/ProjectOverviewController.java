package now.planit.Controllers;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.ProjectRepo;
import now.planit.Data.Repo.UsersRepo;
import now.planit.Domain.Models.Project;
import now.planit.Domain.Models.Subtask;
import now.planit.Domain.Models.Task;
import now.planit.Domain.Models.User;
import now.planit.Domain.Services.ProjectService;
import now.planit.Domain.Services.SubtaskService;
import now.planit.Domain.Services.TaskService;
import now.planit.Domain.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author roed
 */
@Controller
public class ProjectOverviewController {
  UserService userService = new UserService(new FacadeMySQL(new UsersRepo(new MapperDB())));
  User user;

  @GetMapping("/projectOverview")
  public String index(HttpSession session, Model model, WebRequest request) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    model.addAttribute("user", user);

    if (session.getAttribute("user") != null) {
      userService.updateUserData(user);
      return "project/projectOverview";
    }
    return "index";
  }
}
