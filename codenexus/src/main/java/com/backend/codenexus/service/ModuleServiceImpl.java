package com.backend.codenexus.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;
import com.backend.codenexus.model.*;

import java.util.List;

public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleDao moduleDao;

    @Override
    public void completeTask() {
    }
}
