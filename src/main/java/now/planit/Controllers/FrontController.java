package now.planit.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;

@Controller
public class FrontController {


  @GetMapping("/")
  public String index(HttpSession session) {
    if (session.getAttribute("user")!= null){
      return "redirect:/myProjects";
    }
    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login/login";
  }

  @GetMapping("/about")
  public String about() {
    return "info/about";
  }

}
