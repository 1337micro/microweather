
package org.lctmicro.weather.api.generated;

import com.squareup.okhttp.ResponseBody;
import org.lctmicro.weather.retrofit.WeatherService;
import org.springframework.stereotype.Component;
import retrofit.Call;
import retrofit.Retrofit;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Resource class containing the custom logic. Please put your logic here!
 */
@Component("apiWeatherResource")
@Singleton
public class DefaultWeatherResource implements org.lctmicro.weather.api.generated.WeatherResource
{
	/* GET / */
	@Override
	public Response get(final YaasAwareParameters yaasAware)
	{
		//Should not call this...
		return Response.status(500)
				.entity("You need to specify a city e.g. /weather/montreal").build();
	}
	/* GET /{city} */
	@Override
	public Response getByCity(final YaasAwareParameters yaasAware, final java.lang.String city)
	{
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.openweathermap.org")
				.build();
		WeatherService openWeather = retrofit.create(WeatherService.class);

		Call<ResponseBody> weatherData = openWeather.getWeatherByCity(city, "2dfe75ed5014e5f67ab7121e782114a1");
		try {
			ResponseBody body = weatherData
					.execute()
					.body();

			return Response.ok()
					.entity(body.string()).build();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.serverError()
				.entity(new Weather()).build();
	}

	@Override
	public Response putByCity(String city, Weather weather) {
		return null;
	}

	@Override
	public Response deleteByCity(String city) {
		return null;
	}
}
