package com.backend.codenexus.controller;


import com.backend.codenexus.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.backend.codenexus.service.MessagesService;

import java.util.List;


@Controller
@RequestMapping("home")
public class HomeController {

    @GetMapping("aboutus")
    public String getAboutus(){

        return "aboutUs";
    }

    @GetMapping("pricing")
    public String getPricing(){

        return "pricing";
    }
}