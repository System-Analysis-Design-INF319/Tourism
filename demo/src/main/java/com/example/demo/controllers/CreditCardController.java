package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.models.CreditCard;
import com.example.demo.repositories.CreditCardRepository;


@RestController

@RequestMapping("/paydeposit")
public class CreditCardController {
    @SuppressWarnings("unused")
    @Autowired
    private CreditCardRepository creditcardRepository;
  
    
    // @GetMapping("/validate")
    
    // public ModelAndView addCreditCard() {         
    // ModelAndView mav = new ModelAndView("/tourist/creditcard.html");
    //     CreditCard newCreditCard = new CreditCard();
    //     mav.addObject("creditcard", newCreditCard);
    //     return mav;
    // }
    // @PostMapping("/validate")
    //     public ModelAndView savecreditcard(@Validated @ModelAttribute CreditCard creditcard) {
    //         ModelAndView mav = new ModelAndView("/tourist/creditcard.html");
    //         mav.addObject("creditcard", creditcard);
    //         if (creditcard.isEmpty(creditcard.getCardNumber()) || creditcard.isEmpty(creditcard.getCvv()) ||
    //         creditcard.isEmpty(creditcard.getExpiryDate())) {
    //         mav.addObject("emptyFieldsError", "Please fill in all fields");
    //         mav.addObject("hasEmptyFieldsError", true);
    //         hasError = true;

    @GetMapping("/validate")
    public ModelAndView addCreditCard() {         
        ModelAndView mav = new ModelAndView("/tourist/creditcard.html");
        CreditCard newCreditCard = new CreditCard();
        mav.addObject("creditcard", newCreditCard);
        return mav;
    }

    @PostMapping("/validate")
    public ModelAndView saveCreditCard(@ModelAttribute CreditCard creditcard) {
        ModelAndView mav = new ModelAndView("/tourist/creditcard.html");
        // mav.addObject("creditcard", creditcard);

        // boolean hasError = false;
        if (!creditcard.isEmpty(creditcard.getCardNumber()) && !creditcard.isEmpty(creditcard.getCvv()) && !creditcard.isEmpty(creditcard.getCardName())) {
               
            if (String.valueOf(creditcard.getCvv()).length() != 3) {
                mav.addObject("CvvError", "CVV must be 3 digits");
                mav.addObject("hasCvvError", true);
                // hasError = true;
            }
            if (String.valueOf(creditcard.getCardNumber()).length() != 16 ) {
                mav.addObject("CardNumberError", "Card Number must be 16 digits");
                mav.addObject("hasCardNumberError", true);
                // hasError = true;
            }
            if(!creditcard.isValidDate(creditcard.getExpiryDate())){
                mav.addObject("ExpiryDateError", "the card is expired");
                mav.addObject("hasExpiryDateError", true);
            }
            if (mav.getModel().containsKey("hasCvvError") || mav.getModel().containsKey("hasCardNumberError") || mav.getModel().containsKey("hasExpiryDateError"))
                return mav; 

        // if (!hasError) {
        //     creditcardRepository.save(creditcard);
        //     return new ModelAndView("redirect:/tourist/index");
        // }                    
        }
        else{
            mav.addObject("emptyFieldsError", "Please fill in all fields");
            mav.addObject("hasEmptyFieldsError", true);
            return mav;
        }
        return new ModelAndView("/tourist/index.html");
        
        }
        





    











    //         if (creditcard.isEmpty(creditcard.getCardNumber()) || creditcard.isEmpty(creditcard.getCvv()) ||
    //         creditcard.isEmpty(creditcard.getExpiryDate())) {
    //         mav.addObject("emptyFieldsError", "Please fill in all fields");
    //         mav.addObject("hasEmptyFieldsError", true);
    //         }
    //         else {
    //         if (String.valueOf(creditcard.getCvv()).length() != 3) {
    //             mav.addObject("CvvError", "Cvv must be 3 digits");
    //             mav.addObject("hasCvvError", true);
    //         }
            

    //         if (String.valueOf(creditcard.getCardNumber()).length() != 15 ) {
    //             mav.addObject("CardNumberError", "CardNumber must be 15 digits");
    //             mav.addObject("hasCardNumberError", true);
    //         }
    //         if (mav.getModel().containsKey("hasCvvError") ||
    //         mav.getModel().containsKey("hasCardNumberError") )          
         
    //         if (!hasError) {
    //             creditCardRepository.save(creditCard);
    //             return new ModelAndView("redirect:/tourist/index");
    //         }
    //     }
        
    //         return mav;
    // }
}




