package com.myPersonalChatProject.chatProject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {


    @GetMapping("/signup")
    public String signUpPage() {
        return "signup";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }



}

