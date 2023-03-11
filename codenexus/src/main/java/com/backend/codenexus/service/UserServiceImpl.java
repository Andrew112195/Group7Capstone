package com.backend.codenexus.service;

import com.backend.codenexus.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;

import java.util.ArrayList;
import java.util.List;

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
        
        return false;
        
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
    public boolean updateUser(User user) {
        
        return false;
    }

    @Override
    public List<User> getAllStudents() {
        List<UserEntity> userEntity = userDao.findAllByUserTypeId(1);
        List<User> users = new ArrayList<>();
        for(UserEntity user: userEntity){
            User user1 = new User();
            BeanUtils.copyProperties(user,user1);
            users.add(user1);

        }
        return users;
    }
}