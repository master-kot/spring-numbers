package com.nikolay.springnumbers.services;

import com.nikolay.springnumbers.repositories.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

@Service
public class NumberService {

    private NumberRepository numberRepository;

    //Создаем ссылку на репозиторий номеров
    @Autowired
    public void setNumberRepository (NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    //Создаем нужные методы взаимодействия с репозиторием номеров
    public LinkedHashSet<String> getNumbers () {
        return numberRepository.getNumbers();
    }

    public String addNextNumber() {
        return numberRepository.addNextNumber();
    }

    public String addRandomNumber() {
        return numberRepository.addRandomNumber();
    }
}