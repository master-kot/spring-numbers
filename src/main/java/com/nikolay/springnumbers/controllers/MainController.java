package com.nikolay.springnumbers.controllers;

import com.nikolay.springnumbers.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Главный контроллер приложения
@Controller
public class MainController {

    private NumberService numberService;

    @Autowired
    public void setNumberService(NumberService numberService) {
        this.numberService = numberService;
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/next
    @GetMapping("/next")
    @ResponseBody
    public String nextNumber() {
        return numberService.addNextNumber();
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/random
    @GetMapping("/random")
    @ResponseBody
    public String randomNumber() {
        return numberService.addRandomNumber();
    }

    //Перехват GET-запроса вида: http://localhost:8080/number//all
    @GetMapping("/all")
    @ResponseBody
    public String allNumbers() {
        return numberService.getNumbers().toString();
    }


    //Перехват GET-запроса вида: http://localhost:8080/number/
    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/html/next")
    public String nextNumberPage(Model model) {
        model.addAttribute("number", numberService.addNextNumber());
        return "nextNumber";
    }

    @GetMapping("/html/random")
    public String randomNumberPage(Model model) {
        model.addAttribute("number", numberService.addRandomNumber());
        return "randomNumber";
    }

    @GetMapping("/html/all")
    public String allNumbersPage(Model model) {
        model.addAttribute("numbers", numberService.getNumbers());
        return "allNumbers";
    }
}