package now.planit.Controllers;


import now.planit.Data.Repo.FacadeMySQL;
import now.planit.Data.Repo.MapperDB;
import now.planit.Data.Repo.ProjectRepo;
import now.planit.Data.Repo.UsersRepo;
import now.planit.Domain.Models.User;
import now.planit.Exceptions.UserNotExistException;
import now.planit.Domain.Services.UserService;
import now.planit.Exceptions.DBConnFailedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
  UserService userService = new UserService(new FacadeMySQL(new UsersRepo(new MapperDB())));
  User user;

  @GetMapping("/registerUser")
  public String createUser() {
    return "register/register";
  }

  @GetMapping("/logged")
  public String loggedIn() {
    return "login/logged";
  }

  @PostMapping("/register")
  public String register(WebRequest request) throws UserNotExistException {
    //TODO skal rettes til, så man kan logge ind uden nogen bruger i forvejen
      userService.registerUser(
          request.getParameter("name"),
          request.getParameter("email"),
          request.getParameter("password"));
      return "login/login";
  }


  @PostMapping("/validateLogin")
  public String validateLogin(WebRequest request, HttpSession session, Model model) throws UserNotExistException {
    user = userService.validateLogin(
            request.getParameter("mail"),
            request.getParameter("password"));

    //Set Session to user, validate user is not null.
    if (session.getAttribute("user") == null) {
      if (user != null) {
        model.addAttribute("user", user);
        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        userService.updateUserData(user);

        return "project/projectOverview";
      }
    }
    return "login/loginFailed";
  }

  @GetMapping("/logout")
  public String logOut(HttpSession session) {
    session.invalidate();
    user = null;
    return "redirect:/";
  }

  @GetMapping("/myPage")
  public String myPage(Model model) {
    model.addAttribute("user", user);
    return "login/myPage";
  }

  @PostMapping("/updateUser")
  public String updateUser(WebRequest request, Model model)  {
    userService.editName(request.getParameter("name"), user);
    userService.editMail(request.getParameter("email"), user);
    userService.changePassword(request.getParameter("password"), user);
    model.addAttribute("user", user);
    return "redirect:/myPage";
  }

  @ExceptionHandler(DBConnFailedException.class)
  public String exceptionMessageLogin(Model model, DBConnFailedException dbConnFailedException){
    model.addAttribute("exMessage", dbConnFailedException.getMessage());
    return "error/error";

  }
  @ExceptionHandler(UserNotExistException.class)
  public String exceptionMessageUserNotExist(Model model, UserNotExistException userNotExistException){
    model.addAttribute("exMessage", "--->User allready exits. Please choose another name<--");
    return "error/error";

  }
}
