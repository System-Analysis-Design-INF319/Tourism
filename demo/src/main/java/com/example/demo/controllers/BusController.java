package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("busses")
    public ModelAndView getAllBusses() {
        ModelAndView mav = new ModelAndView("/admin/transportationdetails.html");
        mav.addObject("busses", busRepository.findAll());
        return mav;
    }
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
    
      @GetMapping("/editBus/{id}")
    public ModelAndView editBusForm(@PathVariable int id) {
        Bus bus = busRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid bus Id:" + id));
        ModelAndView mav = new ModelAndView("admin/editbusbooking.html");
        mav.addObject("bus", bus);
        return mav;
    }

    @PostMapping("/editBus")
    public ModelAndView editBus(@ModelAttribute Bus bus) {
    busRepository.save(bus);
    return new ModelAndView("redirect:/Transportation/busses");
    }

    @GetMapping("deleteBus/{id}")
    public ModelAndView deleteBus(@PathVariable("id") int id) {
        busRepository.deleteById(id);
        return new ModelAndView("redirect:/Transportation/busses"); 
    }
    






}
