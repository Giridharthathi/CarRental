package com.ns.training.registration.service;

import com.ns.training.registration.bean.RegistrationBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidation implements Validator{
    @Override
    public boolean supports(Class aClass) {
        return RegistrationBean.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        RegistrationBean registrationBean = (RegistrationBean)object;
        if(registrationBean.getAge()<18 && registrationBean.getAge() > 100){
            errors.rejectValue("Age", "Invalid Age", "Age should be greater than 18");
        }
        if(registrationBean.getGender().equalsIgnoreCase("male") || registrationBean.getGender().equalsIgnoreCase("female")){
            errors.rejectValue("Gender", "Invalid Gender", "Gender should be Male or Female not other than that");
        }
        if((registrationBean.getPhoneNumber()).length()==10){
            errors.rejectValue("Phone Number", "Invalid Phone Number", "Phone Number should be of 10 digits");
        }
    }
}
