package com.backend.codenexus.service;

import com.backend.codenexus.entity.*;

import java.util.List;

public interface TaskService {

    List<TaskEntity> findAllTasksByCourseId(Long courseId);

    void updateTaskToComplete(TaskEntity task);

}
