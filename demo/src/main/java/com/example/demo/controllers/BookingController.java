package com.example.demo.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.HiddenGem;
import com.example.demo.models.HiddenGemBooking;
import com.example.demo.repositories.HiddenGemRepository;
import com.example.demo.repositories.HiddenGemBookingRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    HiddenGemRepository hiddenGemRepository;
    @Autowired
    HiddenGemBookingRepository hiddenGemBookingRepository;

    @GetMapping("user/book-hiddengem")
    public ModelAndView BookHiddenGem(@RequestParam int id) {
        HiddenGem hiddenGem = hiddenGemRepository.findById(id).get();
        ModelAndView mav = new ModelAndView("/tourist/hiddengemBooking.html");
        ArrayList<String> days = hiddenGem.getDays(hiddenGem.getStartDay(), hiddenGem.getEndDay());
        ArrayList<String> hours = hiddenGem.getTime(hiddenGem.getStartWorkingTime(), hiddenGem.getEndWorkingTime());
        mav.addObject("days", days);
        mav.addObject("hours", hours);
        mav.addObject("hiddenGemId", hiddenGem.getId());
        return mav;
    }

    @PostMapping("booked")
    public void book (@RequestParam int id, @ModelAttribute HiddenGemBooking booking, HttpServletResponse response, HttpSession session) throws IOException {
        HiddenGem hiddenGem = hiddenGemRepository.findById(id).get();
        HiddenGemBooking hiddenGemBooking = new HiddenGemBooking();
        hiddenGemBooking.setDay(booking.getDay());
        hiddenGemBooking.setTime(booking.getTime());
        hiddenGemBooking.setPeopleNum(booking.getPeopleNum());
        hiddenGemBooking.setHiddenGem(hiddenGem);
        //int userId = (int) session.getAttribute("user_id");

        //Boolean exists = hiddenGemRepository.existsByUserId(userId);

        //if (exists) {
          //  this.message = "Can't Book Another Appointment!, You already have a booked appointment.";
            //response.sendRedirect("/user/booking/my-bookings");
        //}

        //else {
          //  if (userId != null) {
            //    User user = new User();
              //  user.setId(userId);
                //booking.setUser(user);
                this.hiddenGemBookingRepository.save(hiddenGemBooking);
                //this.message = "Your booking has been successfully saved";
                response.sendRedirect("/booking/user/book-hiddengem");
            //} else {
            //    response.sendRedirect("/user/Login");
            //}
       // }
    }
}
