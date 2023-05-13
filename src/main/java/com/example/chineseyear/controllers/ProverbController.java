package com.example.chineseyear.controllers;

import com.example.chineseyear.entities.Proverb;
import com.example.chineseyear.entities.User;
import com.example.chineseyear.repositories.ProverbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
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

    @GetMapping("/proverbs")
    public String getAllProverbs(Model model) {

        List<Proverb> proverbs = new ArrayList<Proverb>();

        proverbRepository.findAll().forEach(proverbs::add);

        model.addAttribute("proverbs", proverbs);

        return "proverbs";
    }

    @GetMapping("/")
    public String getHome(Model model) {
        Proverb randomProverb = proverbRepository.findRandomProverb();
        model.addAttribute("proverb", randomProverb);
        return "index";
    }
}
