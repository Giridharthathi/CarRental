package com.ns.training.registration.bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RegistrationBean {

    private String userRole="user";
    private String mail;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String phoneNumber;
    private String password;
    private String confirmPassword;

    public RegistrationBean(String userRole, String mail, String firstName, String lastName, String gender, int age, String phoneNumber, String password, String confirmPassword) {
        this.userRole = userRole;
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public RegistrationBean() {
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String role) {
        role = "user";
        this.userRole = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}