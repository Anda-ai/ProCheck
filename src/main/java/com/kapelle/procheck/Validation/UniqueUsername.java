package com.kapelle.procheck.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.kapelle.procheck.Model.UserEntity;
import com.kapelle.procheck.Model.UserRepository;



public class UniqueUsername implements ConstraintValidator<UniqueUsernameConstraint, String> {

    @Autowired
    UserRepository userRespository;

    @Override
    public void initialize(UniqueUsernameConstraint username) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext cxt) {
        if(username == null){
            return false;
        }
        try{
            UserEntity user = userRespository.findByUsername(username);
            if(user != null){
                return false;
            }
            else{
                return true;
            }
        }
        catch(Exception e){
            return true;
        }
    }
}