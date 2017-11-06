package com.kioskdriver.data;

import com.kioskdriver.ActionListener.Result;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Bhadresh on 1/6/17.
 */

public interface APIResponse<T> {

    void onSuccess(Call<T> call, Response<T> response, int responseCode, Result result);

    void onSuccess(Call<T> call, Response<T> response, int responseCode);

    void onFailure(Call<T> call, Throwable t,int responseCode,Result result);

    void onFailure(Call<T> call, Throwable t,int responseCode);
}
