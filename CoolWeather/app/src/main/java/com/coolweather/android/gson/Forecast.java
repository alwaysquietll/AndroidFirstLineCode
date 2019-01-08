package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    /*public String date;

    @SerializedName("tmp")
    public Temprature temprature;

    @SerializedName("cond")
    public More more;

    public class Temprature {
        public String max;
        public String min;
    }

    public class More {
        @SerializedName("txt_d")
        public String info;
    }*/
    @SerializedName("cond_txt_d")
    public String info;
    @SerializedName("tmp_max")
    public String maxTemprature;
    @SerializedName("tmp_min")
    public String minTemprature;

}
