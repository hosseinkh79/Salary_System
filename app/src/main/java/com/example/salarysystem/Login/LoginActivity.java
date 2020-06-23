package com.example.salarysystem.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.salarysystem.R;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    private TextView txtLogin;
    private ImageView imgClose;
    private CheckBox showPass;
    Button btnLogin;
    private EditText edtNational_code, edtPersnality_code;
    private LoginViewModel viewModel = new LoginViewModel();
    private CompositeDisposable disposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpViews();
    }

    private void login(){
        String national_code = edtNational_code.getText().toString();
        String persnality_code = edtPersnality_code.getText().toString();
        viewModel.login(national_code,persnality_code).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Message>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(Message message) {

//                        Log.i("LOG","onSuccess :"+message.getMessage());
                        if (!message.getMessage().equals("not found")){
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            intent.putExtra("id",message.getMessage());
                            startActivity(intent);
//
                        }else {
                            Toast.makeText(LoginActivity.this,"National_code or Persnality_code is incorrect", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOG","onError "+e.getMessage());

                    }
                });

    }
    private void setUpViews() {
        imgClose = findViewById(R.id.img_login_toolbarColse);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        edtNational_code = findViewById(R.id.edt_login_email);
        edtPersnality_code = findViewById(R.id.edt_login_pass);

        showPass = findViewById(R.id.ch_login_showPass);
        showPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    edtPersnality_code.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else {
                    edtPersnality_code.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });


        btnLogin = findViewById(R.id.btn_login_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
