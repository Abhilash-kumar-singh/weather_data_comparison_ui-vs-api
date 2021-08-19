package com.openweatherapi.utility;

public class StringToList {
    public String[] converter(String str){
        str= str.substring(1, str.length() - 1);
        String [] data= str.split(",");
        return data;
    }

}
