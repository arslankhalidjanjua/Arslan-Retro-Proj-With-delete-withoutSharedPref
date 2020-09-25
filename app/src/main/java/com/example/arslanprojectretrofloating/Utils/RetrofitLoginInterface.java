package com.example.arslanprojectretrofloating.Utils;

import com.example.arslanprojectretrofloating.Model.Data;
import com.example.arslanprojectretrofloating.Model.Example;
import com.example.arslanprojectretrofloating.Model.ObjectName2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitLoginInterface {

        //api call
        //call is used by retrofit to de-serialize data

        //from here we get the interface and employees is passed
        @GET("employees")
        Call <ObjectName2> arrayList();   //endpoints

        //interface method post and then create its constructor
        @POST("create")
        Call<Example> createPost(@Body Data data);

        //https://stackoverflow.com/questions/26110357/android-retrofit-dynamic-endpoint-url
        //using above delete is used
        @DELETE("delete/{rep}")
        Call<Example> deletePost(@Path("rep") String listReposUrl);

        //The endpoints are defined inside of an interface
        // using special retrofit annotations to encode details about the parameters and request method.

}
