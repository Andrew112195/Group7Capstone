package com.backend.codenexus.service;

import java.util.List;
import java.util.ArrayList;

import com.backend.codenexus.model.*;

public interface MessagesService {

    List <Messages> getMessages(Long user_id);

    void saveMessage(Messages message);
    
}
