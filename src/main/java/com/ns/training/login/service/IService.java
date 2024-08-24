package com.ns.training.login.service;

import com.ns.training.login.bean.LoginBean;

public interface IService {
    boolean validateUser(LoginBean credentialsBean);
    public int updatePhoneNumberAndMail(LoginBean bean);
}
