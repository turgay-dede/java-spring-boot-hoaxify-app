package com.hoaxifyapp.hoaxifyapp.api;

import com.hoaxifyapp.hoaxifyapp.business.abstracts.UserService;
import com.hoaxifyapp.hoaxifyapp.business.constants.Messages;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.*;
import com.hoaxifyapp.hoaxifyapp.entities.concreates.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        this.userService.add(theUser);
        return new SuccessResult(Messages.Added);
    }

    @GetMapping("/delete")
    public Result delete(@RequestBody User theUser){
        this.userService.delete(theUser);
        return new SuccessResult(Messages.Deleted);
    }

    @PostMapping("/update")
    public Result update(@Valid @RequestBody User theUser){
        this.userService.update(theUser);
        return new SuccessResult(Messages.Updated);
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){
        return new SuccessDataResult<>(this.userService.getAll().getData(),Messages.Listed);
    }

    @GetMapping("/getbyid")
    public DataResult<User> getById(int theId){
        return new SuccessDataResult<>(this.userService.getById(theId).getData(),Messages.Finded);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleValidationException(MethodArgumentNotValidException exception){

        StringBuilder validationErrors = new StringBuilder();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            validationErrors.append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage()).append(" ");
        }
        return new ErrorResult(validationErrors.toString());
    }
}
