package springwebex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home") //url ampping for home url this method will be executed
	public String home() {
		System.out.println("welcome to the home page of spring mvc demo");
		return "home";
	}
	@RequestMapping("/contactus")	
	public String contactUs(Model m) {
		System.out.println("Welcome to contact us page");
		m.addAttribute("address","New Azimabad, Patna");
		m.addAttribute("mobile","6205913674");
		m.addAttribute("email","md.adeel.jawaid@gmail.com");
		return "contact";
		
	}
}
