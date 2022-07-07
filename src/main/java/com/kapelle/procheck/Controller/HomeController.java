package com.kapelle.procheck.Controller;
/**
 *
 * @author anda
 */
import java.util.Map;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private String message = "WELCOME HOME";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Map<String, Object> model){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		String currentUsername = authentication.getName(); 
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) { 
			model.put("message", " "+this.message + currentUsername + "!");
			model.put("islogged", "true");
			System.out.println("Details: "+authentication.getCredentials());
		}
		else{
			model.put("message","please log in !");
			model.put("islogged", "false");
		}
		
		return "home";
	}
}
