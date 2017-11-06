package com.kioskdriver.view.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.kioskdriver.BaseClass.BaseActivity;
import com.kioskdriver.R;
import com.kioskdriver.databinding.ActivityRegistrationBinding;
import com.kioskdriver.viewModel.RegistrationViewModel;

/**
 * Created by AMD21 on 3/10/17.
 */

public class RegistrationActivity extends BaseActivity {

    private ActivityRegistrationBinding mBinding;
    private RegistrationViewModel registrationViewModel;
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
    }

    private void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        registrationViewModel = new RegistrationViewModel(this, mBinding);
        mBinding.setMainViewModel(registrationViewModel);


    }

    public void launchActivity(Class mClass) {
        callIntent(mClass);
    }


    public void CheckSelfPermission(Context mContext) {
        // Assume thisActivity is the current activity
//        int permissionCheck = ContextCompat.checkSelfPermission(RegistrationActivity.this,
//                Manifest.permission.CAMERA);

        if (ContextCompat.checkSelfPermission(mContext,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity)mContext,
                    Manifest.permission.CAMERA)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions((Activity)mContext,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }


        } else {
            captureImage(mContext);
        }

    }

    private void captureImage(Context mContext) {
        callIntent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE,mContext);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    captureImage(getApplicationContext());

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }





}
