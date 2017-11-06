package com.kioskdriver.BaseClass;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by AMD21 on 28/9/17.
 */

public class BaseFragment extends Fragment {

    protected void callIntent(Class secondActivity) {
        CommonUtils.getInstance(getActivity()).callIntent(secondActivity);
    }


    protected void callIntent(Class secondActivity, String finish) {
        CommonUtils.getInstance(getActivity()).callIntent(secondActivity, finish);
    }


    protected void callIntent(Class secondActivity, boolean value) {
        CommonUtils.getInstance(getActivity()).callIntent(secondActivity, value);
    }


    void callIntent(Class secondActivity, Bundle bundle) {
        CommonUtils.getInstance(getActivity()).callIntent(secondActivity, bundle);
    }


    protected void displyLog(String Tag, String Message) {
        CommonUtils.getInstance(getActivity()).displyLog(Tag, Message);
    }

    protected void displayToast(String Message) {
        CommonUtils.getInstance(getActivity()).displayToast(Message);
    }

    protected void callFragment(Fragment secondFragment, int frame) {
        CommonUtils.getInstance(getActivity()).callFragment(secondFragment, frame);
    }

    protected void callFragment(Fragment secondFragment, int frame, String tag) {
        CommonUtils.getInstance(getActivity()).callFragment(secondFragment, frame, tag);
    }

    protected boolean isNetworkAvailable(Context context) {
        return CommonUtils.getInstance(getActivity()).isNetworkAvailable(context);
    }

    protected void displayProgressDialog(boolean active, Activity activity) {
        CommonUtils.getInstance(getActivity()).displayProgressDialog(active,activity);
    }

    protected void chooseDate(final TextView textView, final BaseDate dateResponse) {
        CommonUtils.getInstance(getActivity()).chooseDate(textView, dateResponse);
    }

    protected void saveSharedpreference(String key, String value) {
        CommonUtils.getInstance(getActivity()).saveSharedpreference(key, value);
    }

    protected String getSharefpreference(String key) {
        return CommonUtils.getInstance(getActivity()).getSharefpreference(key);
    }

    protected void deleteSharedpreference(String key) {
        CommonUtils.getInstance(getActivity()).deleteSharedpreference(key);
    }

    protected void clearSharedpreference() {
        CommonUtils.getInstance(getActivity()).clearSharedpreference();
    }

    protected void hideSoftKeyboard(EditText editTextUsername) {
        CommonUtils.getInstance(getActivity()).hideSoftKeyboard(editTextUsername);
    }
}
