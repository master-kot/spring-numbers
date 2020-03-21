package com.nikolay.springnumbers.repositories;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * Класс репозитория номеров, чтобы затем сохранять номера в БД.
 * Поскольку в задании не было указано хранить номера в базе данных,
 * то в текущей версии приложения данная опция не реализована.
 */
@Component
public class NumberRepository {

    /**Объявляем класс-хранилище всех добавленных номеров.
     * Используем LinkedHashSet чтобы наглядно показать, что номера добавляются по порядку
     * Конечно с точки зрения производительности лучше использовать HashSet.
     */
    private LinkedHashSet<String> storageOfNumbers;

    //Создаем класс-хранилище номеров, в дальнейшем будем хранить их в БД
    @PostConstruct
    public void init() {
        storageOfNumbers = new LinkedHashSet<>();
    }

    //Получаем список всех номеров
    public LinkedHashSet<String> getNumbers () {
        return storageOfNumbers;
    }

    //Добавляем номер в репозиторий и возвращаем результат добавления
    public boolean addNumber(String carNumber) {
        return storageOfNumbers.add(carNumber);
    }
}