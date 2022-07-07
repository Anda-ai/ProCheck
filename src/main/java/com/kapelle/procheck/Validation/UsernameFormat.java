package com.kapelle.procheck.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameFormat implements ConstraintValidator<UsernameFormatConstraint, String> {

    @Override
    public void initialize(UsernameFormatConstraint username) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext cxt) {
        String name = "^[A-Za-z._ ]*$";
        if(username == null){
            return false;
        }
        return username.matches(name) 
             && !username.startsWith("_") && !username.startsWith(".")
             && !username.endsWith("_") && !username.endsWith(".") 
             && (username.contains(".") | username.contains("_"));
    }

}