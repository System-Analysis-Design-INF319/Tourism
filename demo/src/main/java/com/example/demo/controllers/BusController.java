package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repositories.BusRepository;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("Transportation")

public class BusController {
    @Autowired
    BusRepository busRepository;

    @GetMapping("/addBus")
    public ModelAndView addBus(){
        ModelAndView mav= new ModelAndView("/admin/addTransportation.html");
        return mav;

    }
}
