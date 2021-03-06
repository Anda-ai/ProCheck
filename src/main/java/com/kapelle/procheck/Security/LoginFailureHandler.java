package com.kapelle.procheck.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
 
     
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
            System.out.println("error: "+exception.getMessage());
            //String redirectURL = "/login?error="+exception.getMessage();
            String redirectURL = "/login";
            super.setDefaultFailureUrl(redirectURL);
            super.onAuthenticationFailure(request, response, exception);
    }
}
