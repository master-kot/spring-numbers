package com.nikolay.springnumbers.repositories;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashSet;

/**
 * Класс репозитория номеров, чтобы их затем сохранить в БД, правда же?
 * Иначе зачем нам вот это вот все красивое приложение???
 */
@Component
public class NumberRepository {

    //Объявляем класс-хранилище номеров
    private LinkedHashSet<String> numbers;

    //Создаем класс-хранилище номеров, в дальнейшем будем хранить их в БД
    @PostConstruct
    public void init() {
        numbers = new LinkedHashSet<>();
        //numbers.add("A000AAA116RUS");
        //numbers.add("B111BB116RUS");
        //numbers.add("E222EE116RUS");
    }

    //Получить список всех номеров
    public LinkedHashSet<String> getNumbers () {
        return numbers;
    }

    //Добавить следующий номер
    public String addNextNumber() {
        return "A000AAA116RUS";
    }

    //Добавить случайный номер
    public String addRandomNumber() {
        return "A123BC116RUS";
    }
}