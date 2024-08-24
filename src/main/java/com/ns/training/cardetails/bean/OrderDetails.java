package com.ns.training.cardetails.bean;

import java.util.Date;

public class OrderDetails {

    private int carId;
    private int userId;
    private int payment;
    private Date fromDate;
    private int days;
    private String firstname;
    private String carName;
    private int model;
    private int seats;
    private String city;

    public OrderDetails() {
    }

    public OrderDetails(int carId, int userId, int payment, Date fromDate, int days, String firstname, String carName, int model, int seats, String city) {
        this.carId = carId;
        this.userId = userId;
        this.payment = payment;
        this.fromDate = fromDate;
        this.days = days;
        this.firstname = firstname;
        this.carName = carName;
        this.model = model;
        this.seats = seats;
        this.city = city;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
