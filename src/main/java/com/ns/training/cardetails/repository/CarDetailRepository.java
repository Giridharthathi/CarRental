package com.ns.training.cardetails.repository;

import com.ns.training.cardetails.bean.CarDetailsBean;
import com.ns.training.cardetails.bean.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarDetailRepository implements IRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    private final String insert = " INSERT INTO cardetails  " +
            "(carName, model, seats, fuelCapacity, airbags, fuelType, carType, transmission, registrationNumber, " +
            "kmsDriven, price, rating, ownerMailId,city) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

    private final String selectQuery = " select * from CarDetails WHERE DataPresence =1";

    private final String selectParticularCar = "select * from CarDetails WHERE CarId = ?";

    private final String deleteQuery = " UPDATE CarDetails SET DataPresence=0 where CarId = ? ";

    private final String updateQuery = " UPDATE CarDetails SET carName=?, model=?, seats=?, fuelCapacity=?, airbags=?, fuelType=?, carType=?, " +
            "transmission=?,registrationNumber=?, kmsDriven=?, price=?, city=? where CarId = ? ";

    private final String selectCarByUserPreference ="SELECT * FROM cardetails WHERE carName=? or model=? or seats=? or fuelCapacity=? or fuelType=? or carType=? or " +
            "transmission=? or price=? or city=? and DataPresence = 1";

    private final String insertingOrderDetails = "INSERT INTO OrderDetails(CarId, UserId, Payment, FromDate,Days) VALUES(?,?,?,?,?)";

    private final String getCarUsedUsersNameByCarId = "select usersdata.FirstName,cardetails.carName,cardetails.model,OrderDetails.Payment, OrderDetails.FromDate, OrderDetails.Days \n" +
            "from usersdata,cardetails,OrderDetails where OrderDetails.carId =? and\n" +
            "OrderDetails.CarId=cardetails.CarId and OrderDetails.UserId=usersdata.UserId;";
    private final String getCarNamesByUserId = "select cardetails.carName,cardetails.model,OrderDetails.Payment, OrderDetails.FromDate, OrderDetails.Days,\n" +
            "cardetails.seats, cardetails.city\n" +
            "from usersdata,cardetails,OrderDetails where OrderDetails.userId = ? and\n" +
            "OrderDetails.CarId=cardetails.CarId and OrderDetails.UserId=usersdata.UserId";

    public List<CarDetailsBean> fetchAllCarRecords(){
        return jdbcTemplate.query(selectQuery,new RowMapper<CarDetailsBean>(){
            @Override
            public CarDetailsBean mapRow(ResultSet resultSet, int rownumber) throws SQLException {

                CarDetailsBean carData=new CarDetailsBean();

                carData.setCarId(resultSet.getInt(1));
                carData.setCarName(resultSet.getString(2));
                carData.setModel(resultSet.getInt(3));
                carData.setSeats(resultSet.getInt(4));
                carData.setFuelCapacity(resultSet.getString(5));
                carData.setAirBags(resultSet.getString(6));
                carData.setFuelType(resultSet.getString(7));
                carData.setCarType(resultSet.getString(8));
                carData.setTransmission(resultSet.getString(9));
                carData.setRegistrationNumber(resultSet.getString(10));
                carData.setKmsDriven(resultSet.getString(11));
                carData.setPrice(resultSet.getInt(12));
                carData.setRating(resultSet.getFloat(13));
                carData.setOwnerMailId(resultSet.getString(14));
                carData.setCity(resultSet.getString(15));

                return carData;
            }
        });
    }

    public List<CarDetailsBean> fetchParticularRecord(int carId){
        return jdbcTemplate.query(selectParticularCar,new Object[]{carId},new RowMapper<CarDetailsBean>(){
            @Override
            public CarDetailsBean mapRow(ResultSet resultSet, int rownumber) throws SQLException {

                CarDetailsBean carData=new CarDetailsBean();

                carData.setCarId(resultSet.getInt(1));
                carData.setCarName(resultSet.getString(2));
                carData.setModel(resultSet.getInt(3));
                carData.setSeats(resultSet.getInt(4));
                carData.setFuelCapacity(resultSet.getString(5));
                carData.setAirBags(resultSet.getString(6));
                carData.setFuelType(resultSet.getString(7));
                carData.setCarType(resultSet.getString(8));
                carData.setTransmission(resultSet.getString(9));
                carData.setRegistrationNumber(resultSet.getString(10));
                carData.setKmsDriven(resultSet.getString(11));
                carData.setPrice(resultSet.getInt(12));
                carData.setRating(resultSet.getFloat(13));
                carData.setOwnerMailId(resultSet.getString(14));
                carData.setCity(resultSet.getString(15));

                return carData;
            }
        });
    }
    public int deleteCar(int carId){

        return jdbcTemplate.update(deleteQuery, carId);
    }

    @Override
    public int insertCar(CarDetailsBean carBean) {
        return jdbcTemplate.update(insert,carBean.getCarName(), carBean.getModel(),carBean.getSeats(),
                carBean.getFuelCapacity(), carBean.getAirBags(),carBean.getFuelType(),carBean.getCarType(),
                carBean.getTransmission(), carBean.getRegistrationNumber(), carBean.getKmsDriven(),carBean.getPrice(),
                carBean.getRating(),carBean.getOwnerMailId(), carBean.getCity());
    }

    public int updateCar(CarDetailsBean carBean, int carId) {
        return jdbcTemplate.update(
    updateQuery,carBean.getCarName(),carBean.getModel(),carBean.getSeats(),carBean.getFuelCapacity(),carBean.getAirBags(), carBean.getFuelType(),
    carBean.getCarType(),carBean.getTransmission(),carBean.getRegistrationNumber(),carBean.getKmsDriven(),carBean.getPrice()
              ,carBean.getCity(),carId);
    }
    @Override
    public List<CarDetailsBean> fetchParticularRecordByUserPreferenceSearch(String searchName){
        return jdbcTemplate.query(selectCarByUserPreference,new Object[]{searchName, searchName, searchName, searchName, searchName, searchName, searchName, searchName, searchName},new RowMapper<CarDetailsBean>(){
            @Override
            public CarDetailsBean mapRow(ResultSet resultSet, int rownumber) throws SQLException {

                CarDetailsBean carData=new CarDetailsBean();

                carData.setCarId(resultSet.getInt(1));
                carData.setCarName(resultSet.getString(2));
                carData.setModel(resultSet.getInt(3));
                carData.setSeats(resultSet.getInt(4));
                carData.setFuelCapacity(resultSet.getString(5));
                carData.setAirBags(resultSet.getString(6));
                carData.setFuelType(resultSet.getString(7));
                carData.setCarType(resultSet.getString(8));
                carData.setTransmission(resultSet.getString(9));
                carData.setRegistrationNumber(resultSet.getString(10));
                carData.setKmsDriven(resultSet.getString(11));
                carData.setPrice(resultSet.getInt(12));
                carData.setRating(resultSet.getFloat(13));
                carData.setOwnerMailId(resultSet.getString(14));
                carData.setCity(resultSet.getString(15));
                return carData;
            }
        });
    }
    public int insertOrderDetails(OrderDetails orderDetails){
        return jdbcTemplate.update(insertingOrderDetails, orderDetails.getCarId(), orderDetails.getUserId(), orderDetails.getPayment()
        ,orderDetails.getFromDate(), orderDetails.getDays());
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //getting car history those who used  the car
    public List<OrderDetails> carUsedbyUsersByCarId(String carId){
        return jdbcTemplate.query(getCarUsedUsersNameByCarId,new Object[]{carId},new RowMapper<OrderDetails>(){
            @Override
            public OrderDetails mapRow(ResultSet resultSet, int rownumber) throws SQLException {
                OrderDetails carData=new OrderDetails();

                carData.setFirstname((resultSet.getString(1)));
                carData.setCarName(resultSet.getString(2));
                carData.setPayment(resultSet.getInt(4));
                carData.setFromDate(resultSet.getDate(5));
                carData.setDays(resultSet.getInt(6));


                return carData;
            }
        });
    }
    //getting user order history by user id
    public List<OrderDetails> userHistoryByUserId(String userId){
        return jdbcTemplate.query(getCarNamesByUserId,new Object[]{userId},new RowMapper<OrderDetails>(){
            @Override
            public OrderDetails mapRow(ResultSet resultSet, int rownumber) throws SQLException {
                OrderDetails carData=new OrderDetails();
                carData.setCarName((resultSet.getString(1)));
                carData.setModel(resultSet.getInt(2));
                carData.setPayment(resultSet.getInt(3));
                carData.setFromDate(resultSet.getDate(4));
                carData.setDays(resultSet.getInt(5));
                carData.setSeats(resultSet.getInt(6));
                carData.setCity(resultSet.getString(7));
                return carData;
            }
        });
    }
}
