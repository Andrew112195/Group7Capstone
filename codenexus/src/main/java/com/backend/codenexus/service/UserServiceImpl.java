package com.backend.codenexus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;

import java.util.List;

@Service
public class  UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean register(UserEntity user) {
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
    public UserEntity login(UserEntity user) {
        // catches null pointer exception on false return
        try {
            UserEntity checkUser = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            
            return checkUser;
        }
        catch(Exception e){
            return null;
        }
    }


    @Override
    public boolean updateUser(UserEntity user) {
        
        return false;
    }

    @Override
    public List<UserEntity> getAllStudents() {
        List<UserEntity> userEntity = userDao.findAllByUserTypeId(1);
        
        return userEntity;
    }
}