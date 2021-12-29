package com.hoaxifyapp.hoaxifyapp.business.concreates;

import com.hoaxifyapp.hoaxifyapp.business.abstracts.UserService;
import com.hoaxifyapp.hoaxifyapp.business.constants.Messages;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.*;
import com.hoaxifyapp.hoaxifyapp.dataAccess.UserDao;
import com.hoaxifyapp.hoaxifyapp.entities.concreates.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    UserDao userDao;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserManager(UserDao theUserDao, PasswordEncoder passwordEncoder) {
        this.userDao = theUserDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Result add(User theUser) {
        theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
        this.userDao.save(theUser);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public Result delete(User theUser) {
        this.userDao.delete(theUser);
        return new SuccessResult(Messages.Deleted);
    }

    @Override
    public Result update(User theUser) {
        theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
        this.userDao.save(theUser);
        return new SuccessResult(Messages.Updated);
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(this.userDao.findAll(), Messages.Listed);
    }

    @Override
    public DataResult<List<User>> getAllPageable(Pageable pageable) {
        return new SuccessDataResult<>(userDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<User> getById(int theId) {
        User theUser = this.userDao.findById(theId);

        if (theUser == null) {
            return new ErrorDataResult<>("Kullanıcı bulunamadı", null);
        }
        return new SuccessDataResult<>(theUser,Messages.Finded);
    }
}
