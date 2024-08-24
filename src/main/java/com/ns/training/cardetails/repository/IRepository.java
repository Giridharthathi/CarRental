package com.ns.training.cardetails.repository;

import com.ns.training.cardetails.bean.CarDetailsBean;
import com.ns.training.cardetails.bean.OrderDetails;

import java.util.List;

public interface IRepository {
    List<CarDetailsBean> fetchAllCarRecords();
    List<CarDetailsBean> fetchParticularRecord(int carId);
    int deleteCar(int carId);
    int insertCar(CarDetailsBean carBean);
    int updateCar(CarDetailsBean carBean, int carId);
    List<CarDetailsBean> fetchParticularRecordByUserPreferenceSearch(String searchName);

    int insertOrderDetails(OrderDetails orderDetails);
    public List<OrderDetails> carUsedbyUsersByCarId(String carId);
    public List<OrderDetails> userHistoryByUserId( String userId);
}
