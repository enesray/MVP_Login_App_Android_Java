package com.raytech.mvp_login_app.presenter;

import com.raytech.mvp_login_app.model.UserModel;
import com.raytech.mvp_login_app.view.LoginView;

public class LoginPresenter { // bu sınıf ile LoginView.java ile LoginActivity.java arasında bağlantı kuruluyor.

    private LoginView view; // view değişkeni ile LoginView.java interface'ine bağlanıyoruz.

    public LoginPresenter(LoginView view) {  // LoginPresenter sınıfının constructor'ı oluşturuluyor. Bu sayede LoginView.java interface'ine bağlanıyoruz.
        this.view = view;
    }

    public void login(UserModel user) { // login() metodu ile login işlemleri yapılıyor UserModel sınıfından user değişkeni ile email ve password bilgileri alınıyor.
        if (user.getEmail().isEmpty()) {  // email alanı boş ise setEmailError() metodu ile hata mesajı gösteriliyor.
            view.setEmailError(); // setEmailError() metodu ile hata mesajı gösteriliyor.
            return; // return ile işlem sonlandırılıyor ve aşağıdaki kodlar çalışmıyor.
        }

        if (user.getPassword().isEmpty()) { // password alanı boş ise setPasswordError() metodu ile hata mesajı gösteriliyor.
            view.setPasswordError(); // setPasswordError() metodu ile hata mesajı gösteriliyor.
            return; // return ile işlem sonlandırılıyor ve aşağıdaki kodlar çalışmıyor.
        }

        view.showProgress();  // showProgress() metodu ile progressbar gösteriliyor,fakat burada progressbar gösterilmiyor. Çünkü LoginActivity.java sınıfında bu metodu override etmedik.

        //   Burada login işlemleri yapılacak. Fakat burada login işlemleri yapılmıyor. Çünkü LoginActivity.java sınıfında bu metodu override etmedik.

        view.hideProgress(); // hideProgress() metodu ile progressbar gizleniyor,fakat burada progressbar gizlenmiyor. Çünkü LoginActivity.java sınıfında bu metodu override etmedik.
        view.navigateToHome(); // navigateToHome() metodu ile MainActivity'e yönlendiriliyor.
    }
}
