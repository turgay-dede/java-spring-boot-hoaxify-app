package com.hoaxifyapp.hoaxifyapp.api;

import com.hoaxifyapp.hoaxifyapp.business.abstracts.UserService;
import com.hoaxifyapp.hoaxifyapp.entities.concreates.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService theUserService) {
        this.userService = theUserService;
    }

    @PostMapping("/add")
    public void add(@RequestBody User theUser){
        this.userService.add(theUser);
    }

    @GetMapping("/delete")
    public void delete(@RequestBody User theUser){
        this.userService.delete(theUser);
    }

    @PostMapping("/update")
    public void update(@RequestBody User theUser){
        this.userService.update(theUser);
    }

    @GetMapping("/getall")
    public void getAll(){
        this.userService.getAll();
    }

    @GetMapping("/getbyid")
    public void getById(int theId){
        this.userService.getById(theId);
    }
}
