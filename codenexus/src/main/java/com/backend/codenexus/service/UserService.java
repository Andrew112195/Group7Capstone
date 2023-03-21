package com.backend.codenexus.service;


import com.backend.codenexus.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    boolean register(User user);

    User login(User user);

    boolean updateUser(User user);
    
    List<User> getAllStudents();

   


}
