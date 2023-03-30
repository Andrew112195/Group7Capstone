package com.backend.codenexus.service;

import com.backend.codenexus.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    boolean register(UserEntity user);

    UserEntity updateProfile(UserEntity user);

    UserEntity login(UserEntity user);

    boolean changePassword(UserEntity user, String oldPassword, String newPassword);

    List<UserEntity> getAllStudents();

    UserEntity updateUser(UserEntity user);
}
