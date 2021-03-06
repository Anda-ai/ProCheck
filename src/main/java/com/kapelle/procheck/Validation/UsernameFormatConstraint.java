package com.kapelle.procheck.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UsernameFormat.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameFormatConstraint {
    String message() default "Incorrect username format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
