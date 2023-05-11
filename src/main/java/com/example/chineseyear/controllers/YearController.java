package com.example.chineseyear.controllers;

import com.example.chineseyear.repositories.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class YearController {

    @Autowired
    YearRepository yearRepository;
}
