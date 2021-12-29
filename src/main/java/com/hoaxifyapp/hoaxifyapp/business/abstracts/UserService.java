package com.hoaxifyapp.hoaxifyapp.business.abstracts;

import com.hoaxifyapp.hoaxifyapp.business.utilities.annotations.CurrentUser;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.DataResult;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.Result;
import com.hoaxifyapp.hoaxifyapp.entities.concreates.User;
import com.hoaxifyapp.hoaxifyapp.entities.concreates.dtos.UpdateUserDto;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.List;

public interface UserService {
    Result add(User theUser);
    Result delete(User theUser);
    Result update(User user, Principal principal);
    DataResult<List<User>> getAll();
    DataResult<List<User>> getAllPageable(Pageable pageable);
    DataResult<User> getById(int theId);

}
