package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.HiddenGem;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @GetMapping("user/book-hiddengem")
    public ModelAndView BookHiddenGem(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("/tourist/hiddengemBooking.html");
        HiddenGem hiddenGem = new HiddenGem();
        mav.addObject("hiddenGem", hiddenGem);
        return mav;
    }
    
}
