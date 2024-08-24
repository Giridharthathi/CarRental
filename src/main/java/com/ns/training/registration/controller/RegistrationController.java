package com.ns.training.registration.controller;

import com.ns.training.registration.bean.RegistrationBean;
import com.ns.training.registration.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/registration")
public class RegistrationController {
    @Autowired
    private IService service;

    @Autowired
    private Validator registrationValidations;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> insertion(@Valid @RequestBody RegistrationBean userDeatils,
            BindingResult result, ModelMap modelMap, UriComponentsBuilder builder) {
        registrationValidations.validate(userDeatils, result);
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            int count = service.insertion(userDeatils);
            if (count > 0) {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setLocation(builder.path("api/user/{FirstName}").buildAndExpand(userDeatils.getFirstName()).toUri());
                return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
}
