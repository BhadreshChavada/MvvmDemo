package com.kioskdriver.data.local;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kioskdriver.ActionListener.Result;
import com.kioskdriver.BaseClass.CommonUtils;
import com.kioskdriver.R;
import com.kioskdriver.data.APIResponse;
import com.kioskdriver.data.APIService;
import com.kioskdriver.data.DataSource;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

;

/**
 * Created by Bhadresh on 1/6/17.
 */

public class LocalDataSource implements DataSource {

    private static final String TAG = LocalDataSource.class.getSimpleName();
    private static LocalDataSource INSTANCE;
    private static ProgressDialog progressDialog;
    private Context mContext;

    // Prevent direct instantiation.
    private LocalDataSource(@NonNull Context context) {
        checkNotNull(mContext = context);
    }

    public static LocalDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(context);
        }
        return INSTANCE;
    }


    //TODO SetupRetrofit Method here
    public APIService setupRetrofit() {
        APIService mRestService = null;

        if (mRestService == null) {
            final OkHttpClient client = new OkHttpClient
                    .Builder()
                    .addInterceptor(new LocalIntercepter(mContext))
                    .build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            final Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .baseUrl(mContext.getString(R.string.api_base))
                    .client(client)
                    .build();

            mRestService = retrofit.create(APIService.class);
        }
        return mRestService;
    }


    @Override
    public void commanService(HashMap<String, String> map, String subURL, final APIResponse apiResponse, final int requestCode, final Activity context, final Result mResult, String method) {


        Call<String> apiCall;
        if (method.equalsIgnoreCase("post"))
            apiCall = setupRetrofit().postCall(subURL, map);
        else
            apiCall = setupRetrofit().getCall(subURL, map);

        Log.d("url", apiCall.request().url().toString());
        apiCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                CommonUtils.getInstance(context).displayProgressDialog(false, context);
                apiResponse.onSuccess(call, response, requestCode, mResult);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                CommonUtils.getInstance(context).displayProgressDialog(false, context);
                apiResponse.onFailure(call, t, requestCode, mResult);
            }
        });

    }

    @Override
    public void commanService(HashMap<String, String> map, String subURL, final APIResponse apiResponse, final int requestCode, final Activity context, String method) {
        Call<String> apiCall;
        if (method.equalsIgnoreCase("post"))
            apiCall = setupRetrofit().postCall(subURL, map);
        else
            apiCall = setupRetrofit().getCall(subURL, map);

        Log.d("url", apiCall.request().url().toString());
        apiCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                CommonUtils.getInstance(context).displayProgressDialog(false, context);
                apiResponse.onSuccess(call, response, requestCode);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                CommonUtils.getInstance(context).displayProgressDialog(false, context);
                apiResponse.onFailure(call, t, requestCode);
            }
        });
    }

    @Override
    public void commanService(String subURL, final APIResponse apiResponse, final int requestCode, final Activity context, final Result mResult, String method) {
        Call<String> apiCall;
        if (method.equalsIgnoreCase("post"))
            apiCall = setupRetrofit().postCall(subURL);
        else
            apiCall = setupRetrofit().getCall(subURL);
        Log.d("url", apiCall.request().url().toString());
        apiCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                CommonUtils.getInstance(context).displayProgressDialog(false, context);
                apiResponse.onSuccess(call, response, requestCode, mResult);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                CommonUtils.getInstance(context).displayProgressDialog(false, context);
                apiResponse.onFailure(call, t, requestCode, mResult);
            }
        });

    }

    @Override
    public void commanService(String subURL, final APIResponse apiResponse, final int requestCode, final Activity context, String method) {
        Call<String> apiCall;
        if (method.equalsIgnoreCase("post"))
            apiCall = setupRetrofit().postCall(subURL);
        else
            apiCall = setupRetrofit().getCall(subURL);

        Log.d("url", apiCall.request().url().toString());
        apiCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                CommonUtils.getInstance(context).displayProgressDialog(false, context);
                apiResponse.onSuccess(call, response, requestCode);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                CommonUtils.getInstance(context).displayProgressDialog(false, context);
                apiResponse.onFailure(call, t, requestCode);
            }
        });

    }


}
