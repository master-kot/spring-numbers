package com.nikolay.springnumbers.controllers;

import com.nikolay.springnumbers.entities.CarNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Главный контроллер приложения
 */
@Controller
public class MainController {

    //Перехват GET-запроса вида: http://localhost:8080/number/index
    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/next
    @GetMapping("/next")
    public String nextPage(Model model) {
        CarNumber currentNumber = new CarNumber("A000AAA116RUS");
        model.addAttribute("number", currentNumber);
        return "number";
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/random
    @GetMapping("/random")
    public String randomPage(Model model) {
        CarNumber currentNumber = new CarNumber("B111BB116RUS");
        model.addAttribute("number", currentNumber);
        return "number";
    }
}