package com.hoaxifyapp.hoaxifyapp.business.abstracts;

import com.hoaxifyapp.hoaxifyapp.entities.concreates.User;

import java.util.List;

public interface UserService {
    void add(User theUser);
    void delete(User theUser);
    void update(User theUser);
    List<User> getAll();
    User getById(int theId);

}
