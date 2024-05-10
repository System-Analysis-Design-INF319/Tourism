package com.example.demo.controllers;

import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.HiddenGem;
import com.example.demo.repositories.HiddenGemRepository;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    HiddenGemRepository hiddenGemRepository;

    @GetMapping("user/book-hiddengem")
    public ModelAndView BookHiddenGem(@RequestParam int id) {
        HiddenGem hiddenGem = hiddenGemRepository.findById(id).get();
        System.out.println(id);
        ModelAndView mav = new ModelAndView("/tourist/hiddengemBooking.html");
        ArrayList<String> days = hiddenGem.getDays(hiddenGem.getStartDay(), hiddenGem.getEndDay());

        ArrayList<String> hours = hiddenGem.getTime(hiddenGem.getStartWorkingTime(), hiddenGem.getEndWorkingTime());
        mav.addObject("days", days);
        mav.addObject("hours", hours);
        return mav;
    }

}
