package com.backend.codenexus.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import com.backend.codenexus.dao.UserCourseDao;
import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.model.UserCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCourseServiceImpl implements UserCourseService {
    final static Logger LOG = LoggerFactory.getLogger(UserCourseServiceImpl.class);
    
    @Autowired
    UserCourseDao userCourseDao;

    @Override
    public UserCourse getCourse(Long user_id) {
        UserCourseEntity userCourseEntity = userCourseDao.findByUserId(user_id);
        UserCourse userCourse = new UserCourse();
        BeanUtils.copyProperties(userCourseEntity,userCourse);
        return userCourse;
    }

    @Override
    public void addNewCourseToUser(UserCourse course) {
        try {
            UserCourseEntity userCourseEntity = new UserCourseEntity();
            BeanUtils.copyProperties(course,userCourseEntity);

            userCourseDao.saveAndFlush(userCourseEntity);
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
