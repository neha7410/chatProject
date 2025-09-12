package com.myPersonalChatProject.chatProject.Controllers;

import com.myPersonalChatProject.chatProject.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {


    @GetMapping("/signup")
    public String signUpPage(Model model) {
        model.addAttribute("user", new User());
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP\n");
        return "signup";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/submitSignUp")
    public String processSignUpForm(@ModelAttribute("user") User  user) {
        System.out.println("the user object is " + user.getFirstName());


        return  "login";
    }




}

