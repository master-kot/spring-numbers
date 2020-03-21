package com.nikolay.springnumbers.entities;

/**
 * Класс сущности автомобильного номера
 */
public class CarNumber {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CarNumber() {
    }

    public CarNumber(String id) {
        this.id = id;
    }
}