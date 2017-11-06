package com.kioskdriver.BaseClass;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.kioskdriver.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by AMD21 on 28/9/17.
 */

public class CommonUtils {

    ProgressDialog progressDialog;
    Context context;
    static CommonUtils mCommonUtils;

    private CommonUtils(Context context) {
        this.context = context;
    }

    public static CommonUtils getInstance(Context context) {

        if (mCommonUtils == null) {
            mCommonUtils = new CommonUtils(context);
        }
        return mCommonUtils;
    }


    protected void callIntent(Class secondActivity) {

        Intent intent = new Intent(context, secondActivity);
        context.startActivity(intent);
    }


    protected void callIntent(Class secondActivity, String finish) {

        Intent intent = new Intent(context, secondActivity);
        ((Activity)context).finish();
        context.startActivity(intent);
    }


    protected void callIntent(Class secondActivity, boolean value) {

        Intent intent = new Intent(context, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        ((Activity)context).finish();
    }


    void callIntent(Class secondActivity, Bundle bundle) {

        Intent intent = new Intent(context, secondActivity);
        intent.putExtra("Bundle", bundle);
        context.startActivity(intent);
    }


    protected void displyLog(String Tag, String Message) {
        Log.d(Tag, Message);
    }

    protected void displayToast(String Message) {
        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
    }

    protected void callFragment(Fragment secondFragment, int frame) {
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(frame, secondFragment).addToBackStack(null).commit();
    }

    protected void callFragment(Fragment secondFragment, int frame, String tag) {
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(frame, secondFragment).commit();
    }

    protected boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void displayProgressDialog(boolean active,Activity activity) {
        if (active) showProgressDialog(activity, null, context.getString(R.string.pleaseWait));
        else hideProgressDialog();
    }

    protected void hideProgressDialog() {
//        progressDialog.dismiss();

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if ((progressDialog != null) && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }
        }, 2000);
    }

    private void showProgressDialog(Activity BaseActivity, String title, String message) {
        progressDialog = new ProgressDialog(BaseActivity);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    protected void chooseDate(final TextView textView, final BaseDate dateResponse) {


        Calendar newCalendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String date = simpleDateFormat.format(newDate.getTime());
                dateResponse.onDateSelect(date, textView);


            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(new Date().getTime());
        datePickerDialog.show();
    }

    protected void chooseTime(final TextView textView, final BaseTime dateResponse) {

        Calendar today = Calendar.getInstance();
        TimePickerDialog toTimePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                if (selectedMinute == 0) {
                    dateResponse.onTimeSelect(selectedHour + ":" + selectedMinute + "0", textView);

                } else if (selectedMinute > 0 && selectedMinute < 10) {

                    dateResponse.onTimeSelect(selectedHour + ":0" + selectedMinute, textView);
                } else {
                    dateResponse.onTimeSelect(selectedHour + ":" + selectedMinute, textView);
                }
            }
        }, today.get(Calendar.HOUR_OF_DAY), today.get(Calendar.MINUTE), true);
        toTimePickerDialog.show();

    }

    protected void saveSharedpreference(String key, String value) {
        SharedPreference.getInstance(context).saveSharedPreference(key, value);
    }

    protected String getSharefpreference(String key) {
        return SharedPreference.getInstance(context).getSharedPreferece(key);

    }

    protected void deleteSharedpreference(String key) {
        SharedPreference.getInstance(context).clearSharedPreferece(key);

    }

    protected void clearSharedpreference() {
        SharedPreference.getInstance(context).clearSharedPreferece();
    }

    protected void hideSoftKeyboard(EditText editTextUsername) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editTextUsername.getWindowToken(), 0);
    }

}
