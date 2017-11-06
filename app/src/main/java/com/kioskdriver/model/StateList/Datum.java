package com.kioskdriver.model.StateList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by AMD21 on 7/10/17.
 */

public class Datum {

    @SerializedName("State")
    @Expose
    private List<State> state = null;

    public List<State> getState() {
        return state;
    }

    public void setState(List<State> state) {
        this.state = state;
    }

}
