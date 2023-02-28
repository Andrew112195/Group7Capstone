package com.backend.codenexus.service;

import com.backend.codenexus.model.User;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;

@Service
public class  UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean register(User user) {
        /* use the userDao to create logic of data to populate */
        //searches for existing username
        if (!userDao.existsByUsername(user.getUsername())) {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(user, userEntity);
            userDao.saveAndFlush(userEntity);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public User login(User user) {
        // catches null pointer exception on false return
        try {
            UserEntity checkUser = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            User returnUser = new User();
            BeanUtils.copyProperties(checkUser, returnUser);
            return returnUser;
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public User updateUser(User user) {

        return null;
    }
}