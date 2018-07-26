package pl.dudekjunior.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dudekjunior.phonebook.models.forms.PhoneBookForm;
import pl.dudekjunior.phonebook.models.services.PhoneBookService;

import javax.validation.Valid;

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
    public String addNumber(@ModelAttribute("phoneBookForm") @Valid PhoneBookForm phoneBookForm,
                            BindingResult bindingResult,
                            Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error", "Popraw dane");
            return "addnumber";
        }

        if(!phoneBookService.tryToAddNumber(phoneBookForm)){
            model.addAttribute("errorInfo", "Istnieje kontakt z takim numerem");
            return "addnumber";
        }
        model.addAttribute("addNumber", "Dodano poprawenie numer");
        return "phonebook";
    }

    @GetMapping("/phonebook")
    public String phoneBook(Model model){
        model.addAttribute("numbers", phoneBookService.getAllNumbers());
        return "phonebook";
    }

    @GetMapping("/shownumber/{id}")
    public String showNumber(@PathVariable("id") int id, Model model){
        model.addAttribute("phoneBookEntity", phoneBookService.getPhoneBookEntity(id));
        return "shownumber";
    }

}
