package com.backend.codenexus.dao;

import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

//Data Access Object
@EnableJpaRepositories
@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {
    @Query("select (count(u) > 0) from UserEntity u where u.username = ?1")
    boolean existsByUsername(@NonNull String username);

    @Query(value = "SELECT u FROM UserEntity u , MessagesEntity m, UserCourseEntity c, CourseEntity ce, ModuleEntity me WHERE u.id = ?1")
    UserEntity updateUser(Long user_id);

    @Query(value = "select ue from user_entity ue where ue.id = ?1", nativeQuery = true)
    UserEntity findById(long user_id);

    @Query(value = "SELECT * FROM user_entity WHERE username = ?1", nativeQuery = true)
    UserEntity findByUsername(String username);

    @Query(value = "SELECT * FROM user_entity WHERE username = ?1 AND password = ?2 ", nativeQuery = true)
    UserEntity findByUsernameAndPassword(String username,String password);
    List<UserEntity> findAllByUserTypeId(long userTypeId);

    @Query(value = "SELECT u FROM UserEntity u join UserCourseEntity uc on u.id = uc.user.id and uc.user.id != ?1")
    List<UserCourseEntity> findClassmates(Long User_id);
}
