package com.javanaitei.phoneshop.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PhoneValidator.class)
@Documented
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface Phone {
    String message() default "Phone number must be 10 digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}