package com.hoaxifyapp.hoaxifyapp.api;

import com.hoaxifyapp.hoaxifyapp.business.abstracts.UserService;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.*;
import com.hoaxifyapp.hoaxifyapp.entities.concreates.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService theUserService) {
        this.userService = theUserService;
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody User theUser){
        return this.userService.add(theUser);
    }

    @GetMapping("/delete")
    public Result delete(@RequestBody User theUser){
        return this.userService.delete(theUser);
    }

    @PostMapping("/update")
    @PreAuthorize("#user.username == #principal.getName()")//SpEL
    public Result update(@RequestBody User user, Principal principal){
        return this.userService.update(user,principal);
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    @GetMapping("/getall/pageable")
    public DataResult<List<User>> getAllPageable(Pageable pageable){
        return this.userService.getAllPageable(pageable);
    }

    @GetMapping("/get/{theId}")
    public DataResult<User> getById(@PathVariable int theId){
        return this.userService.getById(theId);
    }

}
