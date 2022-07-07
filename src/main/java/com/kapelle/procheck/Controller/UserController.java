/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kapelle.procheck.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kapelle.procheck.Model.ProfileDetailsEntity;
import com.kapelle.procheck.Model.ProfileDetailsRepository;
import com.kapelle.procheck.Model.ProfileRepository;
import com.kapelle.procheck.Model.UserEntity;
import com.kapelle.procheck.Model.UserRepository;

@Controller
public class UserController {
    
        @Autowired
        UserRepository userRepository;
        
        @Autowired
        ProfileDetailsRepository profileDetailsRepository;

        @Autowired
        ProfileRepository profileRepository;

        @Autowired
        ServletContext context; 

        
    
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello";

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String welcome(Model model, @PathVariable("username") String username) {
		
        if(userRepository.findByUsername(username) != null){
            UserEntity user = userRepository.findByUsername(username);//
            Long user_id = Long.valueOf(user.getId());
            ProfileDetailsEntity pro = profileDetailsRepository.findByUserId(user_id);//
            model.addAttribute("user", user);
            model.addAttribute("pro", pro);
            return "pro";
        } 
        else{
            return "redirect:/";
        } 
	}
        @RequestMapping(value = "/{username}/videos", method = RequestMethod.GET)
	public String userVideos(Map<String, Object> model, @PathVariable("username") String username) {
		model.put("message", username+"'s videos");
		return "user";
	}
        @GetMapping(path = "/all")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/image")
    public void image(){
       System.out.println("Path"+context.getRealPath(""));
    }
}
