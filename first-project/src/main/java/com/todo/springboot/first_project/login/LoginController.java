package com.todo.springboot.first_project.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/*
 * Date:17-7-2024
 * Usercontroller:login,register,listing todos
 */
@Controller
@SessionAttributes("cuser")
public class LoginController {
    private final Userserviceimpl userserviceimpl;
    private final Authenticateservice authenticateservice;
    @Autowired
    public LoginController(Userserviceimpl userserviceimpl, Authenticateservice authenticateservice) {
        this.userserviceimpl = userserviceimpl;
        this.authenticateservice = authenticateservice;
    }
	@GetMapping("/")
	public String welcomenow() {
		return "welcomenow";
	}
	@GetMapping("/login")
	public String showloginpage(Model model) {
		model.addAttribute("cuser", new User());
		return "loginpage";   
	}
	@PostMapping("/login")
	public String login(@ModelAttribute User cuser,Model model) {
		if(authenticateservice.userlogin(cuser)) {
			int id=authenticateservice.getuserid(cuser);
			return "redirect:/dashboard?userid=" + id;
		}
		model.addAttribute("invalid", "Bad Credentials");
		return "loginpage";
	}
	@GetMapping("/register")
	public String showRegisterpage(Model model) {
		model.addAttribute("cuser", new User());
		return "registerpage";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute User cuser,Model model) {
		if(authenticateservice.valute(cuser)) {
			model.addAttribute("notnew", "username is already registerd");
			return "registerpage";
		}
		userserviceimpl.save(cuser);
		model.addAttribute("success", "Registration completed Login Here!");
		return "redirect:login";
	}
	@GetMapping("logoutconfirm")
	public String logout(@SessionAttribute User cuser,Model model) {
		model.addAttribute("cuser", null);
		return "redirect:login";
	}
	@GetMapping("newregister")
	public String registerpagefornew() {
		return "redirect:register";
	}
}
