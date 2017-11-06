package com.kioskdriver.data;

import android.app.Activity;

import com.kioskdriver.ActionListener.Result;

import java.util.HashMap;

/**
 * Created by AMD21 on 27/9/17.
 */

public interface DataSource {


    void commanService(HashMap<String, String> map, String subURL, APIResponse apiResponse, int requestCode, Activity context,Result mResult,String method);

    void commanService(HashMap<String, String> map, String subURL, APIResponse apiResponse, int requestCode, Activity context,String method);

    void commanService(String subURL, APIResponse apiResponse, int requestCode, Activity context,Result mResult,String method);

    void commanService(String subURL, APIResponse apiResponse, int requestCode, Activity context,String method);


}
