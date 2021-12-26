package com.hoaxifyapp.hoaxifyapp.business.utilities.annotations;

import com.hoaxifyapp.hoaxifyapp.dataAccess.UserDao;
import com.hoaxifyapp.hoaxifyapp.entities.concreates.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    @Autowired
    UserDao userDao;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        User user = this.userDao.findByUsername(username);
        if(user != null){
            return false;
        }
        return true ;
    }
}
