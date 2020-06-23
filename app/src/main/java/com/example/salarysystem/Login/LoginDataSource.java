package com.example.salarysystem.Login;

import com.example.salarysystem.Model.PersonModel;

import java.util.List;

import io.reactivex.Single;

public interface LoginDataSource {

    Single<Message> login(String national_code, String persnality_code);
    Single<List<PersonModel>> getPersonInfo(String id);

}
