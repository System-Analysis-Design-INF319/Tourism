package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.HiddenGem;

import com.example.demo.repositories.HiddenGemRepository;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@RestController
public class HiddenGemController {

    @Autowired
    private HiddenGemRepository hiddenGemRepository;

    @GetMapping("search")
    public List<HiddenGem> searchHiddenGem(@RequestParam String term) {
        return hiddenGemRepository.findByNameStartingWithIgnoreCase(term);
    }

    @GetMapping("hiddenGems")
    public ModelAndView getAllhiddenGems(HttpSession session) {
        ModelAndView mav = new ModelAndView("/tourist/hiddenGems.html");
        mav.addObject("username", (String) session.getAttribute("username"));
        mav.addObject ("usertype", (String) session.getAttribute("usertype"));
        List<HiddenGem> hiddenGems = this.hiddenGemRepository.findAll();
        mav.addObject("hiddenGems", hiddenGems);
        return mav;
    }
}