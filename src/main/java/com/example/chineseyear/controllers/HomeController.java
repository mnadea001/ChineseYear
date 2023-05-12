package com.example.chineseyear.controllers;


import org.springframework.web.bind.annotation.GetMapping;



public class HomeController {

    @GetMapping("/")
    public String home() {
//    String zodiac = ChineseZodiac.getChineseZodiac(year);
//System.out.println("Le signe chinois de " + year + " est " + zodiac);
        return "index";
    }
}
