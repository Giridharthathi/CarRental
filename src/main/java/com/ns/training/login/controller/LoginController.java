    package com.ns.training.login.controller;

    import com.ns.training.login.bean.LoginBean;
    import com.ns.training.login.service.IService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpHeaders;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.util.UriComponentsBuilder;

    @CrossOrigin(origins = "http://localhost:4200")
    @RestController
    @RequestMapping("api/login")
    public class LoginController {
        @Autowired
        private IService loginService;

        @PostMapping(consumes = "application/json")
        public ResponseEntity<LoginBean> particularRecords(@RequestBody LoginBean userData, UriComponentsBuilder builder){
             if(loginService.validateUser(userData) ){
                 HttpHeaders httpHeaders = new HttpHeaders();
                 httpHeaders.setLocation(builder.path("api/books/{id}").buildAndExpand(userData.getUserId()).toUri());
                 return new ResponseEntity<LoginBean>(userData,httpHeaders, HttpStatus.OK);
             }
             else{
                 return new ResponseEntity<LoginBean>(userData,HttpStatus.BAD_REQUEST);
             }
        }

        @PostMapping(path = "update", consumes = "application/json")
        public ResponseEntity<LoginBean> updateMailAndPhoneNumber(@RequestBody LoginBean bean, UriComponentsBuilder builder) {

            if (loginService.updatePhoneNumberAndMail(bean) > 0) {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setLocation(builder.path("api/login/{id}").buildAndExpand(bean.getUserId()).toUri());
                return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }



    }