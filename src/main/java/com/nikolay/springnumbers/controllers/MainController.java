package com.nikolay.springnumbers.controllers;

import com.nikolay.springnumbers.entities.CarNumber;
import com.nikolay.springnumbers.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Главный контроллер приложения
 */
@Controller
public class MainController {

    //Объявляем сервис номеров
    private NumberService numberService;

    //Инжектим сервис номеров
    @Autowired
    public void setNumberService(NumberService numberService) {
        this.numberService = numberService;
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/index
    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/next
    @GetMapping("/next")
    public String nextNumberPage(Model model) {
        model.addAttribute("number", numberService.addNextNumber());
        return "nextNumber";
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/random
    @GetMapping("/random")
    public String randomNumberPage(Model model) {
        model.addAttribute("number", numberService.addRandomNumber());
        return "randomNumber";
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/all
    @GetMapping("/all")
    public String allNumbersPage(Model model) {
        model.addAttribute("numbers", numberService.getNumbers());
        return "allNumbers";
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/string/next
    @GetMapping("/string/next")
    @ResponseBody
    public String nextNumber() {
        return numberService.addNextNumber();
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/string/random
    @GetMapping("/string/random")
    @ResponseBody
    public String randomNumber() {
        return numberService.addRandomNumber();
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/string/all
    @GetMapping("/string/all")
    @ResponseBody
    public String allNumbers() {
        return numberService.getNumbers().toString();
    }
}