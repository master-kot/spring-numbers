package com.nikolay.springnumbers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        String currentNumber = "A000AAA116RUS";
        model.addAttribute("number", currentNumber);
        return "number";
    }

    //Перехват GET-запроса вида: http://localhost:8080/number/random
    @GetMapping("/random")
    public String randomPage(Model model) {
        String currentNumber = "A000AAA116RUS";
        model.addAttribute("number", currentNumber);
        return "number";
    }
}