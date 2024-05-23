package com.example.demo.controllers;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.HiddenGem;
import com.example.demo.models.LocalBusinessOwner;
import com.example.demo.repositories.HiddenGemRepository;
import com.example.demo.repositories.LocalBusinessOwnerRepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/LocalBusinessOwner")
public class LocalBusinessOwnerController {
    
    @Autowired
    private HiddenGemRepository hiddenGemRepository;
    @Autowired
    private LocalBusinessOwnerRepository LocalBusinessOwnerRepository;

    @GetMapping("/dashboard")
    public ModelAndView adminIndex() {         
        return new ModelAndView("LocalBusinessOwner/dashboard.html");
    }
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("/LocalBusinessOwner/login.html");
        mav.addObject("name");
        return mav;
    }
    @PostMapping("/login")
    public ModelAndView loginProcess(@RequestParam("name") String name,
            @RequestParam("password") String password, HttpSession session) {
        ModelAndView mav = new ModelAndView("/LocalBusinessOwner/login.html");

        if (name == null || password == null) {
            mav.addObject("loginError", "Please provide both name and password");
            return mav;
        }

        LocalBusinessOwner dblocalBusinessOwner = LocalBusinessOwnerRepository.findByName(name);
        if (dblocalBusinessOwner == null) {
            mav.addObject("loginError", "name not found");
            mav.addObject("loginErrorField", "name");
            return mav;
        }

        boolean isPasswordMatched = BCrypt.checkpw(password, dblocalBusinessOwner.getPassword());
        if (!isPasswordMatched) {
            mav.addObject("loginError", "Incorrect password");
            mav.addObject("loginErrorField", "password");
            return mav;
        }

        // Redirect to the index page after successful login
        session.setAttribute("LocalBusinessOwner_id", dblocalBusinessOwner.getId());
        session.setAttribute("name", dblocalBusinessOwner.getName());
        return new ModelAndView("redirect:/LocalBusinessOwner/dashboard");

    }


    // LocalBusinessOwner dblocalBusinessOwner = this.LocalBusinessOwnerRepository.findByName(name);
    // System.out.println(name);
    // if (dblocalBusinessOwner != null && BCrypt.checkpw(password, dblocalBusinessOwner.getPassword())) {
    //     System.out.println(dblocalBusinessOwner.getName());
    //     session.setAttribute("LocalBusinessOwner_id", dblocalBusinessOwner.getId());
    //     session.setAttribute("name", dblocalBusinessOwner.getName());
    //     System.out.println("true");
    //     return new RedirectView("addHiddenGem");
      
        
    //     // mav.addObject("loginError", "name not found");
    //     // mav.addObject("loginErrorField", "name");
    //     // return mav;
    // }
    // else{
    //     return new RedirectView("/LocalBusinessOwner/login");
    // }
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

}
