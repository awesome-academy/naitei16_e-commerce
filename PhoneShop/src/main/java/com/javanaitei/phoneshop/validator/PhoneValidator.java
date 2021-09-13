package com.javanaitei.phoneshop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(final Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(final String phone, final ConstraintValidatorContext context) {
        return phone.matches("(09|03|07|08|05)+([0-9]{8})\\b");
    }
}

