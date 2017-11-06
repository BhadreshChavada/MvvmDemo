package com.kioskdriver.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AMD21 on 28/9/17.
 */

public class LoginModel {

    String mobileNo, password, IMEIno, deviceToken;

    @SerializedName("status")
    boolean status;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIMEIno() {
        return IMEIno;
    }

    public void setIMEIno(String IMEIno) {
        this.IMEIno = IMEIno;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
