package com.backend.codenexus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.backend.codenexus.model.*;
import com.backend.codenexus.service.*;

@Controller
@RequestMapping("/")
@SessionAttributes
@CrossOrigin
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;
    @Autowired
    UserCourseService userCourseService;
    @Autowired
    MessagesService messagesService;

    //Get Mapping methods

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("aboutus")
    public String getAboutus(){
        return "aboutUs";
    }

    @GetMapping("pricing")
    public String getPricing(){
        return "pricing";
    }

    @GetMapping("contact")
    public String getContact(){
        return "contact";
    }
    
    @GetMapping("login")
    public String loginProcess(){
        return "login";
    }

    @GetMapping("register")
    public String registration(){
        return "register";
    }

    @GetMapping("students")
    public String getStudents(ModelMap modelMap){
        modelMap.put("students", userService.getAllStudents());
        modelMap.put("courses", courseService.getCourseList());

        return "instructorDashboard";
    }

    @GetMapping(value="get-userCourses/{id}",produces = MediaType.ALL_VALUE)
    public String getUserCourse(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("userCourses", userCourseService.getCourse(id));

        return "studentDashboard";
    }

    @GetMapping("ide")
    public String ideLoader(){
        return "onlineIDE";
    }

    @GetMapping("sent/{user_id}")
    public String getSentMessages(@PathVariable Long user_id) {
        List<Message> messagesSent = messagesService.getSentMessages(user_id);
        return null;
    }

    @GetMapping("inbox/{user_id}")
    public String getMessages(@PathVariable Long user_id) {
        return null;
    }

    @GetMapping("inbox/read_message/{message_id}")
    public String readMessage(@PathVariable Long message_id){
        return null;
    }

    //Post Mapping Methods

    @PostMapping("login-process")
    public String login(ModelMap modelMap, User user) {
        user = userService.login(user);
        try {
            if(user != null) {
                modelMap.put("welcomeMessage", "Welcome " + user.getFirstname());
                if (user.getUserTypeId() == 3) {
                    return "adminDashboard";
                } else if (user.getUserTypeId() == 2) {
                    return "redirect:/students";
                } else if (user.getUserTypeId() == 1) {
                    return "redirect:/get-userCourses/"+user.getId();
                }
            }
            
             //redirect
            modelMap.put("invalidLogin", "Incorrect user name or password, please try again");
            return "login";
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("register-process")
    public String registerProcess(ModelMap modelMap, User user){
        if(userService.register(user)) {
            modelMap.put("successfulRegistration", "Thank you for your registration!! " + user.getFirstname());
            return "login";
        }
        modelMap.put("registrationError", "User name exists already, please try again");
        return "register";
    }

    @PostMapping("addcourse/{userId}/{courseId}")
    public String addUserCourse(@PathVariable("userId")long userId,@PathVariable("courseId") long courseId) {
        userCourseService.addNewCourseToUser(userId,courseId);

        return "redirect:/students";
    }

    @PostMapping("save")
    public String saveMessages(@RequestBody Message message) {
        messagesService.saveMessage(message);
        return "redirect:";
    }
}