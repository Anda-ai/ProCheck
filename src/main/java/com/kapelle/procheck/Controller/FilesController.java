package com.kapelle.procheck.Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.io.IOUtils;

import com.kapelle.procheck.Classes.IdFormat;
import com.kapelle.procheck.Model.ProfileEntity;
import com.kapelle.procheck.Model.ProfileRepository;
import com.kapelle.procheck.Model.UserEntity;
import com.kapelle.procheck.Model.UserRepository;
import com.kapelle.procheck.Storage.Paths;
import com.kapelle.procheck.Storage.StorageService;



@Controller
public class FilesController {

    @Autowired
    ServletContext context;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfileRepository profileRepository;

    //private static String imgPath = "/Users/anda";
    
    

	@GetMapping("/profileupdate")
	public String ProlifeFileUploadPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
        if (!(authentication instanceof AnonymousAuthenticationToken)) { 
            return "profimgupload";
        }
        else{
            return "redirect:login";
        }
    }
    @PostMapping("/upload_profile")
	public ResponseEntity<?> uploadFile(@ModelAttribute ProfileEntity profile, @RequestParam("file") Part filePart) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
        if (!(authentication instanceof AnonymousAuthenticationToken)) { 
            String currentUsername = authentication.getName(); 
            UserEntity user = userRepository.findByUsername(currentUsername);
            Long user_id = Long.valueOf(user.getId());
            Paths path = new Paths(user_id, context);
            File uploadDir = new File(path.profile_dir);
            System.out.print("is directory exists: "+uploadDir.exists());
            if(!uploadDir.exists()){
                System.out.println("Creating directory...");
                System.out.println(path.profile_dir+"");
                if(uploadDir.mkdirs()){
                    System.out.println("Directory created !!!");
                }
                else{
                    System.out.println("Failed to created directory");
                }
            } 
            Long id = IdFormat.generateId();
            while(userRepository.existsById(id)){
                id++;
            }
            profile.setId(id); 
            profile.setUserId(user_id);
            profile.setImgPath(path.profile_dir +"/"+user_id+""+id+".jpg");
            new StorageService(filePart, path.profile_dir, user_id+""+id);
            profileRepository.save(profile);
            return new ResponseEntity("Successfully uploaded", new HttpHeaders(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity("User not logged in", new HttpHeaders(), HttpStatus.FORBIDDEN);
        }
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<byte[]> pro(@RequestParam String u) throws IOException {//@RequestParam allow url with question mark
        Long user_id = getUserId(u);
        HttpHeaders headers = new HttpHeaders();
        InputStream in = context.getResourceAsStream("/WEB-INF/files/images/"+user_id+"/profiles/"+user_id+""+getLastProfileId(user_id)+".jpg");
        byte[] media = IOUtils.toByteArray(in);
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
        return responseEntity;//https://www.codegrepper.com/code-examples/java/spring+boot+save+file+to+static+folder
    }
    
    public Long getLastProfileId(Long user_id){
        List<ProfileEntity> profiles = profileRepository.findAllByUserId(user_id);
        ProfileEntity profile = Collections.max(profiles, Comparator.comparing(ProfileEntity::getDate));
        return profile.getId();
    }

    /*get any user_id */
    public Long getUserId(String username){
        UserEntity user = userRepository.findByUsername(username);
        return user.getId();
    }
}