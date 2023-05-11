package com.example.chineseyear.controllers;

import com.example.chineseyear.entities.Sign;
import com.example.chineseyear.repositories.SignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SignController {

    @Autowired
    SignRepository signRepository;

    @GetMapping("/signs")
    public String getAllSigns(Model model, @Param("keyword") String keyword) {
        try {
            List<Sign> signs = new ArrayList<Sign>();
            if (keyword == null) {
                signRepository.findAll().forEach(signs::add);
            } else {
                signRepository.findByNameContaining(keyword).forEach(signs::add);
                model.addAttribute("keyword", keyword);
            }
            model.addAttribute("signs", signs);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "signs";
    }

    @GetMapping("/signs/new")
    public String addSign(Model model) {
        Sign sign = new Sign();
        model.addAttribute("sign", sign);
        model.addAttribute("pageTitle", "Add Sign");
        return "sign_form";
    }

    @PostMapping("/signs/save")
    public String saveSign(Sign sign, RedirectAttributes redirectAttributes) {
        try {
            signRepository.save(sign);

            redirectAttributes.addFlashAttribute("message", "Sign has been saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }
        return "redirect:/signs";
    }





}
