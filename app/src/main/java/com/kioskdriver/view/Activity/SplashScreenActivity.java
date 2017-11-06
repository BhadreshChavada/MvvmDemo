package com.kioskdriver.view.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kioskdriver.BaseClass.BaseActivity;
import com.kioskdriver.BaseClass.HandlerResponse;
import com.kioskdriver.R;
import com.kioskdriver.viewModel.SplashScreenViewModel;

/**
 * Created by AMD21 on 28/9/17.
 */

public class SplashScreenActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splushscreen);


        SplashScreenViewModel mViewModel = new SplashScreenViewModel(this);
        mViewModel.setHandler(new HandlerResponse() {
            @Override
            public void onSuccess() {
                callIntent(LoginActivity.class,"finish");
            }
        });

    }
}
