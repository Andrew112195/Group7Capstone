package com.backend.codenexus.service;

import com.backend.codenexus.dao.TaskDao;
import com.backend.codenexus.entity.TaskEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    TaskDao taskDao;


    @Override
    public List<TaskEntity> findAllTasksByCourseId(Long courseId) {
        List<TaskEntity> taskEntityList = taskDao.findAllByCourseId(courseId);
        
        return taskEntityList;
    }

    @Override
    public void updateTaskToComplete(TaskEntity task) {

    }
}
