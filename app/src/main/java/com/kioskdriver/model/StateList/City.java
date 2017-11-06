package com.kioskdriver.model.StateList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by AMD21 on 7/10/17.
 */

public class City {

    @SerializedName("CityName")
    @Expose
    private String cityName;
    @SerializedName("cityId")
    @Expose
    private String cityId;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
