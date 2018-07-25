package pl.dudekjunior.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dudekjunior.phonebook.models.forms.PhoneBookForm;
import pl.dudekjunior.phonebook.models.services.PhoneBookService;

@Controller
public class PhoneBookController {


    final PhoneBookService phoneBookService;
    @Autowired
    public PhoneBookController(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    @GetMapping("/addnumber")
    public String addNumber(Model model){
        model.addAttribute("phoneBookForm", new PhoneBookForm());
        return "addnumber";
    }

    @PostMapping("/addnumber")
    public String addNumber(@ModelAttribute("phoneBookForm") PhoneBookForm phoneBookForm,
                            Model model){
        if(!phoneBookService.tryToAddNumber(phoneBookForm)){
            model.addAttribute("errorInfo", "Istnieje kontakt z takim numerem");
            return "addnumber";
        }
        model.addAttribute("addNumber", "Dodano poprawenie numer");
        return "phonebook";
    }

//    @GetMapping("/phonebook")
//    public String showPhoneBook(Model model){
//        return "phonebook";
//    }
}
