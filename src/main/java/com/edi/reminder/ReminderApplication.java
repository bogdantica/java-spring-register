package com.edi.reminder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
@Controller
public class ReminderApplication {

    @Autowired
    private UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(ReminderApplication.class, args);
    }


    @GetMapping("/auth/register")
    public String showRegisterPage() {
        return "auth/register";
    }

    @PostMapping("/auth/register")
    public String register(User user) {
        userRepo.save(user);
        userRepo.flush();
        return "redirect:/auth/login";
    }

}
