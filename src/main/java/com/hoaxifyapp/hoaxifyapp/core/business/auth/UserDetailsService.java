package com.hoaxifyapp.hoaxifyapp.core.business.auth;

import com.hoaxifyapp.hoaxifyapp.dataAccess.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userDao.findByUsername(username) != null){
            return new User(username,userDao.findByUsername(username).getPassword(),new ArrayList<>());
        }
        throw new UsernameNotFoundException(username);
    }
}
