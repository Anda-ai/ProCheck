package com.kapelle.procheck.Controller;
import com.kapelle.procheck.Model.BusinessDetailsRepository;
import com.kapelle.procheck.Model.ConfirmationToken;
import com.kapelle.procheck.Model.ConfirmationTokenRepository;
import com.kapelle.procheck.Model.ProfileDetailsRepository;
/**
 *
 * @author anda
 */
import com.kapelle.procheck.Model.UserEntity;
import com.kapelle.procheck.Model.UserRepository;
import com.kapelle.procheck.Security.EmailSenderService;
import com.kapelle.procheck.Classes.IdFormat;
import com.kapelle.procheck.Model.BusinessDetailsEntity;
import com.kapelle.procheck.Model.ProfileDetailsEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.openjson.JSONArray;
import com.github.openjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

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
	public String addUser(@ModelAttribute("user") @Validated UserEntity user , BindingResult result, RedirectAttributes attr, HttpServletRequest request, HttpServletResponse response, Model model){
        
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
            //autoLogin(user,request);
            
            //https://stackabuse.com/spring-security-email-verification-registration/
            /*
             * smpt blocked from wifi 
             * creat non 2nd verification password on gmail app under security settings "Manage third-party access"
            */
            /*
            ConfirmationToken confirmationToken = new ConfirmationToken(user);
            confirmationTokenRepository.save(confirmationToken);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("chand312902@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
            +"http://localhost:9090/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            model.addAttribute("email", user.getEmail());*/
            autoLogin(user,request);
            return "redirect:/profileupdate";
            //return "successfulRegisteration";
	}
    
    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public String confirmUserAccount(@RequestParam("token")String confirmationToken, HttpServletRequest request, Model model)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            UserEntity user = userRepository.findByEmailIgnoreCase(token.getUser().getEmail());
            user.setEnabled(true);
            userRepository.save(user);
            //autoLogin(user,request);
            return "accountverified";
        }
        else
        {
            model.addAttribute("message","The link is invalid or broken!");
            return "error";
        }

        
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
    @GetMapping("/register")
	public String pro() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
        if (!(authentication instanceof AnonymousAuthenticationToken)) { 
            if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("PRO"))){
                return "redirect:/";
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
            if(!businessDetailsRepository.existsByUser(user)){
                Long pro_id = IdFormat.generateId();
                while(userRepository.existsById(pro_id)){//in case id gets generated at them same time as other users
                    pro_id++;
                }
                pro.setId(pro_id);   
                pro.setUser(user);
                businessDetailsRepository.save(pro);
            }
            else{//in case of updating
                BusinessDetailsEntity protoUpdate = businessDetailsRepository.findByUser(user);
                Long pro_id = protoUpdate.getId();
                pro.setId(pro_id);
                pro.setUser(user);//to avoid re-parsing user-id as null
                businessDetailsRepository.save(pro);
                System.out.println("Success!!"+user);
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
        String currentUsername = authentication.getName(); 
        UserEntity user = userRepository.findByUsername(currentUsername);
        if (!(authentication instanceof AnonymousAuthenticationToken)) { 
            BusinessDetailsEntity protoUpdate = businessDetailsRepository.findByUser(user);
            pro.setId(protoUpdate.getId());
            pro.setUser(user);
            user.setRole("PRO");
            profileDetailsRepository.save(pro);
            autoLogin(user, request);
            return"redirect:/";
        }
        else{
            JSONArray serviceArr = new JSONArray("");
            JSONObject mainserviceObj = serviceArr.getJSONObject(0);
            return"redirect:/login";
        }
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET) 
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) { 
        System.out.println("preparing to log out...");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		if (!(authentication instanceof AnonymousAuthenticationToken)) { 
            System.out.println("logging out...");
            new SecurityContextLogoutHandler().logout(request, response, authentication); 
            System.out.println("logged out!");
        }
        return "redirect:/"; //You can redirect wherever you want, but generally it's a good practice to show login screen again.
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
