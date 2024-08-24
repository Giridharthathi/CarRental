package com.ns.training.cardetails.controller;

import com.ns.training.cardetails.bean.OrderDetails;
import com.ns.training.cardetails.service.CarDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/admin-search")
public class AdminSearch {

    @Autowired
    private CarDetailService carDetailService;

    @GetMapping(path = "/{carId}",  produces="application/json")
    public ResponseEntity<List<OrderDetails>> carUsedbyUsersName(@PathVariable("carId") String carId){
        List<OrderDetails> userHistory = carDetailService.carUsedbyUsersByCarId(carId);
        if(!userHistory.isEmpty()) {
            return new ResponseEntity<>(userHistory, HttpStatus.OK);
        }return new ResponseEntity<>(userHistory, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "user-history/{userId}",  produces="application/json")
    public ResponseEntity<List<OrderDetails>> userHistory(@PathVariable("userId") String userId){
        List<OrderDetails> orderDetails = carDetailService.userHistoryByUserId(userId);
        if(!orderDetails.isEmpty()) {
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);
        }return new ResponseEntity<>(orderDetails, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> insertion(@RequestBody OrderDetails orderDetails, UriComponentsBuilder builder){
        int carInsertVerify = carDetailService.insertOrderDetails(orderDetails);
        if(carInsertVerify > 0){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(builder.path("api/search/{userId}").buildAndExpand(orderDetails.getUserId()).toUri());
            return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
