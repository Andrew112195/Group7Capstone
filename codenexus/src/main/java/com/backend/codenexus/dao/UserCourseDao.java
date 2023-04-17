package com.backend.codenexus.dao;

import com.backend.codenexus.entity.UserCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface UserCourseDao extends JpaRepository<UserCourseEntity, Long> {

    @Query(value = "SELECT * FROM user_course us WHERE user_id =?1",nativeQuery=true)
    List<UserCourseEntity> findByUserId(Long userId);

    @Query(value = "SELECT uc FROM UserCourseEntity uc, UserEntity ue WHERE uc.user.id != ?1")
    List<UserCourseEntity> findClassmates(Long user_id);

}