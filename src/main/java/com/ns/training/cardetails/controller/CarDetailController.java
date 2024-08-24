package com.ns.training.cardetails.controller;

import com.ns.training.cardetails.bean.CarDetailsBean;
import com.ns.training.cardetails.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/car")

public class CarDetailController {

    @Autowired
    private IService carDetailService;

    @GetMapping(produces = "application/json")
    public List<CarDetailsBean> fetchAllRecords(){
        return carDetailService.fetchAllRecords();
    }

    @GetMapping(path = "/{carId}", produces = "application/json")
    public List<CarDetailsBean> fetchParticularRecord(@PathVariable("carId") int carId){
        return carDetailService.fetchParticularRecord(carId);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable("carId") int carId){
        int deleteEffected =  carDetailService.deleteCar(carId);
        if(deleteEffected > 0){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST );
        }
    }

//    @PutMapping(consumes = "applicatio/json")
    @PutMapping(path="/{carId}", consumes = "application/json")
    public ResponseEntity<Void> updateCar(@PathVariable("carId") int carId, @RequestBody CarDetailsBean carBean, UriComponentsBuilder builder){
        int updateRequest = carDetailService.updateCar(carBean ,carId);
        if(updateRequest > 0){
           return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> insertion(@RequestBody CarDetailsBean carDetail, UriComponentsBuilder builder){
        int carInsertVerify = carDetailService.insertCar(carDetail);
        if(carInsertVerify > 0){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(builder.path("api/car/{carId}").buildAndExpand(carDetail.getCarId()).toUri());
            return new ResponseEntity<>(httpHeaders,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}