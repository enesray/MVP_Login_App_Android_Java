package com.raytech.mvp_login_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.raytech.mvp_login_app.MainActivity;
import com.raytech.mvp_login_app.R;
import com.raytech.mvp_login_app.model.UserModel;
import com.raytech.mvp_login_app.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginView { // LoginView.java interface'ine bağlanıyoruz. Bu sayede LoginView.java interface'indeki metotları override edebiliyoruz.
    private EditText mEmailEditText;       // email alanı için EditText değişkeni oluşturuluyor.
    private EditText mPasswordEditText;   // password alanı için EditText değişkeni oluşturuluyor.
    private Button mLoginButton;         // login butonu için Button değişkeni oluşturuluyor.
    private TextView mErrorTextView;    // hata mesajı için TextView değişkeni oluşturuluyor.
    private ProgressBar mProgressBar;  // progressbar için ProgressBar değişkeni oluşturuluyor.

    private LoginPresenter mPresenter; // LoginPresenter sınıfından mPresenter değişkeni oluşturuluyor. Bu sayede LoginPresenter sınıfındaki metotlara erişebiliyoruz.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailEditText = findViewById(R.id.et_email);        // email alanı için EditText değişkenine id ile bağlanıyoruz.
        mPasswordEditText = findViewById(R.id.et_password); // password alanı için EditText değişkenine id ile bağlanıyoruz.
        mLoginButton = findViewById(R.id.btn_login);       // login butonu için Button değişkenine id ile bağlanıyoruz.
        mErrorTextView = findViewById(R.id.tv_error);     // hata mesajı için TextView değişkenine id ile bağlanıyoruz.
        mProgressBar = findViewById(R.id.progress_bar);  // progressbar için ProgressBar değişkenine id ile bağlanıyoruz.

        mPresenter = new LoginPresenter(this); // LoginPresenter sınıfından mPresenter değişkenine LoginView.java interface'ine bağlanıyoruz. Bu sayede LoginView.java interface'indeki metotları override edebiliyoruz.
        mLoginButton.setOnClickListener(new View.OnClickListener() { // login butonuna tıklandığında yapılacak işlemler.
            @Override
            public void onClick(View view) {
                UserModel user = new UserModel(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());  // email ve password alanlarındaki veriler UserModel sınıfına gönderiliyor.
                mPresenter.login(user); // login işlemi için LoginPresenter sınıfındaki login() metotuna UserModel sınıfından user değişkeni gönderiliyor.
            }
        });
    }

    @Override
    public void showProgress() { // LoginView.java interface'indeki showProgress() metotu override ediliyor.
        mProgressBar.setVisibility(View.VISIBLE); // progressbar görünür hale getiriliyor.
    }

    @Override
    public void hideProgress() { // LoginView.java interface'indeki hideProgress() metotu override ediliyor.
        mProgressBar.setVisibility(View.GONE); // progressbar gizleniyor.
    }

    @Override
    public void setEmailError() { // LoginView.java interface'indeki setEmailError() metotu override ediliyor.
        mErrorTextView.setText("Email cannot be empty");    // email alanı boş olduğunda hata mesajı gösteriliyor.
    }

    @Override
    public void setPasswordError() { // LoginView.java interface'indeki setPasswordError() metotu override ediliyor.
          mErrorTextView.setText("Password cannot be empty"); // password alanı boş olduğunda hata mesajı gösteriliyor.
    }

    @Override
    public void navigateToHome() { // LoginView.java interface'indeki navigateToHome() metotu override ediliyor.
          startActivity(new Intent(this, MainActivity.class));  // MainActivity.java sınıfına yönlendiriliyor.
    }

}