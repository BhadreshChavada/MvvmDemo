package com.kioskdriver.BaseClass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.kioskdriver.viewModel.RegistrationViewModel;

/**
 * Created by AMD21 on 28/9/17.
 */

public class BaseActivity extends AppCompatActivity {


    protected static final int CAMERA_REQUEST = 100;

    protected void callIntent(Class secondActivity) {
        CommonUtils.getInstance(this).callIntent(secondActivity);
    }


    protected void callIntent(Class secondActivity, String finish) {
        CommonUtils.getInstance(this).callIntent(secondActivity, finish);
    }

    protected void callIntent(String action, Context mContext) {
        Intent intent = new Intent(action);
        ((Activity) mContext).startActivityForResult(intent, CAMERA_REQUEST);
    }


    protected void callIntent(Class secondActivity, boolean value) {
        CommonUtils.getInstance(this).callIntent(secondActivity, value);
    }


    void callIntent(Class secondActivity, Bundle bundle) {
        CommonUtils.getInstance(this).callIntent(secondActivity, bundle);
    }


    protected void displyLog(String Tag, String Message) {
        CommonUtils.getInstance(this).displyLog(Tag, Message);
    }

    protected void displayToast(String Message) {
        CommonUtils.getInstance(this).displayToast(Message);
    }

    protected void callFragment(Fragment secondFragment, int frame) {
        CommonUtils.getInstance(this).callFragment(secondFragment, frame);
    }

    protected void callFragment(Fragment secondFragment, int frame, String tag) {
        CommonUtils.getInstance(this).callFragment(secondFragment, frame, tag);
    }

    protected boolean isNetworkAvailable(Context context) {
        return CommonUtils.getInstance(this).isNetworkAvailable(context);
    }

    protected void displayProgressDialog(boolean active, Activity activity) {
        CommonUtils.getInstance(this).displayProgressDialog(active, activity);
    }

    protected void chooseDate(final TextView textView, final BaseDate dateResponse) {
        CommonUtils.getInstance(this).chooseDate(textView, dateResponse);
    }

    protected void saveSharedpreference(String key, String value) {
        CommonUtils.getInstance(this).saveSharedpreference(key, value);
    }

    protected String getSharefpreference(String key) {
        return CommonUtils.getInstance(this).getSharefpreference(key);
    }

    protected void deleteSharedpreference(String key) {
        CommonUtils.getInstance(this).deleteSharedpreference(key);
    }

    protected void clearSharedpreference() {
        CommonUtils.getInstance(this).clearSharedpreference();
    }

    protected void hideSoftKeyboard(EditText editTextUsername) {
        CommonUtils.getInstance(this).hideSoftKeyboard(editTextUsername);
    }

    protected void chooseTime(final TextView textView, final BaseTime dateResponse) {
        CommonUtils.getInstance(this).chooseTime(textView, dateResponse);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            imageView.setImageBitmap(photo);
            RegistrationViewModel.getImageData(data);

        }
    }
}
