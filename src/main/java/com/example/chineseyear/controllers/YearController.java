package com.example.chineseyear.controllers;

import com.example.chineseyear.entities.Sign;
import com.example.chineseyear.entities.Year;
import com.example.chineseyear.repositories.YearRepository;
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
public class YearController {

    @Autowired
    YearRepository yearRepository;


    @GetMapping("/years")
    public String getAllYears(Model model, @Param("keyword") Integer keyword) {
        try {
            List<Year> years = new ArrayList<Year>();
            if (keyword == null) {
                yearRepository.findAll().forEach(years::add);
            } else {
                yearRepository.findByYearDateContaining(keyword).forEach(years::add);
                model.addAttribute("keyword", keyword);
            }
            model.addAttribute("years", years);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "years";
    }

    @GetMapping("/years/new")
    public String addYear(Model model) {
        Year year = new Year();
        model.addAttribute("year", year);
        model.addAttribute("pageTitle", "Add Year");
        return "year_form";
    }

    @PostMapping("/years/save")
    public String saveYear(Year year, RedirectAttributes redirectAttributes) {
        try {
            yearRepository.save(year);

            redirectAttributes.addFlashAttribute("message", "Year has been saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }
        return "redirect:/years";
    }
}
