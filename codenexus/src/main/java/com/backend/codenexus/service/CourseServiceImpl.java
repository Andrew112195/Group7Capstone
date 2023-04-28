package com.backend.codenexus.service;

import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;
import com.backend.codenexus.model.TaskQuestionBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private UserModuleDao userModuleDao;
    @Autowired
    private UserTaskDao userTaskDao;

    //Course methods

    @Override
    public void addNewCourseToUser(long user_id, long course_id) {
        try {
            UserEntity foundUser = userDao.findById(user_id);
            CourseEntity foundCourse = courseDao.findById(course_id).orElseThrow();
            
            // course(module(task, task, task), module(task, task, task), module(task, task, task))
            List<ModuleEntity> courseModules = foundCourse.getModules();
            List<UserModuleEntity> userModules = new ArrayList<>();
            List<TaskEntity> taskEntities = new ArrayList<>();
            List<UserTaskEntity> userTasks = new ArrayList<>();

            UserCourseEntity userCourseEntity = new UserCourseEntity();

            courseModules.forEach(module -> {
                //Create user module and perform the setters
                UserModuleEntity userModuleEntity = new UserModuleEntity();
                userModuleEntity.setModuleEntity(module);
                userModuleEntity.setUserCourse(userCourseEntity);
                //add the user module to the List
                userModules.add(userModuleEntity);
                userModuleDao.saveAndFlush(userModuleEntity);

                taskEntities.addAll(module.getTasks());
                taskEntities.forEach(task ->{
                    //Create user task and perform the setters
                    UserTaskEntity userTaskEntity = new UserTaskEntity();
                    userTaskEntity.setTask(task);
                    userTaskEntity.setModule(userModuleEntity);
                    userTaskEntity.setUserCourse(userCourseEntity);
                    //add the user task to the list
                    userTasks.add(userTaskEntity);
                    userTaskDao.saveAndFlush(userTaskEntity);
                });
                
            });
            //Set all the objects to the user course
            userCourseEntity.setUser(foundUser);
            userCourseEntity.setCourse(foundCourse);
            userCourseEntity.setUserModule(userModules);
            userCourseEntity.setUserTask(userTasks);
            //save user course
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
    public List<UserModuleEntity> getCourseModules(Long course_id){
        UserCourseEntity userCourse = userCourseDao.getReferenceById(course_id);

        return userCourse.getUserModule();
    }

    @Override
    public List<ModuleEntity> getAllModules(){
        return moduleDao.findAll();
    }

    //Task Methods

    @Override
    public void completeTask(String findByTaskQuestion,String answer, Long userCourseId) {
        TaskEntity taskEntity = getTaskByQuestion(findByTaskQuestion);
        UserCourseEntity userCourse = userCourseDao.getReferenceById(userCourseId);
       
        UserTaskEntity userTask = getTask(taskEntity.getId(), userCourseId);
        
        userTask.setCorrect(taskEntity.getAnswer().equals(answer));
        userTask.setComplete(true);

        userTaskDao.saveAndFlush(userTask);
        userCourseDao.saveAndFlush(userCourse);
    }

    @Override
    public List<UserTaskEntity> findAllTasksByModuleId(Long moduleId, Long userCourseId) {
        UserCourseEntity userCourse = userCourseDao.getReferenceById(userCourseId);
        List<UserTaskEntity> taskEntityList = userCourse.getUserTask();
        List<UserTaskEntity> newTaskList = new ArrayList<>();

        taskEntityList.forEach(task -> {
            if(task.getTask().getModule().getId().equals(moduleId)){
                newTaskList.add(task);
            }
        });
        
        return newTaskList;
    }

    @Override
    public UserTaskEntity getTask(Long taskId, Long userCourseId) {
        UserCourseEntity userCourse = userCourseDao.getReferenceById(userCourseId);
        
        List<UserTaskEntity> userTaskList = userCourse.getUserTask();
        UserTaskEntity userTask = new UserTaskEntity();
        
        for(int x = 0; x < userTaskList.size(); x++){
            if(taskId.equals(userTaskList.get(x).getTask().getId())){
                userTask = userTaskList.get(x);
            }
        }
        
        return userTask;
    }

    @Override
    public TaskEntity getTaskByQuestion(String question){

        return moduleDao.findTaskByQuestion(question);
    }

    @Override
    public void saveTask(TaskEntity task){
        taskDao.saveAndFlush(task);
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