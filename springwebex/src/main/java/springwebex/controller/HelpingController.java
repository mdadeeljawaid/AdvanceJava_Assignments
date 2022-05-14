package springwebex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelpingController {
	@RequestMapping("/aboutus")
	public ModelAndView aboutus() {
		System.out.println("About Us Page");
		
		ModelAndView modelobj = new ModelAndView();
		modelobj.addObject("name","Adeel");
		modelobj.addObject("email","md.adeel.jawaid@gmail.com");
		modelobj.setViewName("AboutUs");
		return modelobj;
		
		
	}
}
