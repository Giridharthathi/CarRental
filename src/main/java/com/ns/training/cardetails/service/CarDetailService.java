package com.ns.training.cardetails.service;

import com.ns.training.cardetails.bean.CarDetailsBean;
import com.ns.training.cardetails.bean.OrderDetails;
import com.ns.training.cardetails.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDetailService implements IService {

    @Autowired
    private IRepository carDetailRepository;

    @Override
    public List<CarDetailsBean> fetchAllRecords() {
        return carDetailRepository.fetchAllCarRecords();
    }

    public List<CarDetailsBean> fetchParticularRecord(int carId){
        return carDetailRepository.fetchParticularRecord(carId);
    }

    public int deleteCar(int carId){
        return carDetailRepository.deleteCar(carId);
    }

    public int updateCar(CarDetailsBean carBean, int carId){
        return carDetailRepository.updateCar(carBean, carId);
    }
    public int insertCar(CarDetailsBean carBean){
        return carDetailRepository.insertCar(carBean);
    }
    public List<CarDetailsBean> fetchParticularRecordByUserPreferenceSearch(String searchName){
        return carDetailRepository.fetchParticularRecordByUserPreferenceSearch(searchName);
    }
    public int insertOrderDetails(OrderDetails orderDetails){
        return carDetailRepository.insertOrderDetails(orderDetails);
    }
    public List<OrderDetails> carUsedbyUsersByCarId(String carId){
        return carDetailRepository.carUsedbyUsersByCarId(carId);
    }

    public List<OrderDetails> userHistoryByUserId( String userId){
        return carDetailRepository.userHistoryByUserId(userId);
    }
}
