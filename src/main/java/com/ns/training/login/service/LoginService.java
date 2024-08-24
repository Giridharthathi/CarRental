package com.ns.training.login.service;

import com.ns.training.login.bean.LoginBean;
import com.ns.training.login.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements IService{

    @Autowired
    private IRepository loginRepository;

    @Override
    public boolean validateUser(LoginBean credentialsBean) {
       List<LoginBean> fetchedUser= loginRepository.credentials(credentialsBean);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String enteredPassword = credentialsBean.getPassword();

        if (credentialsBean.getMail().equals(fetchedUser.get(0).getMail()) &&
                encoder.matches(enteredPassword, fetchedUser.get(0).getPassword()))
       {
           credentialsBean.setUserId(fetchedUser.get(0).getUserId());
           credentialsBean.setFirstName(fetchedUser.get(0).getFirstName());
           credentialsBean.setLastName(fetchedUser.get(0).getLastName());
           credentialsBean.setGender(fetchedUser.get(0).getGender());
           credentialsBean.setAge(fetchedUser.get(0).getAge());
           credentialsBean.setMail(fetchedUser.get(0).getMail());
           credentialsBean.setPhoneNumber(fetchedUser.get(0).getPhoneNumber());
           credentialsBean.setUserRole(fetchedUser.get(0).getUserRole());
           return true;
       }
       else {
           return false;
       }
    }

    public int updatePhoneNumberAndMail(LoginBean bean){
        return loginRepository.updatePhoneNumberAndMail(bean);
    }
}
