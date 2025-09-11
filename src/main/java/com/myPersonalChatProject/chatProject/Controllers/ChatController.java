package com.myPersonalChatProject.chatProject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/neha")
    public String getAlert(){

        return "chat";
    }



}

