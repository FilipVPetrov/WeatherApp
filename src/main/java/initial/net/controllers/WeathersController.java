package initial.net.controllers;

import initial.net.beans.WeatherFilterBean;
import initial.net.models.Weather;
import initial.net.utils.WeatherUtil;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/weathers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WeathersController {

	private WeatherUtil weatherUtil = new WeatherUtil();
	
	@GET
	public List<Weather> getWeathers(@BeanParam WeatherFilterBean filterBean){
		System.out.println("QueryParam : " + filterBean.getCity() +" : "+ filterBean.getStartTemperature() +
				" : " + filterBean.getEndTemperature());
		List<Weather> list = null;
		synchronized(weatherUtil){
			if(filterBean.getCity() != null){
				list = weatherUtil.findByCity(filterBean.getCity());
			}
			else if(filterBean.getStartTemperature() != null && filterBean.getEndTemperature() != null){
				list = weatherUtil.findByTemperatureRange(filterBean.getStartTemperature(), filterBean.getEndTemperature());
			}
			else{
				list = weatherUtil.getAllWeathers(); 	
			}
		}
		return list;
	}
	
//	@GET
//	public List<Weather> getWeathers(@QueryParam("city") String city,
//			@QueryParam("startT") Double startTemperature,
//			@QueryParam("endT") Double endTemperature) {
//		System.out.println("QueryParam : " + city + " : " + startTemperature
//				+ " : " + endTemperature);
//		List<Weather> list = null;
//		synchronized (weatherUtil) {
//			if (city != null) {
//				list = weatherUtil.findByCity(city);
//			} else if (startTemperature != null && endTemperature != null) {
//				list = weatherUtil.findByTemperatureRange(startTemperature,
//						endTemperature);
//			} else {
//				list = weatherUtil.getAllWeathers();
//			}
//		}
//		return list;
//	}
	
	@GET
	@Path("/{weatherId}")
	public Weather messageID(@PathParam("weatherId") long id){
		Weather weather = null;
		synchronized(weatherUtil){
			weather = weatherUtil.find(id);
		}
		return weather;			
	}
	
	@PUT
	@Path("/{weatherId}")
	public Weather updateWeather(@PathParam("weatherId") long id, Weather weather){
		weather.setId(id);
		synchronized(weatherUtil){
			return weatherUtil.updateWeather(weather);
		}
	}
	
	@DELETE
	@Path("/{weatherId}")
	public void deleteWeather(@PathParam("weatherId") long id){
		synchronized(weatherUtil){
			weatherUtil.deleteWeather(id);
		}
	}
	
	@POST
	public Weather addWeather(Weather weather){
		Weather temp = null;
		synchronized(weatherUtil){
			temp = weatherUtil.addWeather(weather);
		}
		return temp;
	}

}
