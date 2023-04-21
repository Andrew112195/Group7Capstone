package com.backend.codenexus.controller;

import com.backend.codenexus.entity.*;
import com.backend.codenexus.model.PasswordChangeRequest;
import com.backend.codenexus.model.TaskQuestionBuilder;
import com.backend.codenexus.service.CourseService;
import com.backend.codenexus.service.MessagesService;
import com.backend.codenexus.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes({"user","courses","userCart","currentTask"})
@CrossOrigin
public class MainController {

    final static Logger Log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private MessagesService messagesService;
    @Autowired
    private JavaMailSender mailSender;

    @ModelAttribute("user")
    public UserEntity getUserUserEntity() { return new UserEntity(); }

    //Get Mapping methods xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    @GetMapping("aboutus")
    public String getAboutus(){ return "aboutUs"; }

    @GetMapping("pricing")
    public String getPricing(){ return "pricing"; }

    @GetMapping("contact")
    public String getContact(){ return "contactus"; }

    @GetMapping("login")
    public String loginProcess(ModelMap modelMap) {
        UserEntity user = (UserEntity) modelMap.get("user");
        if (user.getId() == null) {
            return "login";
        } else {
            return "index";
        }
    }
    @GetMapping("register")
    public String registration(){ return "register"; }

    @GetMapping("studentclassroom")
    public String studentClassroom(){ return "studentClassroom"; }

    @GetMapping("subscriptions")
    public String subscriptions(){ return "subscriptions"; }

  /*  @GetMapping("checkout")
    public String checkout(){ return "checkout"; }*/

    @GetMapping("devtoolsPreview")
    public String devtoolsPreview(){ return "devtoolsPreview"; }

    @GetMapping("premadeLibrary")
    public String premadeLibrary(){ return "premadeLibrary"; }

    @GetMapping("tasks_Variables")
    public String tasksVariables(){ return "tasks_Variables"; }

    @GetMapping("ide")
    public String ideLoader(){ return "onlineIDE"; }

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
                return "instructorDashboard";
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

  /*  @GetMapping("catalog")
    public String getCatalog(){
        return "catalog";
    }*/

 /*   @GetMapping("catalogCourseDescription")
    public String getCatalogCourseDescription(ModelMap modelMap,CourseEntity course){
        modelMap.addAttribute("currentCourseFromCatalog", course);

        return "catalogCourseDescription";
    }*/

    @GetMapping (value = "logout")
    public String logout(ModelMap modelMap, SessionStatus status){
        modelMap.clear();
        status.setComplete();
        modelMap.put("logoutMessage", "Logout successful!!");
        return "redirect:/index";
    }


    @ModelAttribute("courses")
    public List<CourseEntity> getCourses() {
        return courseService.getCourseList();
    }


    @GetMapping("students")
    public String getStudents(ModelMap modelMap){
        modelMap.put("students", userService.getAllStudents());
        modelMap.put("courses", courseService.getCourseList());

        return "instructorDashboard";
    }

    @GetMapping("catalog")
    private String getCatalog(ModelMap modelMap, @ModelAttribute("courses") List<CourseEntity> courses) {
        Log.debug("Fetching catalog");

        try {
            modelMap.addAttribute("catalogCourses", courses);
            Log.debug("Successfully fetched catalog with {} courses", courses.size());
        } catch (Exception e) {
            Log.error("Failed to fetch catalog: {}", e.getMessage(), e);
            // Handle the exception, e.g., display an error message or return a different view
        }
        return "catalog";
    }

    @GetMapping("buyCourse/{id}")
    public String buyCourse(@PathVariable Long id, ModelMap modelMap) {

        if(modelMap.containsAttribute("user")){

            CourseEntity selectedCourse =courseService.getSingleCourse(id);

            modelMap.addAttribute("userCart", selectedCourse);
        }else{
            return "redirect:/login";
        }

        return "redirect:/checkout";
    }

    @GetMapping("checkout")
    public String getCheckout(@ModelAttribute("userCart") CourseEntity userCart, ModelMap modelMap) {

        // Here you can access the user-cart object directly
        modelMap.addAttribute("userCart", userCart);

        return "checkout";
    }


    @GetMapping("get-userCourses/{id}")
    public String getUserCourse(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("userCourses", courseService.getCourse(id));

        return "studentDashboard";
    }

    @GetMapping("get-courseModules/{id}")
    public String getCourseModules(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("courseModules", courseService.getCourseModules(id));

        return "studentClassroom";
    }

