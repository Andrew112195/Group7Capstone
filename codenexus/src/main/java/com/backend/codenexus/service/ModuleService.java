package com.backend.codenexus.service;

import java.util.List;

import com.backend.codenexus.model.*;
import com.backend.codenexus.model.Module;

public interface ModuleService {

    Task getTask(Long task_id);

    Quiz getQuiz(Long quiz_id);

    void completeTask(Long task_id);

    void completeQuiz(Long quiz_id);

    List<Task> getModuleTasks(Long module_id);

    Quiz getModuleQuiz(Long module_id);

    void addTaskToModule(Task task);

    void addQuizToModule(Quiz quiz);

}