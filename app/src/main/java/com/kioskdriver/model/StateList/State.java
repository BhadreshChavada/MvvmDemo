package com.kioskdriver.model.StateList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by AMD21 on 7/10/17.
 */

public class State {
    @SerializedName("StateName")
    @Expose
    private String stateName;
    @SerializedName("stateId")
    @Expose
    private String stateId;
    @SerializedName("City")
    @Expose
    private List<City> city = null;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
}
