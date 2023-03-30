package com.backend.codenexus.service;

import com.backend.codenexus.dao.CourseDao;
import com.backend.codenexus.dao.UserCourseDao;
import com.backend.codenexus.dao.UserDao;
import com.backend.codenexus.entity.CourseEntity;
import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;

@SpringBootTest
class CourseServiceImplTest {

    @Mock
    private CourseDao courseDao;

    @Mock
    private UserDao userDao=mock(UserDao.class);



    @Mock
    private UserCourseDao userCourseDao;
    @Test
    void addNewCourseToUser() {
        List<CourseEntity> courses = Arrays.asList(new CourseEntity(1L,"new","whatever",2,null,null));
        List<UserEntity> users = Arrays.asList(new UserEntity(1L,1L,"yo", "yo","yo@gmail.com","yo","yo",null,null,null, null));

        UserEntity foundUser = users.get(0);

        CourseEntity foundCourse = courses.get(0);


        when(userDao.findById(1L)).thenReturn(foundUser);
        when(courseDao.findById(1L).get()).thenReturn(foundCourse);

        UserCourseEntity userCourseEntity = new UserCourseEntity();
        userCourseEntity.setUser(foundUser);
        userCourseEntity.setCourse(foundCourse);

        when(userCourseDao.saveAndFlush(userCourseEntity)).thenReturn(userCourseEntity);

        UserCourseEntity savedUserCourseEntity = userCourseDao.saveAndFlush(userCourseEntity);


        Assertions.assertEquals(savedUserCourseEntity.getUser(), foundUser);
        Assertions.assertEquals(savedUserCourseEntity.getCourse(), foundCourse);

    /*    @RunWith(MockitoJUnitRunner.class)
        public class UserServiceTest {

            @Mock
            private UserRepository userRepository;

            @InjectMocks
            private UserService userService;

            @Test
            public void testFindByLastName() {
                List<User> users = new ArrayList<>();
                users.add(new User("John", "Doe"));
                Mockito.when(userRepository.findByLastName("Doe")).thenReturn(users);

                List<User> result = userService.findByLastName("Doe");

                Assert.assertEquals(users, result);
            }
        }*/


      /*  @Override
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
        }*/
    }

    @Test
    void getCourse() {
    }
}