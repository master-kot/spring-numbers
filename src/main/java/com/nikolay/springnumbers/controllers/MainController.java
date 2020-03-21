package com.nikolay.springnumbers.controllers;

import com.nikolay.springnumbers.entities.CarNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashSet;

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
    public String nextNumberPage(Model model) {
        //CarNumber currentNumber = new CarNumber("A000AAA116RUS");
        String currentNumber = "A000AAA116RUS";
        model.addAttribute("number", currentNumber);
        return "currentNumber";
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/random
    @GetMapping("/random")
    public String randomNumberPage(Model model) {
        //CarNumber currentNumber = new CarNumber("B111BB116RUS");
        String currentNumber = "B111BB116RUS";
        model.addAttribute("number", currentNumber);
        return "currentNumber";
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/all
    @GetMapping("/all")
    public String allNumbersPage(Model model) {
        LinkedHashSet<String> numbers = new LinkedHashSet<String>();
        numbers.add("A000AAA116RUS");
        numbers.add("B111BB116RUS");
        numbers.add("E222EE116RUS");

        model.addAttribute("numbers", numbers);
        return "allNumbers";
    }
}