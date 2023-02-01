package com.raytech.mvp_login_app.view;

public interface LoginView { //bu interface ile LoginPresenter.java ile LoginActivity.java arasında bağlantı kuruluyor.
    void showProgress();  //showProgress() gösterilecek olan progressbar'ın gösterilmesini sağlıyor.
    void hideProgress(); //hideProgress() gösterilecek olan progressbar'ın gizlenmesini sağlıyor.
    void setEmailError(); // setEmailError() email alanının boş olması durumunda hata mesajı gösterilmesini sağlıyor.
    void setPasswordError(); // setPasswordError() password alanının boş olması durumunda hata mesajı gösterilmesini sağlıyor.
    void navigateToHome(); // navigateToHome() login işlemi başarılı olduğunda MainActivity'e yönlendirilmesini sağlıyor.
}
