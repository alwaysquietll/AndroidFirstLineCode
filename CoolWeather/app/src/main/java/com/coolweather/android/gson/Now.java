package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

public class Now {

    @SerializedName("cond_txt")
    public String weather;

    @SerializedName("tmp")
    public String temperature;
}
