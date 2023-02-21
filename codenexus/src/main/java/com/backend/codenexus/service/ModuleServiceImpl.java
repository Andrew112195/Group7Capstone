package com.backend.codenexus.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;
import com.backend.codenexus.model.*;
import com.backend.codenexus.model.Module;

@Service
public class ModuleServiceImpl implements ModuleService {
    final static Logger Log = LoggerFactory.getLogger(ModuleServiceImpl.class);

    @Autowired
    ModuleDao moduleDao;
    TaskEntity taskDao;

    @Override
    public void completeTask() {
    }

    @Override
    public void createTask(Task task) {
        TaskEntity taskEntity = new TaskEntity();
        BeanUtils.copyProperties(task, taskEntity);
        ModuleEntity moduleEntity = new ModuleEntity();
    }

    @Override
    public List<Task> getTasks(Long module_id) {
        List<TaskEntity> taskEntity = moduleDao.findTasksByModuleId(module_id);
        List<Task> taskList = new ArrayList();
        for (TaskEntity source: taskEntity ) {
            Task target = new Task();
            BeanUtils.copyProperties(source , target);
            taskList.add(target);
         }
        return null;
    }

    @Override
    public void addTaskToModule(Long task_id) {
        Task task = new Task();
        TaskEntity taskEntity = new TaskEntity();
        
    }

    @Override
    public void addQuizToModule(Long quiz_id) {
        ModuleEntity moduleEntity = new ModuleEntity();
        
    }


}
