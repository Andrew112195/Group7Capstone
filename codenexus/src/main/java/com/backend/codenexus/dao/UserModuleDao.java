package com.backend.codenexus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.codenexus.entity.UserModuleEntity;

@Repository
public interface UserModuleDao  extends JpaRepository<UserModuleEntity, Long> {

}
