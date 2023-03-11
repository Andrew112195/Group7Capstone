package com.backend.codenexus.service;
import com.backend.codenexus.dao.CourseDao;
import com.backend.codenexus.dao.UserDao;
import com.backend.codenexus.entity.CourseEntity;
import com.backend.codenexus.entity.UserEntity;
import com.backend.codenexus.model.Course;
import com.backend.codenexus.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import com.backend.codenexus.dao.UserCourseDao;
import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.model.UserCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCourseServiceImpl implements UserCourseService {
    final static Logger LOG = LoggerFactory.getLogger(UserCourseServiceImpl.class);
    
    @Autowired
    UserCourseDao userCourseDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    UserDao userDao;


    @Override
    public List<UserCourse> getCourse(Long user_id) {
        LOG.info("UserCourseServiceImpl getCourse");
/* Course should return course that user is enrolled in*/
        List<UserCourseEntity> userCourses = userCourseDao.findByUserId(user_id);
        /*get the course ID and use it to find the course and set it under user course entity*/
        ;
        List<UserCourse> userCoursesList = userCourses.stream().map(userCourseEntity -> {
            UserEntity userEntity = userDao.findById(user_id).orElseThrow();
            User user = new User();
            BeanUtils.copyProperties(userEntity, user);
            UserCourse userCourse = new UserCourse();
            Optional<CourseEntity> foundCourse =courseDao.findById(userCourseEntity.getCourse().getId());
            userCourseEntity.setCourse(foundCourse.get());
            Course course = new Course();
            BeanUtils.copyProperties(userCourseEntity.getCourse(), course);
            BeanUtils.copyProperties(userCourseEntity, userCourse);
            userCourse.setCourse(course);
            userCourse.setUser(user);
            return userCourse;
        }).toList();

        return userCoursesList;
    }

    @Override
    public void addNewCourseToUser(long user_id, long course_id) {
        try {
            UserEntity foundUser = userDao.findById(user_id);
            CourseEntity foundCourse = courseDao.findById(course_id).orElseThrow();
            UserCourseEntity userCourseEntity = new UserCourseEntity();
            userCourseEntity.setUser(foundUser);
            userCourseEntity.setCourse(foundCourse);
            userCourseDao.saveAndFlush(userCourseEntity);
        } catch (Exception e) {
            e.getStackTrace();
        }

    }


}
