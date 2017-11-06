package com.kioskdriver.model.CarType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by AMD21 on 6/10/17.
 */

public class CarModel {


    @SerializedName("carModelName")
    @Expose
    private String carModelName;
    @SerializedName("carModelId")
    @Expose
    private String carModelId;

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(String carModelId) {
        this.carModelId = carModelId;
    }
}
