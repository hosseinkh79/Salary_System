package com.example.salarysystem.Login;

import com.example.salarysystem.Model.PersonModel;

import java.util.List;

import io.reactivex.Single;

public class LoginViewModel {
    private LoginRepository loginRepository = new LoginRepository();
    public Single<Message> login(String national_code,String persnality_code){
        return loginRepository.login(national_code,persnality_code);
    }

    public Single<List<PersonModel>> getPersonInfo(String id){
        return loginRepository.getPersonInfo(id);
    }
}
