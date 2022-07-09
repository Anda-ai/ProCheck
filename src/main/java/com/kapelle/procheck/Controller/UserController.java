/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kapelle.procheck.Controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String welcome(Model model, @PathVariable("username") String username) {
		
        if(userRepository.findByUsername(username) != null){
            UserEntity user = userRepository.findByUsername(username);
            ProfileDetailsEntity pro = profileDetailsRepository.findByUser(user);
            model.addAttribute("user", user);
            model.addAttribute("pro", pro);
            return "profile";
        } 
        else{
            return "redirect:/";
        } 
	}
    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String project(@RequestParam String id){
        return "project";
    }
    @RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String projects(Model model) {
		return "projects";
	}
    @RequestMapping(value = "/{username}/projects", method = RequestMethod.GET)
	public String userProjects(Model model, @PathVariable("username") String username) {
		return "profile";//TODO:  this view users projects on user profile
	}
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String post(@RequestParam String id){
        return "post";
    }
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String posts(Model model) {
		return "posts";
	}
    @RequestMapping(value = "/{username}/posts", method = RequestMethod.GET)
	public String userPosts(Model model, @PathVariable("username") String username) {
		return "posts";//TODO: Note: this view users posts on user profile
	}
}
