package com.kioskdriver.viewModel;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.kioskdriver.BaseClass.HandlerResponse;
import com.kioskdriver.view.Activity.SplashScreenActivity;

/**
 * Created by AMD21 on 28/9/17.
 */

public class SplashScreenViewModel {

    Context context;
    long scheduleTime = 5000;

    public SplashScreenViewModel(@NonNull SplashScreenActivity context) {

        this.context = context;

    }

    public void setHandler(final HandlerResponse mhandlerResponse) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                mhandlerResponse.onSuccess();

            }
        }, scheduleTime);
    }


}
