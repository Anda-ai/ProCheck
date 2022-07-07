package com.kapelle.procheck.Security;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kapelle.procheck.Model.UserEntity;
import com.kapelle.procheck.Model.UserRepository; 

public class UserInfoService implements UserDetailsService { 
    @Autowired 
    private UserRepository userRepository; 
    
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
        UserEntity user = userRepository.findByUsername(username); 
        if (user == null) { 
            throw new UsernameNotFoundException("Could not find user"); 
        } 
        return new UserInfo(user); 
    } 
    
}