package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.HistoricalPlace;
import com.example.demo.repositories.HistoricalPlaceRepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private HistoricalPlaceRepository historicalPlaceRepository;

    @GetMapping("")
    public ModelAndView Index() {         
        return new ModelAndView("/tourist/index.html");
    }
    
    @GetMapping("historicalPlaces")
    public ModelAndView getAllHistoricalPlaces(HttpSession session) {
        ModelAndView mav = new ModelAndView("/tourist/historicalPlaces.html");
        List<HistoricalPlace> historicalPlaces = this.historicalPlaceRepository.findAll();
        mav.addObject("historicalPlaces", historicalPlaces);
        return mav;
    }
}
