package com.hoaxifyapp.hoaxifyapp.business.concreates;

import com.hoaxifyapp.hoaxifyapp.business.abstracts.UserService;
import com.hoaxifyapp.hoaxifyapp.business.constants.Messages;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.DataResult;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.Result;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.SuccessDataResult;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.SuccessResult;
import com.hoaxifyapp.hoaxifyapp.dataAccess.UserDao;
import com.hoaxifyapp.hoaxifyapp.entities.concreates.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    UserDao userDao;

    @Autowired
    public UserManager(UserDao theUserDao) {
        this.userDao = theUserDao;
    }

    @Override
    public Result add(User theUser) {
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
        this.userDao.save(theUser);
        return new SuccessResult(Messages.Updated);
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(this.userDao.findAll(),Messages.Listed);
    }

    @Override
    public DataResult<User> getById(int theId) {
        return new SuccessDataResult<>(this.userDao.getById(theId),Messages.Finded);
    }
}
