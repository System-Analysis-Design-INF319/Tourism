package com.example.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Transportation;
import com.example.demo.repositories.TransportationRepository;



@RestController
@RequestMapping("/Transportation")
public class TransportationController {
     @Autowired
    private TransportationRepository transportationRepository;
    
    
    @GetMapping("addBusses")
    public ModelAndView addBusses() {
        ModelAndView mav = new ModelAndView("/admin/addTransportation.html");
        Transportation newTransportation= new Transportation();
        mav.addObject("transportation", newTransportation);
        return mav;
    }

    @PostMapping("addBusses")
    public ModelAndView saveBusses(@ModelAttribute Transportation transportation) {

        this.transportationRepository.save(transportation);
        return new ModelAndView("redirect:/Transportation/addBusses");
    }
    
}
