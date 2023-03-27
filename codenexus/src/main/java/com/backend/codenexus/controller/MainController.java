package com.backend.codenexus.controller;

import com.backend.codenexus.entity.MessagesEntity;
import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.entity.UserEntity;
import com.backend.codenexus.service.CourseService;
import com.backend.codenexus.service.MessagesService;
import com.backend.codenexus.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

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
    @Autowired
    private JavaMailSender mailSender;


    //Get Mapping methods xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    @ModelAttribute("user")
    public UserEntity getUserUserEntity() {
        return new UserEntity();
    }
    @GetMapping("index")
    public String index(ModelMap modelMap) {
        UserEntity user = (UserEntity) modelMap.get("user");
        if(user.getId() == null){
            return "index";
        }
        else {
            return "redirect:/dashboard";
        }
    }
    @GetMapping("dashboard")
        public String getDashboard( ModelMap modelMap) {
        if(modelMap.containsAttribute("user")){
            UserEntity user = (UserEntity) modelMap.get("user");
            if (user.getUserTypeId() == 3) {
                return "adminDashboard";
            }
            else if (user.getUserTypeId() == 2) {
                return "redirect:/students";
            }
            else if (user.getUserTypeId() == 1) {
                 return "redirect:/get-userCourses/" + user.getId();
        }
        }
        return "redirect:/index";


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
        return "contactus";
    }

    @PostMapping("contact")
    public String submitContact(HttpServletRequest request){
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("abc@gmail.com");
        message.setTo("nexuscontactusmiami@gmail.com");

        String mailSubject = fullname + " has sent a message";
        String mailContent = "Sender Name:" + fullname + "\n";
        mailContent += "Sender E-mail: " + email + "\n";
        mailContent += "Subject: " + subject + "\n";
        mailContent += "Content: " + content + "\n";

        message.setSubject(mailSubject);
        message.setText(mailContent);

        mailSender.send(message);

        return "message";
    }
    @GetMapping("login")
    public String loginProcess(){
        return "login";
    }

    @GetMapping (value = "logout")
    public String logout(ModelMap modelMap, SessionStatus status){
        modelMap.clear();
        status.setComplete();
        modelMap.put("logoutMessage", "Logout successful!!");
        return "redirect:/index";
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
        //modelMap.addAttribute("courseModules", courseService.getCourseModules(id));

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
        if(((UserEntity) modelMap.get("user")).getId() != null){
            return "redirect:/inbox/" + ((UserEntity) modelMap.get("user")).getId();
        }
        else{
            return "redirect:/index";
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
    @GetMapping("userProfile/{user_id}")
    public String userProfile(@PathVariable Long user_id, ModelMap modelMap) {
        userService.updateUser((UserEntity) modelMap.get("user"));
        return "userProfile";
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
    public String saveMessages(@ModelAttribute("messageForm" ) MessagesEntity message, ModelMap modelMap) {
        message.setSender((UserEntity) modelMap.get("user"));
        messagesService.saveMessage(message);
        return "redirect:/inbox/" + ((UserEntity) modelMap.get("user")).getId() ;
    }

    @PostMapping(value = "changePassword")
    public String changePassword(ModelMap modelMap, String oldPassword, String newPassword){
        if(userService.changePassword((UserEntity) modelMap.get("user"), oldPassword, newPassword) == true) {
            modelMap.put("successfulChange", "password successfully updated");
        }
        else{
            modelMap.put("unsuccessfulChange", "password not updated please try again");
        }
        return "redirect:/userProfile" + ((UserEntity) modelMap.getAttribute("user")).getId();
    }
}