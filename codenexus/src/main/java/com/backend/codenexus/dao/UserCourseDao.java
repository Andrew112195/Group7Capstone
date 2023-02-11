package com.backend.codenexus.dao;

import com.backend.codenexus.entity.UserCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserCourseDao extends JpaRepository<UserCourseEntity, Long> {

    UserCourseEntity findByUserId(long userId);
}
