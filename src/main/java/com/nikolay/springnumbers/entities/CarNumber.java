package com.nikolay.springnumbers.entities;

/**
 * Заготовка класса сущности автомобильного номера.
 * В процессе разработки решил упростить сущность номера,
 * оставив ее в виде простого класса String.
 * Следует использовать ее в исходном виде, если нужно иметь дополнительные поля
 * владелец, адрес, дата, место выдачи номера и хранить сощность в базе данных.
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