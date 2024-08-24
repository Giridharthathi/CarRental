package com.ns.training.cardetails.service;

import com.ns.training.cardetails.bean.CarDetailsBean;
import com.ns.training.cardetails.bean.OrderDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IService {
    List<CarDetailsBean> fetchAllRecords();
    List<CarDetailsBean> fetchParticularRecord(int carId);
    int deleteCar(int carId);
    int insertCar(CarDetailsBean carBean);
    int updateCar(CarDetailsBean carBean, int carId);
    public List<CarDetailsBean> fetchParticularRecordByUserPreferenceSearch(String searchName);
    int insertOrderDetails(OrderDetails orderDetails);
    public List<OrderDetails> carUsedbyUsersByCarId(String carId);
    public List<OrderDetails> userHistoryByUserId( String userId);
}
