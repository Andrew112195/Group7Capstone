package com.backend.codenexus.service;

import com.backend.codenexus.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User register(User user) {
        /* use the userDao to create logic of data to populate */
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userDao.saveAndFlush(userEntity);
        return null;
    }

    @Override
    public User login(User user) {
        String username = user.getUsername();
        // this returns the found user
        UserEntity checkUser = userDao.findByUsername(username);
        User returnUser = new User();
        BeanUtils.copyProperties(checkUser, returnUser);

        return returnUser;
    }

    @Override
    public User updateUser(User user) {

        return null;
    }
}