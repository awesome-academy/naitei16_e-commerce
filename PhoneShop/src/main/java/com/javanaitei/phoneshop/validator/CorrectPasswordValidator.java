package com.javanaitei.phoneshop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javanaitei.phoneshop.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;

public class CorrectPasswordValidator implements ConstraintValidator<CorrectPassword, Object> {

    private static final Logger log = LoggerFactory.getLogger(CorrectPasswordValidator.class);

    private String name;
    private String message;

    @Autowired
    UserServiceImpl userServiceImpl;

    @Override
    public void initialize(final CorrectPassword constraintAnnotation) {
        this.name = constraintAnnotation.name();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object user, final ConstraintValidatorContext context) {
        boolean valid = true;
        try {
            String oldPassword = BeanUtils.getProperty(user, name);
            if (oldPassword == null)
                return true;
            String ids = BeanUtils.getProperty(user, "id");
            Long id = Long.parseLong(ids);
            valid = userServiceImpl.checkPassword(oldPassword, id);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error(e.getMessage(), e);
        }
        if (!valid) {
            context.buildConstraintViolationWithTemplate(message).addPropertyNode(name).addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return valid;
    }
}
