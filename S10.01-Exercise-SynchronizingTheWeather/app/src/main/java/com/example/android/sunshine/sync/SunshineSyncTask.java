package com.example.android.sunshine.sync;

//  DONE (1) Create a class called SunshineSyncTask

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;


public class SunshineSyncTask{

    synchronized public static void syncWeather(Context context){
        try {
            URL weatherURL = NetworkUtils.getUrl(context);
            String weatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherURL);
            ContentValues[] weatherValues = OpenWeatherJsonUtils.getWeatherContentValuesFromJson(context, weatherResponse);
            if(weatherValues != null && weatherValues.length > 0){
                ContentResolver contentResolver = context.getContentResolver();

                contentResolver.delete(
                        WeatherContract.WeatherEntry.CONTENT_URI,
                        null,
                        null
                );
                contentResolver.bulkInsert(WeatherContract.WeatherEntry.CONTENT_URI, weatherValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//  DONE (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
//      DONE (3) Within syncWeather, fetch new weather data
//      DONE (4) If we have valid results, delete the old data and insert the new