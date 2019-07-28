package com.mojuk.daddyscar;

public class ListItem {

    private String[] mData;
    private Double[] dData;

    public ListItem(String[] data ){
        mData = data;
    }


    public ListItem(String id, String pw, String email, String taxi_number, double boarding_location_lat, double boarding_location_lon, double real_time_location_lat, double real_time_location_lon){

        mData = new String[4];
        dData = new Double[4];
        mData[0] = id;
        mData[1] = pw;
        mData[2] = email;
        mData[3] = taxi_number;

        dData = new Double[4];
        dData[0] = boarding_location_lat;
        dData[1] = boarding_location_lon;
        dData[2] = real_time_location_lat;
        dData[3] = real_time_location_lon;

    }

    public String[] getData(){
        return mData;
    }

    public String getData(int index){
        return mData[index];
    }

    public void setData(String[] data){
        mData = data;
    }



    public Double[] dgetData(){
        return dData;
    }

    public Double dgetData(int index){
        return dData[index];
    }

    public void dsetData(Double[] data){
        dData = data;
    }
}
