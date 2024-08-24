package com.ns.training.cardetails.bean;


public class CarDetailsBean {

    private int carId;
    private String carName;
    private int model;
    private int seats;
    private String fuelCapacity;
    private String airBags;
    private String fuelType;
    private String carType;
    private String transmission;
    private String registrationNumber;
    private String kmsDriven;
    private int price;
    private float rating;
    private String ownerMailId;
    private String city;
    private int dataPresence;

    public CarDetailsBean() {
    }

    public CarDetailsBean(int carId, String carName, int model, int seats, String fuelCapacity, String airBags, String fuelType, String carType, String transmission, String registrationNumber, String kmsDriven, int price, float rating, String ownerMailId, String city, int dataPresence) {
        this.carId = carId;
        this.carName = carName;
        this.model = model;
        this.seats = seats;
        this.fuelCapacity = fuelCapacity;
        this.airBags = airBags;
        this.fuelType = fuelType;
        this.carType = carType;
        this.transmission = transmission;
        this.registrationNumber = registrationNumber;
        this.kmsDriven = kmsDriven;
        this.price = price;
        this.rating = rating;
        this.ownerMailId = ownerMailId;
        this.city = city;
        this.dataPresence = dataPresence;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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

    public String getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(String fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getAirBags() {
        return airBags;
    }

    public void setAirBags(String airBags) {
        this.airBags = airBags;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(String kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getOwnerMailId() {
        return ownerMailId;
    }

    public void setOwnerMailId(String ownerMailId) {
        this.ownerMailId = ownerMailId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDataPresence() {
        return dataPresence;
    }

    public void setDataPresence(int dataPresence) {
        this.dataPresence = dataPresence;
    }

    @Override
    public String toString() {
        return "CarDetailsBean{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", model=" + model +
                ", seats=" + seats +
                ", fuelCapacity='" + fuelCapacity + '\'' +
                ", airBags=" + airBags +
                ", fuelType='" + fuelType + '\'' +
                ", carType='" + carType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", kmsDriven='" + kmsDriven + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", ownerMailId='" + ownerMailId + '\'' +
                ", city='" + city + '\'' +
                ", dataPresence=" + dataPresence +
                '}';
    }
}
