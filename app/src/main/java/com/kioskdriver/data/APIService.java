package com.kioskdriver.data;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Bhadresh on 15/4/17.
 */

public interface APIService {


    @GET
    Call<String> getCall(@Url String subUrl, @QueryMap(encoded = true) HashMap<String, String> map);

    @GET
    Call<String> getCall(@Url String subUrl);

    @POST
    Call<String> postCall(@Url String subUrl, @QueryMap(encoded = true) HashMap<String, String> map);

    @POST
    Call<String> postCall(@Url String subUrl);

}
