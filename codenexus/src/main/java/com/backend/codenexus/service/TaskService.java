package com.backend.codenexus.service;

import com.backend.codenexus.model.*;

import java.util.List;

public interface TaskService {

    List<Task> findAllTasksByCourseId(Long courseId);

    void updateTaskToComplete(Task task);

}
