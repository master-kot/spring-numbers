package com.nikolay.springnumbers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс запуска web-приложения на основе Spring Boot.
 * Web-приложение создано по классической архитектуре Spring Boot,
 * а именно работа с данными осуществляется последовательно через цепочку:
 * Контроллер -> Сервис -> Репозиторий -> Сущность -> База данных,
 * по условиям задания сохранение в БД не требовалось
 */
@SpringBootApplication
public class SpringNumbersApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringNumbersApplication.class, args);
	}
}