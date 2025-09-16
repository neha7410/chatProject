package com.myPersonalChatProject.chatProject.Service;

import com.myPersonalChatProject.chatProject.Config.SecurityConfig;
import com.myPersonalChatProject.chatProject.Model.User;
import com.myPersonalChatProject.chatProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean authenticateUser(String email, String userEnteredPassword){
        Optional<User> users = userRepository.findByEmail(email);
        if (users.isEmpty()) {
            return false;
        }
    return users.stream().anyMatch(user->passwordEncoder.matches(userEnteredPassword,user.getPassword()));

    }
}
