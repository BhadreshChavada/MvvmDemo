package com.kioskdriver.model.CarType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by AMD21 on 6/10/17.
 */

public class Car {

    @SerializedName("carType")
    @Expose
    private String carType;
    @SerializedName("carTypeId")
    @Expose
    private String carTypeId;
    @SerializedName("carModel")
    @Expose
    private List<CarModel> carModel = null;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(String carTypeId) {
        this.carTypeId = carTypeId;
    }

    public List<CarModel> getCarModel() {
        return carModel;
    }

    public void setCarModel(List<CarModel> carModel) {
        this.carModel = carModel;
    }
}
