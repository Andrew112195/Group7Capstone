package com.backend.codenexus.service;

import com.backend.codenexus.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User register(User user) {
        /*use the userDao to create logic of data to populate*/
        return null;
    }

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
