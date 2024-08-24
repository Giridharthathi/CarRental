package com.ns.training.registration.repository;


import com.ns.training.registration.bean.RegistrationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RegistrationRepository implements IRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    private final String insertQuery = "insert into usersdata (FirstName, LastName, Gender, Age, MailId, " +
            "PhoneNumber, UserRole, UserPassword) values(?,?,?,?,?,?,?,?)";

    private String selectQuery = "select * from userdata where MailId = '?'";

    @Override
    public int insertion(RegistrationBean registrationBean) {
            return jdbcTemplate.update(insertQuery,
                    registrationBean.getFirstName(), registrationBean.getLastName(),
                    registrationBean.getGender(), registrationBean.getAge(), registrationBean.getMail(),
                    registrationBean.getPhoneNumber()
                    , registrationBean.getUserRole(), registrationBean.getPassword());
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
