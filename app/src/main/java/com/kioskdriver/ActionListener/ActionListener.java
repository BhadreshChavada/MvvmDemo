package com.kioskdriver.ActionListener;

import android.app.Activity;

import com.kioskdriver.data.APIResponse;
import com.kioskdriver.data.ServiceRepository;
import com.kioskdriver.model.LoginModel;
import com.kioskdriver.model.RegisterModel;

import java.util.HashMap;

import Utils.WebServiceString;
import data.Injection;
import retrofit2.Call;
import retrofit2.Response;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by AMD21 on 12/9/17.
 */

public class ActionListener implements APIResponse<String> {
    static ActionListener mActionListener;
    Activity context;

    private ActionListener(Activity context) {
        this.context = context;
    }

    public static ActionListener getInstance(Activity context) {

        if (mActionListener == null) {
            mActionListener = new ActionListener(context);
        }
        return mActionListener;
    }


    public void clickListener(LoginModel loginModel, final Result result) {

        if (loginModel != null) {
            if (loginModel.getMobileNo().equals("") || loginModel.getMobileNo().equals(null)) {
                result.failed("Mobile no. Empty");
                return;
            } else if (loginModel.getPassword().equals("") || loginModel.getPassword().equals(null)) {
                result.failed("Password Empty");
                return;
            } else {

                ServiceRepository mServiceRepository = checkNotNull(Injection.Repository(context));

                HashMap<String,String> map = new HashMap<>();

                mServiceRepository.commanService(map, WebServiceString.LoginService,this,1,context,result,"post");


            }
        } else {
            result.failed("Null Value");
        }

    }


    public void clickListener(RegisterModel Model, final Result result) {

        if (Model != null) {


            ServiceRepository mServiceRepository = checkNotNull(Injection.Repository(context));
            mServiceRepository.commanService(new HashMap<String, String>(),WebServiceString.registrationService,this,2,context,result,"get");

        } else {
            result.failed("Null Value");
        }

    }


    @Override
    public void onSuccess(Call<String> call, Response<String> response, int responseCode, Result result) {
        switch (responseCode) {
            case 1:
                result.success();
                break;

            case 2:
                result.success();
                break;
        }
    }

    @Override
    public void onSuccess(Call<String> call, Response<String> response, int responseCode) {

    }

    @Override
    public void onFailure(Call<String> call, Throwable t, int responseCode, Result result) {

        switch (responseCode) {
            case 1:
                result.failed("TryAgain");
                break;
            case 2:
                result.failed("TryAgain");
                break;

        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t, int responseCode) {

    }


}

