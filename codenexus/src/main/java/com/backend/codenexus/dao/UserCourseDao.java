package com.backend.codenexus.dao;
import com.backend.codenexus.entity.*;
import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.entity.UserEntity;
import org.hibernate.query.NativeQuery;
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

    @Query(value = "SELECT * FROM user_course uc, user_entity ue " +
            "JOIN uc ON ue WHERE uc.course_id = ?1 AND uc.user_id = ue.id AND uc.user_id != ?2", nativeQuery = true)
        List<UserCourseEntity> findUsersInSameCourse(Long course_id, Long User_id);

    @Query(value = "SELECT u FROM UserCourseEntity u, CourseEntity c, ModuleEntity m, TaskEntity t WHERE m.courseId.id = c.id ")
    UserCourseEntity updateAllCourses();

    @Query(value = "SELECT uc FROM UserCourseEntity uc, UserEntity ue WHERE uc.user.id != ?1")
    List<UserCourseEntity> findClassmates(Long user_id);


}
