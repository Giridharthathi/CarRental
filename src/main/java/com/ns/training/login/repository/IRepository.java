package com.ns.training.login.repository;

import com.ns.training.login.bean.LoginBean;

import java.util.List;

public interface IRepository {
    List<LoginBean> credentials(LoginBean credentialBean);
    public int updatePhoneNumberAndMail(LoginBean bean);
 
}
