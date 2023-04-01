package com.backend.codenexus.dao;

import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.entity.UserEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Data Access Object

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {
    @Query("select (count(u) > 0) from UserEntity u where lower(u.username) = lower(?1)")
    boolean existsByUsername(@NonNull String username);

    @Query(value = "SELECT u FROM UserEntity u , MessagesEntity m, UserCourseEntity c, CourseEntity ce, ModuleEntity me WHERE u.id = ?1")
    UserEntity updateUser(Long user_id);

    @Query(value = "select * from user_entity ue where ue.id = ?1", nativeQuery = true)
    UserEntity findById(long user_id);

    @Query(value = "SELECT * FROM user_entity WHERE username = ?1 AND password = ?2 ", nativeQuery = true)
    UserEntity findByUsernameAndPassword(String username,String password);
    List<UserEntity> findAllByUserTypeId(long userTypeId);
}
