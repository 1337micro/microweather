package org.lctmicro.weather.retrofit;

import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;


public interface WeatherService {
    @GET("/data/2.5/weather")
    public Call<ResponseBody> getWeatherByCity(
            @Query("q") String city, //city,country
            @Query("appid") String appid
    );
}
