package com.kapelle.procheck.Controller;
import com.kapelle.procheck.Model.BusinessDetailsRepository;
import com.kapelle.procheck.Model.ProfileDetailsRepository;
/**
 *
 * @author anda
 */
import com.kapelle.procheck.Model.UserEntity;
import com.kapelle.procheck.Model.UserRepository;
import com.kapelle.procheck.Classes.IdFormat;
import com.kapelle.procheck.Model.BusinessDetailsEntity;
import com.kapelle.procheck.Model.ProfileDetailsEntity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Controller
//verification: https://www.codejava.net/frameworks/spring-boot/email-verification-example
public class register {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BusinessDetailsRepository businessDetailsRepository;

    @Autowired
    ProfileDetailsRepository profileDetailsRepository;
        
    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

	@GetMapping("/signup")
	public String user() {
		return "signup";
	}
    @PostMapping("/signup")
	public String addUser(@ModelAttribute("user") @Validated UserEntity user , BindingResult result, RedirectAttributes attr, HttpServletRequest request, HttpServletResponse response){
        
            System.out.println("Username: "+user.username);
            if (result.hasErrors()) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                System.out.println("errors: "+result.getAllErrors());
                attr.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
                attr.addFlashAttribute("user", user);
                return "redirect:/signup";
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Long id = IdFormat.generateId();
            while(userRepository.existsById(id)){
                id++;
            }
            user.setId(id);         
            /*
            In case of updating
            UserEntity userUpdate = userRepository.findByUsername(user.username);
            user.setId(userUpdate.getId());*/
            System.out.println("..to Save");
            userRepository.save(user);
            autoLogin(user,request);
            return "redirect:/profileupdate";
	}
    @GetMapping("/login")
	public String logging() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
        if (!(authentication instanceof AnonymousAuthenticationToken)) { 
            return "redirect:/";
        }
		return "login";
	}
    @PostMapping("/login_success_handler")
	public String loginSuccessHandler(){
        return "redirect:/";
            
	}
    /*@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String pro(Map<String, Object> model, @RequestParam String u, @RequestParam String s) {//@RequestParam allow url with question mark
        model.put("message", u+"'s videos");
        //return "proreg";
        return "pro-registration";//https://www.codegrepper.com/code-examples/java/spring+boot+save+file+to+static+folder
    }*/
    @GetMapping("/register")
	public String pro(Map<String, Object> model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
        if (!(authentication instanceof AnonymousAuthenticationToken)) { 
            if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("PRO"))){
                return "redirect:/home";
            }
            else{
                return "pro-registration";
            }
        }
        else{
            return "redirect:/login";
        }
	} 
    @PostMapping("/register_BusinessDetails")
    public String BusinessDetails(@ModelAttribute("business") @Validated BusinessDetailsEntity pro,  BindingResult result, 
            RedirectAttributes attr, HttpServletRequest request, HttpServletResponse response){
        if (result.hasErrors()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            System.out.println("errors: "+result.getAllErrors());
            attr.addFlashAttribute("org.springframework.validation.BindingResult.business", result);
            attr.addFlashAttribute("business", pro);
            attr.addFlashAttribute("slide", 1);
            return "redirect:/register";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
        if (!(authentication instanceof AnonymousAuthenticationToken)) { 
            String currentUsername = authentication.getName(); 
            UserEntity user = userRepository.findByUsername(currentUsername);
            Long user_id = Long.valueOf(user.getId());
            if(!businessDetailsRepository.existsByUserId(user_id)){
                Long pro_id = IdFormat.generateId();
                while(userRepository.existsById(pro_id)){//in case id gets generated at them same time as other users
                    pro_id++;
                }
                pro.setId(pro_id);   
                pro.setUserId(user_id);
                businessDetailsRepository.save(pro);
            }
            else{//in case of updating
                BusinessDetailsEntity protoUpdate = businessDetailsRepository.findByUserId(user_id);
                Long pro_id = protoUpdate.getId();
                pro.setId(pro_id);
                pro.setUserId(user_id);//to avoid re-parsing user-id as null
                businessDetailsRepository.save(pro);
                System.out.println("Success!!"+user_id);
            }
            attr.addFlashAttribute("slide", 2);
            return"redirect:/register";
        }
        else{
            return"redirect:/login";
        }
    }
    @PostMapping("/register_ProfileDetails")
    public String ProfileDetails(@ModelAttribute("profile") @Validated ProfileDetailsEntity pro,  BindingResult result, RedirectAttributes attr, HttpServletRequest request, HttpServletResponse response){
        if (result.hasErrors()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            System.out.println("errors: "+result.getAllErrors());
            attr.addFlashAttribute("org.springframework.validation.BindingResult.profile", result);
            attr.addFlashAttribute("profile", pro);
            attr.addFlashAttribute("slide", 2);
            return "redirect:/register";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
        //Set<GrantedAuthority> authorities = new HashSet<>();
        String currentUsername = authentication.getName(); 
        UserEntity user = userRepository.findByUsername(currentUsername);
        Long user_id = Long.valueOf(user.getId());
        if (!(authentication instanceof AnonymousAuthenticationToken)) { 
            //To update:
            BusinessDetailsEntity protoUpdate = businessDetailsRepository.findByUserId(user_id);
            pro.setId(protoUpdate.getId());
            pro.setUserId(user_id);
            user.setRole("PRO");
            //authentication.add(new SimpleGrantedAuthority("PRO"));
            profileDetailsRepository.save(pro);
            autoLogin(user, request);
            return"redirect:/";
        }
        else{
            JSONArray serviceArr = new JSONArray("");
            JSONObject mainserviceObj = serviceArr.getJSONObject(0);
            //mainserviceObj.getString("servicename")
            return"redirect:/login";
        }
    }
/* 
    @PostMapping("/register")
	public ResponseEntity<Model> pro(@ModelAttribute("user") @Validated ProEntity pro , BindingResult result, RedirectAttributes attr, HttpServletRequest request) {
        
            if (result.hasErrors()) {
                System.out.println("errors: "+result.getAllErrors());
                attr.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
                attr.addFlashAttribute("user", pro);
                return "signup";
            }
	}*/
    @RequestMapping(value="/logout", method = RequestMethod.GET) 
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) { 
        System.out.println("preparing to log out...");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		if (!(authentication instanceof AnonymousAuthenticationToken)) { 
            System.out.println("logging out...");
            new SecurityContextLogoutHandler().logout(request, response, authentication); 
            System.out.println("logged out!");
        }
        return "redirect:/login"; //You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
    private void autoLogin(UserEntity user, HttpServletRequest request){
        try {
            // Must be called from request filtered by Spring Security, otherwise SecurityContextHolder is not updated
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), request.getParameter("password"));
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = this.authenticationProvider.authenticate(token);
            System.out.println(user.getUsername()+" Logged in !!!!!!");
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            SecurityContextHolder.getContext().setAuthentication(null);
            System.out.println("Failure in autoLogin"+ e);
        }
    }
}
