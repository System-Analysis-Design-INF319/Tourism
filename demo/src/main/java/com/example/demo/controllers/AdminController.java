package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.HistoricalPlace;
import com.example.demo.models.LocalBusinessOwner;
import com.example.demo.repositories.HistoricalPlaceRepository;
import com.example.demo.repositories.LocalBusinessOwnerRepository;
import com.example.demo.repositories.userRepository;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private LocalBusinessOwnerRepository localBusinessOwnerRepository;

    @Autowired
    private HistoricalPlaceRepository historicalPlaceRepository;

    @Autowired
    private userRepository UserRepository;


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

    @GetMapping("/editBusinessOwner/{id}")
    public ModelAndView editBusinessOwnerForm(@PathVariable int id) {
        LocalBusinessOwner businessOwner = localBusinessOwnerRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid business owner Id:" + id));
        ModelAndView mav = new ModelAndView("admin/editBusinessOwner");
        mav.addObject("businessOwner", businessOwner);
        return mav;
    }

    @PostMapping("/editBusinessOwner")
    public ModelAndView editBusinessOwner(@ModelAttribute LocalBusinessOwner businessOwner) {
    localBusinessOwnerRepository.save(businessOwner);
    return new ModelAndView("redirect:/admin/businessOwners");
    }

    @GetMapping("deleteBusinessOwner/{id}")
    public ModelAndView deleteBusinessOwner(@PathVariable("id") int id) {
        localBusinessOwnerRepository.deleteById(id);
        return new ModelAndView("redirect:/admin/businessOwners"); 
    }


    @GetMapping("addHistoricalPlace")
    public ModelAndView addHistoricalPlaces() {
        ModelAndView mav = new ModelAndView("/admin/addHistoricalPlaces.html");
        HistoricalPlace newHistoricalPlace = new HistoricalPlace();
        mav.addObject("historicalPlace", newHistoricalPlace);
        return mav;
    }
    @PostMapping("addHistoricalPlace")
    public ModelAndView saveHiddenGem(@ModelAttribute HistoricalPlace historicalPlace) {
        this.historicalPlaceRepository.save(historicalPlace);
        return new ModelAndView("redirect:/admin/addHistoricalPlace");
    }

    @GetMapping("historicalPlaceInfo")
    public ModelAndView getHistoricalPlaceInfo() {         
        ModelAndView mav = new ModelAndView("/admin/historicalPlaceInfo.html");
        List<HistoricalPlace> historicalPlaces = this.historicalPlaceRepository.findAll();
        mav.addObject("historicalPlaces", historicalPlaces);
        return mav;
    }

    @GetMapping("editHistoricalPlaceInfo/{id}")
    public ModelAndView editHistoricalPlaceInfo(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("/admin/editHistoricalPlaceInfo.html");
        HistoricalPlace historicalPlace = this.historicalPlaceRepository.findById(id); 
        mav.addObject("historicalPlace", historicalPlace);
        return mav;
    }
    @PostMapping("editHistoricalPlaceInfo/{id}")
    public ModelAndView editHistoricalPlaceInfo(@PathVariable("id") int id, @ModelAttribute HistoricalPlace updatedHistoricalPlace) {
        HistoricalPlace existingHistoricalPlace = this.historicalPlaceRepository.findById(id);
        existingHistoricalPlace.setName(updatedHistoricalPlace.getName());
        existingHistoricalPlace.setCity(updatedHistoricalPlace.getCity());
        existingHistoricalPlace.setDescription(updatedHistoricalPlace.getDescription());
        existingHistoricalPlace.setLocation(updatedHistoricalPlace.getLocation());
        existingHistoricalPlace.setImage(updatedHistoricalPlace.getImage());
        existingHistoricalPlace.setStartDay(updatedHistoricalPlace.getStartDay());
        existingHistoricalPlace.setEndDay(updatedHistoricalPlace.getEndDay());
        existingHistoricalPlace.setStartWorkingTime(updatedHistoricalPlace.getStartWorkingTime());
        existingHistoricalPlace.setEndWorkingTime(updatedHistoricalPlace.getEndWorkingTime());

        historicalPlaceRepository.save(existingHistoricalPlace); 
        return new ModelAndView("redirect:/admin/historicalPlaceInfo"); 
    }

    
    @GetMapping("/tourists")
    public ModelAndView getAllTourists() {
        ModelAndView mav = new ModelAndView("/admin/tourists.html");
        mav.addObject("tourists", UserRepository.findAll());
        return mav;
}

}