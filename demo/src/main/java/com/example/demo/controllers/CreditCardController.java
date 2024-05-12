// package com.example.demo.controllers;

// import org.springframework.validation.Errors;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.ModelAndView;
// import com.example.demo.models.CreditCard;


// @RestController

// @RequestMapping("/")
// public class CreditCardController {
  
    
//     @GetMapping("/validate")
    
//     public ModelAndView addCreditCard() {         
//     ModelAndView mav = new ModelAndView("/tourist/creditcard.html");
//         CreditCard newCreditCard = new CreditCard();
//         mav.addObject("creditcard", newCreditCard);
//         return mav;
//     }
//     @PostMapping("/validate")
//         public ModelAndView savecreditcard(@Validated @ModelAttribute CreditCard creditcard) {
//             ModelAndView mav = new ModelAndView("/tourist/creditcard.html");
//             mav.addObject("creditcard", creditcard);

//             if (creditcard.isEmpty(creditcard.getCardNumber()) || creditcard.isEmpty(creditcard.getCvv()) ||
//             creditcard.isEmpty(creditcard.getExpiryDate())) {
//             mav.addObject("emptyFieldsError", "Please fill in all fields");
//             mav.addObject("hasEmptyFieldsError", true);
//             }
//             else {
//             if (String.valueOf(creditcard.getCvv()).length() != 3) {
//                 mav.addObject("CvvError", "Cvv must be 3 digits");
//                 mav.addObject("hasCvvError", true);
//             }
            

//             if (String.valueOf(creditcard.getCardNumber()).length() != 15 ) {
//                 mav.addObject("CardNumberError", "CardNumber must be 15 digits");
//                 mav.addObject("hasCardNumberError", true);
//             }
//             if (mav.getModel().containsKey("hasCvvError") ||
//             mav.getModel().containsKey("hasCardNumberError") )          
//             return mav;

//             // return new ModelAndView("redirect:/tourist/index");
           
//         }
        
//             return mav;
//     }
// }




// // CardNumber;
// // private int Cvv;
// // private int ExpiryDate;

