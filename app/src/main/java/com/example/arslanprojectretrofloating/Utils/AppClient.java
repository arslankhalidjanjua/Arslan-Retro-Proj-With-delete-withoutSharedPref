package com.example.arslanprojectretrofloating.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Retrofit library that is used on the client side (Android) to make HTTP request
// Retrofit Instance
public class AppClient {

    //here is api from server
    private static final String BASE_URL="http://dummy.restapiexample.com/api/v1/";
    private static Retrofit retrofit=null;

    public static Retrofit getClient(){
        if(retrofit==null){ //conversion
            retrofit = new Retrofit.Builder()
                    .baseUrl( BASE_URL  )
                    .addConverterFactory( GsonConverterFactory.create() )
                    .build();
        }
        return  retrofit;
    }
}
