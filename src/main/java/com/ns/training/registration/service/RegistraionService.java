package com.ns.training.registration.service;

import com.ns.training.registration.bean.RegistrationBean;
import com.ns.training.registration.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistraionService implements IService {
    @Autowired
    private IRepository repository;

    @Override
    public int insertion(RegistrationBean bean) {
        return repository.insertion(bean);
    }
}
