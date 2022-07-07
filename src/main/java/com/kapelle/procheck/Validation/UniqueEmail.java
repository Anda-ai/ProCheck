package com.kapelle.procheck.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.kapelle.procheck.Model.UserEntity;
import com.kapelle.procheck.Model.UserRepository;



public class UniqueEmail implements ConstraintValidator<UniqueEmailConstraint, String> {

    @Autowired
    UserRepository userRespository;

    @Override
    public void initialize(UniqueEmailConstraint email) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        if(email == null){
            return false;
        }
        try{
            UserEntity user = userRespository.findByEmail(email);
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