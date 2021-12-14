package now.planit.Controllers;

import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.UsersRepo;
import now.planit.Domain.Models.User;
import now.planit.Domain.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

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