    @GetMapping("get-moduleTasks/{id}")
    public String getModuleTasks(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("moduleTasks", courseService.findAllTasksByModuleId(id));

        return "studentDashboard";
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
        updateModelmapUser(modelMap);
        MessagesEntity messageForm = new MessagesEntity();
        modelMap.addAttribute("messageForm",messageForm);
        modelMap.addAttribute("peerList", courseService.getAllClassmates(user_id));
        return "inbox";
    }

    @GetMapping("userProfile/{user_id}")
    public String userProfile(@PathVariable Long user_id, ModelMap modelMap) {
        userService.updateUser((UserEntity) modelMap.get("user"));
        modelMap.addAttribute("changePassword", new PasswordChangeRequest());

        return "userProfile";
    }

    @GetMapping("read_message/{message_id}")
    public String readMessage(@PathVariable Long message_id){
        messagesService.readMessage(message_id);

        return null;
    }

    @GetMapping("getClassmates")
    public void getClassmateList(ModelMap modelMap, UserCourseEntity userCourse){
        modelMap.put("userList", courseService.getAllClassmates(userCourse.getId()));
    }

    @GetMapping("/task/{id}")
    public String getTask(@PathVariable Long id, ModelMap model) {

        TaskEntity task = courseService.getTask(id);
        if (!task.getModule().isModuleComplete()) {
            if (!task.isComplete()) {
                TaskQuestionBuilder taskQuestionBuilder = courseService.buildTaskQuestion(task.getModule(),task);
                model.addAttribute("currentTask", taskQuestionBuilder);
            }else {
                TaskEntity nextTask = courseService.getTask(++id);
                if(nextTask != null) {
                    TaskQuestionBuilder taskQuestionBuilder = courseService.buildTaskQuestion(task.getModule(), task);
                    model.addAttribute("currentTask", taskQuestionBuilder);
                }else{
                    return "redirect:studentClassroom";
                }

            }
        } else {

            return "redirect:studentClassroom";
        }
        return "task";
    }

    @PostMapping("/taskCompleted")
    public String taskCompleted(ModelMap modelMap,@ModelAttribute TaskEntity task,@RequestParam("selectedAnswer") String selectedAnswer) {

        Long taskID = task.getId();
        // Process the completed task here
        courseService.completeTask(taskID,selectedAnswer);

        //reload next task in attribute
        task = courseService.getTask(++taskID);
        if (task!= null) {
            TaskQuestionBuilder taskQuestionBuilder = courseService.buildTaskQuestion(task.getModule(),task);
            modelMap.addAttribute("currentTask", taskQuestionBuilder);
        } else {
            return "redirect:studentClassroom";
        }

        return "task";
    }



    @GetMapping("/profile")
    public String getProfile(ModelMap modelMap){
        UserEntity user = (UserEntity) modelMap.get("user");
        UserEntity updateUser = new UserEntity();
        modelMap.put("updateUser",updateUser);
        modelMap.addAttribute("user", user);

        return "userProfile";
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

    @SuppressWarnings("null")
    @PostMapping(value = "changePassword")
    public String changePassword(ModelMap modelMap, @ModelAttribute PasswordChangeRequest passwordChangeRequest){
        String oldPassword = passwordChangeRequest.getOldPassword();
        String newPassword = passwordChangeRequest.getNewPassword();
        UserEntity user = (UserEntity) modelMap.get("user");
        if(userService.changePassword(user, oldPassword, newPassword)) {
            modelMap.put("successfulChange", "password successfully updated");
        }
        else{
            modelMap.put("unsuccessfulChange", "password not updated please try again");
        }
        //return "redirect:/userProfile" + ((UserEntity) modelMap.getAttribute("user")).getId();
        return "redirect:/profile";
    }


    @PutMapping("/profile")
    @Transactional
    public String updateProfile(@ModelAttribute("updateUser") UserEntity user,ModelMap modelMap){
        UserEntity oldProfile = (UserEntity) modelMap.get("user");
        
        user.setId(oldProfile.getId());
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        user.setEmail(user.getEmail());
        user.setPassword(oldProfile.getPassword());
        user.setUserCourse(oldProfile.getUserCourse());
        user.setSentMessages(oldProfile.getSentMessages());

        userService.updateProfile(user);
        modelMap.addAttribute("user",user);
        userService.updateUser((UserEntity) modelMap.get("user"));

        return "redirect:/profile";
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

    public void updateModelmapUser(ModelMap modelMap){
        UserEntity userToBeUpdated = userService.updateUser((UserEntity) modelMap.get("user"));
        modelMap.put("user", userToBeUpdated);
        modelMap.addAttribute("userMessage", modelMap.get("user"));
    }

    /*@PostMapping("/submit-task")
    public String submitTask(@RequestParam Long taskId, @RequestParam String answer, HttpSession session) {

    }
    */
}