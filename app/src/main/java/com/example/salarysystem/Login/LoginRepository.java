package com.example.salarysystem.Login;

import com.example.salarysystem.Model.PersonModel;

import java.util.List;

import io.reactivex.Single;

public class LoginRepository implements LoginDataSource {
    private LoginApiDataSource apiDataSource = new LoginApiDataSource();
    @Override
    public Single<Message> login(String national_code, String persnality_code) {
        return apiDataSource.login(national_code,persnality_code);
    }

    @Override
    public Single<List<PersonModel>> getPersonInfo(String id) {
        return apiDataSource.getPersonInfo(id);
    }
}
