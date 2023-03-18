package com.backend.codenexus.controller;

import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.backend.codenexus.entity.*;
import com.backend.codenexus.service.*;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
@CrossOrigin
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;
    @Autowired
    MessagesService messagesService;

    //Get Mapping methods xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    @ModelAttribute("user")
    public UserEntity getUserUserEntity() {
        return new UserEntity();

    }
    @GetMapping("index")
    public String index(ModelMap modelMap) {
        if(modelMap.containsKey("user")){
            return "redirect:/dashboard";
        }
        return "index";
    }
    @GetMapping("dashboard")
        public String getDashboard( ModelMap modelMap) {
        UserEntity user = (UserEntity) modelMap.get("user");
        if (user.getUserTypeId() == 3) {
            return "adminDashboard";
        } else if (user.getUserTypeId() == 2) {
            return "redirect:/students";
        } else if (user.getUserTypeId() == 1) {
            return "redirect:/get-userCourses/" + user.getId();
        }
        else{
            return "redirect:/index";
        }
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

    @GetMapping("get-userCourses/{id}")
    public String getUserCourse(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("userCourses", courseService.getCourse(id));

        return "studentDashboard";
    }

    @GetMapping("get-courseModules/{id}")
    public String getCourseModules(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("courseModules", courseService.getCourseModules(id));

        return "studentModules";
    }

    @GetMapping("get-moduleTasks/{id}")
    public String getModuleTasks(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("moduleTasks", courseService.findAllTasksByModuleId(id));

        return "studentDashboard";
    }

    @GetMapping("ide")
    public String ideLoader(){
        return "onlineIDE";
    }

    @GetMapping("sent/{user_id}")
    public String getSentMessages(@PathVariable Long user_id) {
        List<MessagesEntity> messagesSent = messagesService.getSentMessages(user_id);
        return null;
    }

    @GetMapping("inbox")
    public String inbox(ModelMap modelMap){
        if(modelMap.containsKey("user")){
            return "redirect:/inbox/" + ((UserEntity) modelMap.get("user")).getId();
        }
        else{
            return "login";
        }
    }

    @Transactional
    @GetMapping("inbox/{user_id}")
    public String getMessages(@PathVariable Long user_id, ModelMap modelMap) {
        userService.updateUser((UserEntity) modelMap.get("user"));
        modelMap.addAttribute("userMessage", modelMap.get("user"));
        MessagesEntity messageForm = new MessagesEntity();
        modelMap.addAttribute("messageForm",messageForm);
        modelMap.addAttribute("peerList", courseService.getAllClassmates(user_id));
        return "inbox";
    }

    @GetMapping("read_message/{message_id}")
    public String readMessage(@PathVariable Long message_id){
        messagesService.readMessage(message_id);
        return null;
    }

    @GetMapping  ("getClassmates")
    public void getClassmateList(ModelMap modelMap, UserCourseEntity userCourse){
        modelMap.put("userList", courseService.getAllClassmates(userCourse.getId()));
    }
    //Post Mapping Methods xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    @PostMapping("login-process")
    public String login(ModelMap modelMap, UserEntity user) {
        user = userService.login(user);
        try {
            if(user != null) {
                modelMap.put("welcomeMessage", "Welcome " + user.getFirstname());
                userService.updateUser(user);
                modelMap.addAttribute("user", user);
                return "redirect:/dashboard";
            }

            modelMap.put("invalidLogin", "Incorrect user name or password, please try again");
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("register-process")
    public String registerProcess(ModelMap modelMap, UserEntity user){
        if(userService.register(user)) {
            modelMap.put("successfulRegistration", "Thank you for your registration!! " + user.getFirstname());
            return "login";
        }
        modelMap.put("registrationError", "User name exists already, please try again");
        return "register";
    }

    @PostMapping("addcourse/{userId}/{courseId}")
    public String addUserCourse(@PathVariable("userId")long userId,@PathVariable("courseId") long courseId) {
        courseService.addNewCourseToUser(userId,courseId);

        return "redirect:/students";
    }
    //consumes = {"application/json", "application/xml", "multipart/form-data"}

    @PostMapping(value = "saveMessage")
    public String saveMessages(@ModelAttribute("messageForm" ) MessagesEntity message,   ModelMap modelMap) {
        message.setUser(((UserEntity) modelMap.get("user")));
        messagesService.saveMessage(message);
        return "redirect:/inbox/" + ((UserEntity) modelMap.get("user")).getId() ;
    }
}