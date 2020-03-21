package com.nikolay.springnumbers.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedHashSet;

@Service
public class NumberService {

    private LinkedHashSet<String> numbers;

    public LinkedHashSet<String> getNumbers () {
        return numbers;
    }

    @PostConstruct
    public void init() {
        numbers = new LinkedHashSet<>();
        numbers.add("A000AAA116RUS");
        numbers.add("B111BB116RUS");
        numbers.add("E222EE116RUS");
    }
}