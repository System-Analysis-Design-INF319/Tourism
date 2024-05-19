package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Bus;
import com.example.demo.repositories.BusRepository;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/Transportation")

public class BusController {
    @Autowired
    BusRepository busRepository;

    @GetMapping("addBus")
    public ModelAndView addBus(){
        ModelAndView mav = new ModelAndView("/admin/addTransportation.html");
        Bus newBus= new Bus();
        newBus.setFull(0);
        mav.addObject("bus", newBus);
        return mav; 
       
    }
    @PostMapping("addBus")
    public ModelAndView saveBusses(@ModelAttribute Bus bus) {
        this.busRepository.save(bus);
        return new ModelAndView("redirect:/Transportation/addBus");
    }
    

}
