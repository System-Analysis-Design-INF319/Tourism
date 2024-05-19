package com.example.demo.controllers;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Bus;
import com.example.demo.models.BusBooking;
import com.example.demo.models.HiddenGem;
import com.example.demo.models.HiddenGemBooking;
import com.example.demo.models.user;
import com.example.demo.repositories.HiddenGemRepository;
import com.example.demo.repositories.BusBookingRepository;
import com.example.demo.repositories.BusRepository;
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
  @Autowired
  BusRepository busRepository;
  @Autowired
  BusBookingRepository busBookingRepository;

  @GetMapping("user/book-hiddengem")
  public ModelAndView BookHiddenGem(@RequestParam int id, HttpSession session) {
    HiddenGem hiddenGem = hiddenGemRepository.findById(id);
    ModelAndView mav = new ModelAndView("/tourist/hiddengemBooking.html");
    ArrayList<String> days = hiddenGem.getDays(hiddenGem.getStartDay(), hiddenGem.getEndDay());
    ArrayList<String> hours = hiddenGem.getTime(hiddenGem.getStartWorkingTime(), hiddenGem.getEndWorkingTime());
    mav.addObject("days", days);
    mav.addObject("hours", hours);
    mav.addObject("hiddenGemId", hiddenGem.getId());
    return mav;
  }

  @PostMapping("booked")
  public void book(@RequestParam int id, @ModelAttribute HiddenGemBooking booking, HttpServletResponse response,
      HttpSession session) throws IOException {
    HiddenGem hiddenGem = hiddenGemRepository.findById(id);
    Long userId = (Long) session.getAttribute("user_id");

    if (userId != null) {
      HiddenGemBooking hiddenGemBooking = new HiddenGemBooking();
      user user = new user();
      user.setId(userId);
      hiddenGemBooking.setDay(booking.getDay());
      hiddenGemBooking.setTime(booking.getTime());
      hiddenGemBooking.setPeopleNum(booking.getPeopleNum());
      hiddenGemBooking.setHiddenGem(hiddenGem);
      hiddenGemBooking.setUsers(user);
      this.hiddenGemBookingRepository.save(hiddenGemBooking);
      response.sendRedirect("user/my-bookings"); // change it to pay deposit
    } else {
      response.sendRedirect("/User/login");
    }
  }

  @GetMapping("user/my-bookings")
  public ModelAndView viewBookings(HttpSession session, HttpServletResponse response) throws IOException {
    ModelAndView mav = new ModelAndView("/tourist/viewBookings.html");
    Long userId = (Long) session.getAttribute("user_id");
    if (userId != null) {
      Boolean exists = hiddenGemBookingRepository.existsByUserId(userId);
      if (exists) {
        List<HiddenGemBooking> booking = this.hiddenGemBookingRepository.findByUserId(userId);
        mav.addObject("bookings", booking);
      } else {
        mav.addObject("bookings", null);
        mav.addObject("message", "You don't have any bookings");
      }
    } else {
      response.sendRedirect("/User/login");
    }
    return mav;
  }

  @GetMapping("cancelled")
  public void cancelBooking(@RequestParam int id, HttpServletResponse response) throws IOException {
    HiddenGemBooking hiddenGemBooking = hiddenGemBookingRepository.findById(id).get();
    this.hiddenGemBookingRepository.delete(hiddenGemBooking);
    response.sendRedirect("user/my-bookings");
  }

  @GetMapping("LocalBusinessOwner/bookings")
  public ModelAndView viewLocalBusinessOwnerBookings(HttpSession session, HttpServletResponse response)
      throws IOException {
    ModelAndView mav = new ModelAndView("/localBusinessOwner/bookings.html");
    return mav;
  }

  @GetMapping("admin/HiddenGemBookings")
  public ModelAndView viewAdminBookings(HttpServletResponse response) throws IOException {
    ModelAndView mav = new ModelAndView("/admin/bookings.html");
    List<HiddenGemBooking> booking = this.hiddenGemBookingRepository.findAll();
    System.out.println(booking);
    mav.addObject("bookings", booking);
    return mav;
  }

  @GetMapping("bus")
  public ModelAndView bookBus() {
    ModelAndView mav = new ModelAndView("/tourist/busBooking.html");
    List<Bus> busses = busRepository.findAll();
    mav.addObject("busses", busses);
    return mav;
  }

  @GetMapping("busbooked")
  public void busBooked(@RequestParam int id, HttpServletResponse response, HttpSession session) throws IOException {
    String message = null;
    Bus bus = busRepository.findById(id).get();
    BusBooking booking = new BusBooking();
    Long userId = (Long) session.getAttribute("user_id");
    Boolean exists = busBookingRepository.existsByUserId(userId);
    int capacity = bus.getCapacity();
    int numberOfBookings = busBookingRepository.countByBusId(bus.getId());

    if (exists) {
      message = "Can't Book Another Trip!, You already have a booked one.";
      response.sendRedirect("/booking/bus");
    }

    else {
      if (userId != null) {
        user user = new user();
        user.setId(userId);
        booking.setUser(user);
        booking.setBus(bus);
        booking.setSource(bus.getSource());
        booking.setDestination(bus.getDestination());
        booking.setTime(bus.getTime());
        booking.setPrice(bus.getPrice());
        busBookingRepository.save(booking);
        if (numberOfBookings == capacity) {
          busRepository.delete(bus);
        }
        message = "Your booking has been successfully saved";
        response.sendRedirect("/booking/bus");
      } else {
        response.sendRedirect("/User/login");
      }
    }
  }
}