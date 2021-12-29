package com.hoaxifyapp.hoaxifyapp.business.abstracts;

import com.hoaxifyapp.hoaxifyapp.core.utilities.results.DataResult;
import com.hoaxifyapp.hoaxifyapp.core.utilities.results.Result;
import com.hoaxifyapp.hoaxifyapp.entities.concreates.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    Result add(User theUser);
    Result delete(User theUser);
    Result update(User theUser);
    DataResult<List<User>> getAll();
    DataResult<List<User>> getAllPageable(Pageable pageable);
    DataResult<User> getById(int theId);

}
