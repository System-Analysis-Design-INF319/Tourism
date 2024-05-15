package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.LocalBusinessOwner;
import com.example.demo.repositories.LocalBusinessOwnerRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private LocalBusinessOwnerRepository localBusinessOwnerRepository;

    @GetMapping("businessOwners")
    public ModelAndView getAllBusinessOwners() {
        ModelAndView mav = new ModelAndView("/admin/LocalBusinessOwners.html");
        mav.addObject("businessOwners", localBusinessOwnerRepository.findAll());
        return mav;
    }

    @GetMapping("/addBusinessOwner")
    public ModelAndView addBusinessOwnerForm() {
        ModelAndView mav = new ModelAndView("admin/addBusinessOwner"); 
        mav.addObject("businessOwner", new LocalBusinessOwner());
        return mav;
    }

    @PostMapping("/addBusinessOwner")
    public ModelAndView addBusinessOwner(@ModelAttribute LocalBusinessOwner businessOwner) {
        localBusinessOwnerRepository.save(businessOwner);
        return new ModelAndView("redirect:/admin/businessOwners"); 
    }

}