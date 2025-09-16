package com.myPersonalChatProject.chatProject.Controllers;

import com.myPersonalChatProject.chatProject.Model.User;
import com.myPersonalChatProject.chatProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signUpPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
    @GetMapping("/login")
    public String loginPage() {
        System.out.println("entring the login form------------------------->");
        // here we have to capture the details sent by the user

        // verify the user details

        // then send the user details as well like contacts and chats and everything
        return "login";
    }

    @PostMapping("/processLogin")
    public String submitLogin(@RequestParam("emailAddress") String emailAddress, @RequestParam("password") String password , Model model) {
        System.out.println("username is =======>"+ emailAddress);
        System.out.println("password is =======>"+ password);
        Boolean isValid = userService.authenticateUser(emailAddress,password);
        if (isValid) {
            model.addAttribute("success", "Login successful! Welcome " + emailAddress);
            return "chat";
        }else{
            model.addAttribute("error", "Invalid email or password");
            return "redirect:/login";
        }

    }

    @PostMapping("/submitSignUp")
    public String processSignUpForm(@ModelAttribute("user") User  user) {
        System.out.println("the user object is " + user.getFirstName());
        // capture the user object

        // save the user while saving  the user we also have to encrypt the password
        userService.createUser(user);
        // once we have saved the user then we redirect him to the login action

        return  "redirect:/login";
    }




}

