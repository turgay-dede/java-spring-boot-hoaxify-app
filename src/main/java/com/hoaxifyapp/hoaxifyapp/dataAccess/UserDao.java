package com.hoaxifyapp.hoaxifyapp.dataAccess;

import com.hoaxifyapp.hoaxifyapp.entities.concreates.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String theUsername);
}
