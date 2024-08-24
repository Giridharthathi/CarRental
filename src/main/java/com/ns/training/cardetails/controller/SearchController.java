package com.ns.training.cardetails.controller;

import com.ns.training.cardetails.bean.CarDetailsBean;
import com.ns.training.cardetails.bean.OrderDetails;
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
@RequestMapping("api/search")

public class SearchController {

    @Autowired
    private IService carDetailService;

    @GetMapping(path = "/{searchName}", produces = "application/json")
    public List<CarDetailsBean> fetchParticularRecord(@PathVariable("searchName") String searchName){
              return carDetailService.fetchParticularRecordByUserPreferenceSearch(searchName);
    }


}
