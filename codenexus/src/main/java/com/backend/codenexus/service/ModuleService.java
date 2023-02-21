package com.backend.codenexus.service;

import java.util.List;

import com.backend.codenexus.model.*;
import com.backend.codenexus.model.Module;

public interface ModuleService {

    void completeTask();

    void createTask(Task task);

    List<Task> getTasks(Long module_id);

    void addTaskToModule(Long task_id);

    void addQuizToModule(Long quiz_id);

}