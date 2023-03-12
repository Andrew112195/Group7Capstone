package com.backend.codenexus.service;

import org.springframework.stereotype.Service;

import com.backend.codenexus.entity.UserEntity;

import java.util.List;

@Service
public interface UserService {

    boolean register(UserEntity user);

    UserEntity login(UserEntity user);

    boolean updateUser(UserEntity user);
    List<UserEntity> getAllStudents();


}
