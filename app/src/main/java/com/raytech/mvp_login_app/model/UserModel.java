package com.raytech.mvp_login_app.model;

public class UserModel {
    private String email; //email alanı
    private String password; //password alanı

    public UserModel(String email, String password) { //constructor ile email ve password değerleri alınıyor.
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    } //getEmail() metodu ile email değeri döndürülüyor.

    public String getPassword() {
        return password;
    }   //getPassword() metodu ile password değeri döndürülüyor.
}
