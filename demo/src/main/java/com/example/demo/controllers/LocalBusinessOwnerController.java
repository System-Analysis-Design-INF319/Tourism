package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.HiddenGem;
import com.example.demo.models.LocalBusinessOwner;
import com.example.demo.repositories.HiddenGemRepository;
import com.example.demo.repositories.LocalBusinessOwnerRepository;

@Controller
@RequestMapping("/LocalBusinessOwner")
public class LocalBusinessOwnerController {

    @Autowired
    private LocalBusinessOwnerRepository localBusinessOwnerRepository;
    
    @Autowired
    private HiddenGemRepository hiddenGemRepository;

    @GetMapping("addHiddenGem")
    public ModelAndView addHiddenGems() {
        ModelAndView mav = new ModelAndView("/localBusinessOwner/addHiddenGem.html");
        HiddenGem newHiddenGem = new HiddenGem();
        mav.addObject("hiddenGem", newHiddenGem);
        return mav;
    }
    @PostMapping("addHiddenGem")
    public ModelAndView saveHiddenGem(@ModelAttribute HiddenGem hiddenGem) {
        this.hiddenGemRepository.save(hiddenGem);
        return new ModelAndView("redirect:/LocalBusinessOwner/addHiddenGem");
    }

    @GetMapping("hiddenGemInfo")
    public ModelAndView getHiddenGemInfo() {         
        ModelAndView mav = new ModelAndView("/localBusinessOwner/hiddenGemInfo.html");
        List<HiddenGem> hiddenGems = this.hiddenGemRepository.findAll();
        mav.addObject("hiddenGems", hiddenGems);
        return mav;
    }

    @GetMapping("editHiddenGemInfo/{id}")
    public ModelAndView editHiddenGem(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("/localBusinessOwner/editHiddenGemInfo.html");
        HiddenGem hiddenGem = this.hiddenGemRepository.findById(id); 
        mav.addObject("hiddenGem", hiddenGem);
        return mav;
    }
    @PostMapping("editHiddenGemInfo/{id}")
    public ModelAndView editHiddenGemInfo(@PathVariable("id") int id, @ModelAttribute HiddenGem updatedHiddenGem) {
        HiddenGem existingHiddenGem = this.hiddenGemRepository.findById(id);
        existingHiddenGem.setName(updatedHiddenGem.getName());
        existingHiddenGem.setCity(updatedHiddenGem.getCity());
        existingHiddenGem.setDescription(updatedHiddenGem.getDescription());
        existingHiddenGem.setLocation(updatedHiddenGem.getLocation());
        existingHiddenGem.setImage(updatedHiddenGem.getImage());
        existingHiddenGem.setStartDay(updatedHiddenGem.getStartDay());
        existingHiddenGem.setEndDay(updatedHiddenGem.getEndDay());
        existingHiddenGem.setStartWorkingTime(updatedHiddenGem.getStartWorkingTime());
        existingHiddenGem.setEndWorkingTime(updatedHiddenGem.getEndWorkingTime());

        hiddenGemRepository.save(existingHiddenGem); 
        return new ModelAndView("redirect:/LocalBusinessOwner/hiddenGemInfo"); 
    }

    @GetMapping("deleteHiddenGemInfo/{id}")
    public ModelAndView deleteHiddenGemInfo(@PathVariable("id") int id) {
        this.hiddenGemRepository.deleteById(id);
        return new ModelAndView("redirect:/LocalBusinessOwner/hiddenGemInfo"); 
    }

    @GetMapping("/profile")
    public ModelAndView viewProfiles() {
        List<LocalBusinessOwner> localBusinessOwners = localBusinessOwnerRepository.findAll();
        ModelAndView mav = new ModelAndView("localBusinessOwner/profile"); 
        mav.addObject("localBusinessOwners", localBusinessOwners);
        return mav;
    }

    @GetMapping("/editProfile/{id}")
    public ModelAndView editProfileForm(@PathVariable("id") int id) {
        LocalBusinessOwner localBusinessOwner = localBusinessOwnerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid local business owner Id:" + id));
        ModelAndView mav = new ModelAndView("localBusinessOwner/editProfile");
        mav.addObject("localBusinessOwner", localBusinessOwner);
        return mav;
    }

    @PostMapping("/editProfile/{id}")
    public ModelAndView editProfile(@PathVariable("id") int id, @ModelAttribute LocalBusinessOwner updatedLocalBusinessOwner) {
        LocalBusinessOwner existingLocalBusinessOwner = localBusinessOwnerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid local business owner Id:" + id));
        existingLocalBusinessOwner.setName(updatedLocalBusinessOwner.getName());
        existingLocalBusinessOwner.setEmail(updatedLocalBusinessOwner.getEmail());
        existingLocalBusinessOwner.setPhoneNumber(updatedLocalBusinessOwner.getPhoneNumber());
        existingLocalBusinessOwner.setPassword(updatedLocalBusinessOwner.getPassword());

        localBusinessOwnerRepository.save(existingLocalBusinessOwner);
        return new ModelAndView("redirect:/LocalBusinessOwner/profile");
    }

    @GetMapping("/deleteProfile/{id}")
    public ModelAndView deleteProfile(@PathVariable("id") int id) {
        localBusinessOwnerRepository.deleteById(id);
        return new ModelAndView("redirect:/LocalBusinessOwner/profile");
    }
    
}
