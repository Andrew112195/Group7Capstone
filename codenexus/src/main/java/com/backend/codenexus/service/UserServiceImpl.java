package com.backend.codenexus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class  UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserCourseDao userCourseDao;
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
    @Transactional
    public UserEntity updateUser(UserEntity user){
        userCourseDao.updateAllCourses();
        return userDao.updateUser(user.getId());
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
    public List<UserEntity> getAllStudents() {
        List<UserEntity> userEntity = userDao.findAllByUserTypeId(1);
        
        return userEntity;
    }
}