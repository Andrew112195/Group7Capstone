package com.backend.codenexus.service;

import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;
import com.backend.codenexus.model.TaskQuestionBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CourseServiceImpl implements CourseService {
    final static Logger Log = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private UserCourseDao userCourseDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ModuleDao moduleDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private QuizDao quizDao;

    //Course methods

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

    @Override
    public List<CourseEntity> getCourseList() {
        try {
            Log.debug("Fetching course list");
            List<CourseEntity> courseList = courseDao.findAll();
            Log.debug("Successfully fetched course list with {} items", courseList.size());
            return courseList;
        } catch (Exception e) {
            Log.error("Failed to fetch course list: {}", e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CourseEntity getSingleCourse(Long course_id) {

        return courseDao.findById(course_id).orElseThrow();
    }

    @Override
    public List<UserCourseEntity> getCourse(Long user_id) {
        Log.info("UserCourseServiceImpl getCourse");

        return userCourseDao.findByUserId(user_id);
    }

    @Override
    public List<UserCourseEntity> getAllClassmates(Long user_id){
        List<UserCourseEntity> classMates = userCourseDao.findClassmates(user_id);
        return classMates;
    }

    //Module Methods

    @Override
    public List<ModuleEntity> getCourseModules(Long course_id){

        return courseDao.findAllModulesByCourseId(course_id);
    }

    //Task Methods

    @Override
    public void completeTask(String findByTaskQuestion,String answer) {
        TaskEntity taskEntity = getTaskByQuestion(findByTaskQuestion);
        taskEntity.setCorrect(taskEntity.getAnswer().equals(answer));
        taskEntity.setComplete(true);
        taskDao.saveAndFlush(taskEntity);
    }

    @Override
    public List<TaskEntity> findAllTasksByModuleId(Long moduleId) {
        List<TaskEntity> taskEntityList = taskDao.findAllByModuleId(moduleId);
        
        return taskEntityList;
    }

    @Override
    public TaskEntity getTask(Long task_id) {
        TaskEntity taskEntity = moduleDao.findTaskById(task_id);
        return taskEntity;
    }

    @Override
    public TaskEntity getTaskByQuestion(String question){

        return moduleDao.findTaskByQuestion(question);
    }

    @Override
    public TaskQuestionBuilder buildTaskQuestion(ModuleEntity  module, TaskEntity task){

        Random random = new Random();

        TaskQuestionBuilder taskQuestionBuilder = new TaskQuestionBuilder();
        //store all the answers from all the modules int the current Course
        List<String> answers = courseDao.findAllModulesByCourseId(module.getCourseId().getId())
                .stream()
                .flatMap(eachModule -> eachModule.getTasks().stream())
                .map(TaskEntity::getAnswer)
                .toList();

        //now I have to randomize the answers
        int firstRandomIndex = random.nextInt(answers.size());
        String firstRandomAnswer = answers.get(firstRandomIndex);
        int secondRandomIndex = random.nextInt(answers.size());
        String secondRandomAnswer = answers.get(secondRandomIndex);
        String theAnswer = task.getAnswer();

        /*Lets build the object to pass on the front end*/
        taskQuestionBuilder.setQuestion(task.getQuestion());
        taskQuestionBuilder.setOptionA(firstRandomAnswer);
        taskQuestionBuilder.setOptionB(secondRandomAnswer);
        taskQuestionBuilder.setOptionC(theAnswer);

        return taskQuestionBuilder;
    }

    @Override
    public void update(Long taskId, String answer){
        TaskEntity task = getTask(taskId);
        boolean isCorrect = answer.equals(task.getAnswer());
        task.setCorrect(isCorrect);
        task.setComplete(true);
        taskDao.saveAndFlush(task);
    }

    //Quiz Methods

    @Override
    public QuizEntity getQuiz(Long quiz_id) {
        QuizEntity quizEntity = quizDao.findByQuizId(quiz_id);
        return quizEntity;
    }

    @Override
    public void completeQuiz(Long quiz_id) {
        QuizEntity quizEntity = getQuiz(quiz_id);
        quizEntity.setComplete(true);
        quizDao.saveAndFlush(quizEntity);
    }

    @Override
    public QuizEntity getModuleQuiz(Long module_id){
        QuizEntity quizEntity = moduleDao.findQuizById(module_id);
        return quizEntity;
    }

    @Override
    public void addQuizToModule(QuizEntity quiz) {
        QuizEntity quizEntity = new QuizEntity();
        quizDao.saveAndFlush(quizEntity);
    }
}