package com.backend.codenexus.service;

import com.backend.codenexus.dao.UserCourseDao;
import com.backend.codenexus.dao.UserDao;
import com.backend.codenexus.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserCourseDao userCourseDao;

    @Override
    @SuppressWarnings("null")
    public boolean register(UserEntity user) {
        // check if the username already exists in the database
        if (!userDao.existsByUsername(user.getUsername())) {
            // create a new user entity and save it to the database
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(user, userEntity);
            userDao.saveAndFlush(userEntity);
            return true; // registration successful
        }
        return false; // registration unsuccessful: username already exists
    }

    @Override
    public UserEntity login(UserEntity user) {
        try {
            // find the user in the database by username and password
            return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        }
        catch(Exception e){
            return null; // login unsuccessful: user not found in the database
        }
    }

    @Override
    public List<UserEntity> getAllStudents() {
        // find all users with userTypeId=1 (students) in the database
        return userDao.findAllByUserTypeId(1);
    }

    @Override
    @Transactional
    public UserEntity updateUser(UserEntity user){
        return userDao.updateUser(user.getId());
    }

    @Override
    public UserEntity updateProfile(UserEntity user){

        // find the existing user in the database
        UserEntity findUser = userDao.findById(user.getId()).get();

        // update the user's profile information
        findUser.setFirstname(user.getFirstname());
        findUser.setLastname(user.getLastname());
        findUser.setUsername(user.getUsername());
        findUser.setEmail(user.getEmail());

        return userDao.save(findUser); // save the updated user entity to the database
    }

    @Override
    public boolean changePassword(UserEntity user, String oldPassword, String newPassword) {
        if (user == null || oldPassword == null || newPassword == null) {
            return false; // input validation: null values not allowed
        }

        if (!Objects.equals(user.getPassword(), oldPassword)) {
            return false; // old password is incorrect
        }

        try {
            UserEntity updatedUser = userDao.findByUsernameAndPassword(user.getUsername(), oldPassword);
            updatedUser.setPassword(newPassword);
            userDao.save(updatedUser);
            return true; // password updated successfully
        } catch (Exception e) {
            return false; // an error occurred while updating the password
        }
    }
}
