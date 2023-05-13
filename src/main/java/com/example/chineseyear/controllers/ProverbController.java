package com.example.chineseyear.controllers;

import com.example.chineseyear.entities.Proverb;
import com.example.chineseyear.repositories.ProverbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class ProverbController {
    @Autowired
    private ProverbRepository proverbRepository;


    @GetMapping("/proverbs/random")
    public String getRandomProverb(Model model) {
        List<Proverb> allProverbs = proverbRepository.findAll();
        int randomIndex = new Random().nextInt(allProverbs.size());
        Proverb randomProverb = allProverbs.get(randomIndex);
        model.addAttribute("proverb", randomProverb);
        return "randomProverb";
    }
}
