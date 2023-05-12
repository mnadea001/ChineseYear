package com.example.chineseyear.controllers;

import com.example.chineseyear.entities.Sign;
import com.example.chineseyear.repositories.SignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SignController {

    @Autowired
    SignRepository signRepository;



//    public void defineSignYearDate() {
//        List<Sign> sign = repository.findByLastname("Matthews");
//    }

//    @RequestMapping(value = "/students/{id}")
//    public Optional<Student> getStudent(@PathVariable String id) {
//        return studentService.getStudent(id);
//    }

//@RequestMapping(value = "/locations/name/{name}")
//public List<Location> getLocationByName(@PathVariable String name) {
//    return locationService.getLocationsByName(name);
//}

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


    @GetMapping("/signs/delete/{id}")
    public String deleteSign(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            signRepository.deleteById(id);

            redirectAttributes.addFlashAttribute("message", "The Sign with id=" + id + " has been deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/signs";
    }


}
