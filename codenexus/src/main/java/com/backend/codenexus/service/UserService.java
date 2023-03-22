package com.backend.codenexus.service;

import com.backend.codenexus.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UserService {

    boolean register(UserEntity user);

    UserEntity login(UserEntity user);

    List<UserEntity> getAllStudents();

    UserEntity updateUser(UserEntity user);
}
