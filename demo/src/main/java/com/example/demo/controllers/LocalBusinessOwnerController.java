package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.HiddenGem;
import com.example.demo.repositories.HiddenGemRepository;

@RestController
@RequestMapping("/LocalBusinessOwner")
public class LocalBusinessOwnerController {
    
    @Autowired
    private HiddenGemRepository hiddenGemRepository;

    @GetMapping("addHiddenGem")
    public ModelAndView addHiddenGems() {
        ModelAndView mav = new ModelAndView("/localBusinessOwner/addHiddenGem.html");
        HiddenGem newHiddenGem = new HiddenGem();
        mav.addObject("hiddenGem", newHiddenGem);
        return mav;
    }

    @PostMapping("addHiddenGem")
    public ModelAndView saveHiddenGem(@ModelAttribute HiddenGem hiddenGem) {
        this.hiddenGemRepository.save(hiddenGem);
        return new ModelAndView("redirect:/LocalBusinessOwner/addHiddenGem");
    }

    @GetMapping("hiddenGemInfo")
    public ModelAndView getHiddenGemInfo() {         
        ModelAndView mav = new ModelAndView("/localBusinessOwner/hiddenGemInfo.html");
        List<HiddenGem> hiddenGems = this.hiddenGemRepository.findAll();
        mav.addObject("hiddenGems", hiddenGems);
        return mav;
    }

}
