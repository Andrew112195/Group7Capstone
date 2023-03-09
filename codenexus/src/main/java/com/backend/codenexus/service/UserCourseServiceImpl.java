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

        userCourseDao.findByUserId(user_id);
 //       if(userEnt.isPresent()) {
//            UserEntity userEntity = userEnt.get();
//            User user = new User();
//            List<UserCourseEntity> userCourseEntities = userEnt.get().getUserCourse();
//
//            BeanUtils.copyProperties(userEntity,user);
//            System.out.println(user);
//
//            List <UserCourse> userCourse = userCourseEntities.stream().map(userCourseEntity1 -> {
//                UserCourse userCourse1 = new UserCourse();
//                BeanUtils.copyProperties(userCourseEntity1,userCourse1);
//                userCourse1.setUser(user);
//                System.out.println(user);
//                return userCourse1;
//            }).toList();

            //return userCourse;
 //       }
//        List <UserCourseEntity> userCourseEntity = userCourseDao.findByUserId(user_id);

        return null;
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
