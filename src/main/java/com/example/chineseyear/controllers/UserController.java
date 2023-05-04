package com.example.chineseyear.controllers;

import com.example.chineseyear.entities.User;
import com.example.chineseyear.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/users")
    public String getAllUsers(Model model, @Param("keyword") String keyword) {
        try {
            List<User> users = new ArrayList<User>();
            if (keyword == null) {
            userRepository.findAll().forEach(users::add);
            } else {
                userRepository.findByNameContaining(keyword).forEach(users::add);
                model.addAttribute("keyword", keyword);
            }
            model.addAttribute("users", users);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "users";
    }

    @GetMapping("/users/new")
    public String addUser(Model model) {
        User user = new User();
//        user.setSign(sign);

        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Create new User");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {
        try {
            userRepository.save(user);

            redirectAttributes.addFlashAttribute("message", "The account has been saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String editUser(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            User user = userRepository.findById(id).get();

            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit Tutorial (ID: " + id + ")");

            return "tutorial_form";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());}

            return "user_form";
    }
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            userRepository.deleteById(id);

            redirectAttributes.addFlashAttribute("message", "The User with id=" + id + " has been deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
    }



//    @GetMapping("/users/{id}/{status}")
//    public String calculateChineseSign(@PathVariable("id") Integer id, @PathVariable("sign") string sign,
//                                                Model model, RedirectAttributes redirectAttributes) {
//
//    try {
//      tutorialRepository.updateChineseSign(id, sign);
//
//      String status = sign ? "Lapin" : "Tiger";
//      String message = "You are id=" + id + " is " + sign;
//
//      redirectAttributes.addFlashAttribute("message", message);
//    } catch (Exception e) {
//      redirectAttributes.addFlashAttribute("message", e.getMessage());
//    }
//        return "redirect:/users";
//    }

}
