package com.example.salarysystem.Login;
import com.example.salarysystem.MainApi.ApiProvider;
import com.example.salarysystem.MainApi.ApiService;
import com.example.salarysystem.Model.PersonModel;

import java.util.List;

import io.reactivex.Single;

public class LoginApiDataSource implements LoginDataSource {
    private ApiService apiService = ApiProvider.apiProvider();
    @Override
    public Single<Message> login(String national_code,String persnality_code) {
        return apiService.login(national_code,persnality_code);
    }

    @Override
    public Single<List<PersonModel>> getPersonInfo(String id) {
        return apiService.getPersonInfo(id);
    }
}
