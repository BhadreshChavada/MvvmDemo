package com.kioskdriver.BaseClass;

import android.content.Context;
import android.content.SharedPreferences;

import com.kioskdriver.R;


/**
 * Created by Bhadresh on 12/8/17.
 */

public class SharedPreference {

    Context context;
    SharedPreferences preferences;
    static SharedPreference msharedPreference;

    private SharedPreference(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(context.getString(R.string.preference), Context.MODE_PRIVATE);
    }

    public static SharedPreference getInstance(Context context) {

        if (msharedPreference == null) {
            msharedPreference = new SharedPreference(context);
        }
        return msharedPreference;
    }

    public void saveSharedPreference(String key, String Value) {

        preferences.edit().putString(key, Value).commit();
    }

    public String getSharedPreferece(String key) {
        return preferences.getString(key, "");
    }

    public void clearSharedPreferece(String key) {
        preferences.edit().remove(key).commit();
    }

    public void clearSharedPreferece() {
        preferences.edit().clear().commit();
    }
}
