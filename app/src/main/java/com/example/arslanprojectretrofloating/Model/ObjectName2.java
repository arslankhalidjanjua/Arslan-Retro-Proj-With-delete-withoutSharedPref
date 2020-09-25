package com.example.arslanprojectretrofloating.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ObjectName2 {
    @SerializedName("status")
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<LoginObject> getData() {
        return data;
    }

    public void setData(ArrayList<LoginObject> data) {
        this.data = data;
    }

    @SerializedName("data")
    ArrayList<LoginObject> data;

}
