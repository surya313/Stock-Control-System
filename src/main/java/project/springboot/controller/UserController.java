package project.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.springboot.model.User;
import project.springboot.service.UserService;




@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	 @GetMapping("/login")
	    public String viewHomePage(Model model) {
		 System.out.println("user71");
		 	model.addAttribute("user",new User());
	        return "login";
	    }
	 
	@GetMapping("/authenticate")
	public String authenticate(@ModelAttribute ("user") User user) {
		System.out.println("user11");
		if(userService.validate(user)) {
		
				return "successfull";
		}
		else 
			return "invalid-login";
		}
	
	@GetMapping("/register")
    public String viewRegisterPage(Model model) {
	 	model.addAttribute("user",new User());
        return "register";
    }
	
	
	@RequestMapping(method=RequestMethod.POST, value="/createuser")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
		System.out.println("saved to login table");
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/adminedit")
	public void adminEdit(@RequestBody User user) {
		userService.adminEdit(user);
		System.out.println("saved to login table");
	}

}
