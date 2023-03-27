package com.backend.codenexus.service;

import com.backend.codenexus.dao.UserCourseDao;
import com.backend.codenexus.dao.UserDao;
import com.backend.codenexus.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return userDao.updateUser(user.getId());
    }

    @Override
    public UserEntity login(UserEntity user) {
        // catches null pointer exception on null return
        try {
            UserEntity checkUser = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            return checkUser;
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public boolean changePassword(UserEntity user, String oldPassword, String newPassword){
        // catches null pointer exception on null return
        try {
            userDao.findByUsernameAndPassword(user.getUsername(), oldPassword);
            //if old password doesnot match will throw exception
            user.setPassword(newPassword);
            userDao.saveAndFlush(user);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    @Override
    public List<UserEntity> getAllStudents() {
        List<UserEntity> allStudents = userDao.findAllByUserTypeId(1);
        
        return allStudents;
    }

  
}