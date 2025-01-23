/*package com.project.datingRecommendation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.project.datingRecommendation.dto.UserDto;
import com.project.datingRecommendation.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute UserDto userDto, Model model) {
        boolean saved = userService.validateAndSave(userDto);
        if (saved) {
            model.addAttribute("msg", "User registered successfully!");
        } else {
            model.addAttribute("error", "Error registering user. Try again.");
        }
        return "register";
    }

    @PostMapping("/recommendations")
    public String getRecommendations(@RequestParam Long userId, @RequestParam int limit, Model model) {
        List<UserDto> recommendations = userService.getRecommendations(userId, limit);
        model.addAttribute("recommendations", recommendations);
        return "recommendations";
    }
}*/





package com.project.datingRecommendation.controller;

import com.project.datingRecommendation.dto.UserDto;
import com.project.datingRecommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDto", new UserDto("", "", 0, ""));
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute UserDto userDto, Model model) {
        boolean saved = userService.validateAndSave(userDto);
        if (saved) {
            return "redirect:/recommendations?userId=" + userDto.getId() + "&limit=5";
        } else {
            model.addAttribute("error", "Error registering user. Please try again.");
            return "register";
        }
    }

    @GetMapping("/recommendations")
    public String getRecommendations(@RequestParam Long userId, @RequestParam int limit, Model model) {
        List<UserDto> recommendations = userService.getRecommendations(userId, limit);
        model.addAttribute("recommendations", recommendations);
        return "recommendations";
    }
}
