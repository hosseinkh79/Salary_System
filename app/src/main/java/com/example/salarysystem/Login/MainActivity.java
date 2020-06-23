package com.example.salarysystem.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salarysystem.Model.PersonModel;
import com.example.salarysystem.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView txtId;
    private LoginViewModel viewModel = new LoginViewModel();
    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = findViewById(R.id.textViewId);
        login();
    }
    private void login() {
        String id = getIntent().getStringExtra("id");
        viewModel.getPersonInfo(id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new SingleObserver<List<PersonModel>>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onSuccess(List<PersonModel> personModels) {
                       for (int i = 0; i <personModels.size() ; i++) {
                           Log.i("LOG","onSuccess "+personModels.get(i).getId()+" "
                                   +personModels.get(i).getName()+" "
                                   +personModels.get(i).getJobStatus()+" "
                                   +personModels.get(i).getFstatus());

                           txtId.setText("id : "+personModels.get(i).getId()+" \n"
                                   +"Name : "+personModels.get(i).getName()+"\n "
                                   +"Job : "+personModels.get(i).getJobStatus()+"\n "
                                   +"Fstatus : "+personModels.get(i).getFstatus());

                       }

                   }

                   @Override
                   public void onError(Throwable e) {
                       Log.i("LOG","onError "+e.getMessage());
                   }
               });
    }

}
