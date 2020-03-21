package com.nikolay.springnumbers.services;

import com.nikolay.springnumbers.repositories.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Random;

@Service
public class NumberService {

    private NumberRepository numberRepository;

    //Создаем ссылку на репозиторий номеров
    @Autowired
    public void setNumberRepository (NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    //Получаем список всех номеров из репозитория
    public LinkedHashSet<String> getNumbers () {
        return numberRepository.getNumbers();
    }

    private final Random randomizer = new Random();

    //Список возможных вариантов букв номера
    private final char[] examplesOfChars = new char[] {'А', 'Е', 'Т', 'О', 'Р', 'Н', 'У', 'К', 'Х', 'С', 'В', 'М'};
    private final String NUMBER_APPENDER_O = "0";
    private final String NUMBER_APPENDER_OO = "00";
    private final String NUMBER_APPENDER_REG = "116RUS";
    private final int MAX_POSITION_OF_LETTER = examplesOfChars.length - 1;

    //Чтобы не плодить множество экземпляров String для создания номеров используем буфер
    private final StringBuilder carNumber = new StringBuilder();

    //Здесь храним позицию букв и цифры текущего номера
    private int positionOfFirstLetter;
    private int positionOfSecondLetter;
    private int positionOfThirdLetter;
    private int digitsOfNumber;

    /**
     * Нижерасположенные методы добавления в репозиторий номеров были протестированы в отдельном классе,
     * они гарантированно добавляют только уникальные номера в хранилище.
     * Метод addNextNumber заполняет хранилище всевозможными комбинациями номеров за пару секунд.
     */
    public String addNextNumber() {
        while (true) {
            //очищаем буфер на каждой итерации
            carNumber.delete(0, carNumber.length());

            //обеспечиваем циклическое чередование букв номера
            if (digitsOfNumber > 999) {
                digitsOfNumber = 0;
                positionOfThirdLetter++;
                if (positionOfThirdLetter > MAX_POSITION_OF_LETTER) {
                    positionOfThirdLetter = 0;
                    positionOfSecondLetter++;
                }
                if (positionOfSecondLetter > MAX_POSITION_OF_LETTER) {
                    positionOfSecondLetter = 0;
                    positionOfFirstLetter++;
                }
                //Здесь вместо исключения можно изменять NUMBER_APPENDER_REG, создавая новую серию номеров
                if (positionOfFirstLetter > MAX_POSITION_OF_LETTER) throw new RuntimeException("Номера закончились!");
            }

            //формируем следующий номер, обеспечивая заданный порядок букв и цифр
            carNumber.append(examplesOfChars[positionOfFirstLetter]);
            if (digitsOfNumber < 10) carNumber.append(NUMBER_APPENDER_OO);
            else if (digitsOfNumber < 100) carNumber.append(NUMBER_APPENDER_O);
            carNumber.append(digitsOfNumber++)
                    .append(examplesOfChars[positionOfSecondLetter])
                    .append(examplesOfChars[positionOfThirdLetter])
                    .append(NUMBER_APPENDER_REG);

            //сохраняем номер в хранилище и возвращаем его значение
            if (numberRepository.addNumber(carNumber.toString())) return carNumber.toString();
        }
    }

    public String addRandomNumber() {
        while (true) {
            //очищаем буфер на каждой итерации
            carNumber.delete(0, carNumber.length());

            //формируем случайный номер, обеспечивая заданный порядок букв и цифр
            carNumber.append(examplesOfChars[randomizer.nextInt(MAX_POSITION_OF_LETTER)]);
            int randomDigitsOfNumber = randomizer.nextInt(999);
            if (randomDigitsOfNumber < 10) carNumber.append(NUMBER_APPENDER_OO);
            else if (randomDigitsOfNumber < 100) carNumber.append(NUMBER_APPENDER_O);
            carNumber.append(randomDigitsOfNumber)
                    .append(examplesOfChars[randomizer.nextInt(MAX_POSITION_OF_LETTER)])
                    .append(examplesOfChars[randomizer.nextInt(MAX_POSITION_OF_LETTER)])
                    .append(NUMBER_APPENDER_REG);

            //сохраняем номер в хранилище и возвращаем его значение
            if (numberRepository.addNumber(carNumber.toString())) return carNumber.toString();
        }
    }
}