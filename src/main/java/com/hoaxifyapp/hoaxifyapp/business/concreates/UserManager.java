package com.hoaxifyapp.hoaxifyapp.business.concreates;

import com.hoaxifyapp.hoaxifyapp.business.abstracts.UserService;
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
    public void add(User theUser) {
        this.userDao.save(theUser);
    }

    @Override
    public void delete(User theUser) {
        this.userDao.delete(theUser);
    }

    @Override
    public void update(User theUser) {
        this.userDao.save(theUser);
    }

    @Override
    public List<User> getAll() {
        return this.userDao.findAll();
    }

    @Override
    public User getById(int theId) {
        return this.userDao.getById(theId);
    }
}
