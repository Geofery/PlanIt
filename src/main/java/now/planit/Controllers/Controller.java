package now.planit.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author roed
 */
@org.springframework.stereotype.Controller
public class Controller {

  @GetMapping("/")
  public String test(){
    return "login/login";
  }
}
