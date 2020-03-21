package com.nikolay.springnumbers.entities;

/**
 * Заготовка класса сущности автомобильного номера для работы с базой данных.
 * Поскольку в задании не требуется сохранение номеров в БД,
 * было решено упростить сущность номера, оставив в виде String.
 * Следует использовать сущьность в данном виде, если нужно иметь дополнительные поля:
 * владелец, адрес, дата, VIN, место выдачи номера или хранить номера в базе данных.
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