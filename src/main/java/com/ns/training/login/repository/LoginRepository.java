package com.ns.training.login.repository;

import com.ns.training.login.bean.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LoginRepository implements IRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    private String selectQuery = " SELECT * FROM usersdata WHERE MailId = ? ";
    private String updateQuery = "UPDATE usersdata SET MailId =?, PhoneNumber = ? WHERE UserId=?";

    public List<LoginBean> credentials(LoginBean credentialBean){
        return jdbcTemplate.query(selectQuery, new Object[]{credentialBean.getMail()}, new RowMapper<LoginBean>() {
            @Override
            public LoginBean mapRow(ResultSet resultSet, int rownumber) throws SQLException {

                LoginBean userData=new LoginBean();
                userData.setUserId(resultSet.getInt(1));
                userData.setFirstName(resultSet.getString(2));
                userData.setLastName(resultSet.getString(3));
                userData.setGender(resultSet.getString(4));
                userData.setAge(resultSet.getInt(5));
                userData.setMail(resultSet.getString(6));
                userData.setPhoneNumber(resultSet.getString(7));
                userData.setUserRole(resultSet.getString(8));
                userData.setPassword(resultSet.getString(9));

                return userData;
            }
        });
    }

    public int updatePhoneNumberAndMail(LoginBean bean){
        return jdbcTemplate.update(updateQuery, bean.getMail(), bean.getPhoneNumber(), bean.getUserId());
    }



    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
