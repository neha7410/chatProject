package com.myPersonalChatProject.chatProject.Controllers;

import com.myPersonalChatProject.chatProject.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {


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
    public String submitLogin(@RequestParam("emailAddress") String emailAddress, @RequestParam("password") String password) {
        System.out.println("username is =======>"+ emailAddress);
        System.out.println("username is =======>"+ password);
        return "chat";
    }

    @PostMapping("/submitSignUp")
    public String processSignUpForm(@ModelAttribute("user") User  user) {
        System.out.println("the user object is " + user.getFirstName());
        // capture the user object

        // save the user while saving  the user we also have to encrypt the password

        // once we have saved the user then we redirect him to the login action

        return  "login";
    }




}

