package com.example.salarysystem.MainApi;



import com.example.salarysystem.Login.Message;
import com.example.salarysystem.Model.PersonModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {


    @FormUrlEncoded
    @POST("readperson.php")
    Single<List<PersonModel>> getPersonInfo(@Field("person_id") String person_id);

//    @GET("readperson.php")
//    Single<List<PersonModel>> getProducts();

    @FormUrlEncoded
    @POST("login.php")
    Single<Message> login(@Field("national_code") String national_code, @Field("persnality_code") String persnality_code);
}
