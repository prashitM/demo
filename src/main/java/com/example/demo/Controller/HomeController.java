package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Entity.User;

@Controller
public class HomeController {
    
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/signup")
    public String showSignUpForm(User user) {
        return "adduser";
    }


    @PostMapping("/adduser")
    public String addUser(@Validated User user,Model model) {
         
        
        this.userRepository.save(user);// it is used to store the data into database
        showUserList(model);
        return "index";
    }

    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

}
