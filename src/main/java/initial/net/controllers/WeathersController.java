package initial.net.controllers;

import initial.net.beans.WeatherFilterBean;
import initial.net.models.Weather;
import initial.net.service.SpringORMMain;
import initial.net.service.WeatherService;
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
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@Path("/weathers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WeathersController {

	static String XML_SPRING_CONFIGURATION = "classpath:/spring.xml";
	private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(XML_SPRING_CONFIGURATION);
	private WeatherService weatherService = ctx.getBean(WeatherService.class);
	
	@GET
	public List<Weather> getWeathers(@BeanParam WeatherFilterBean filterBean){
		System.out.println("QueryParam : " + filterBean.getCity() +" : "+ filterBean.getStartTemperature() +
				" : " + filterBean.getEndTemperature());
//		SpringORMMain.test();
		List<Weather> list = null;
		synchronized(weatherService){
			if(filterBean.getCity() != null){
				list = weatherService.findByCity(filterBean.getCity());
			}
			else if(filterBean.getStartTemperature() != null && filterBean.getEndTemperature() != null){
				list = weatherService.findByTemperatureRange(filterBean.getStartTemperature(), filterBean.getEndTemperature());
			}
			else{
				list = weatherService.listAll(); 	
			}
		}
		return list;
	}
	
	@GET
	@Path("/{weatherId}")
	public Weather messageID(@PathParam("weatherId") long id){
		Weather weather = null;
		synchronized(weatherService){
			weather = weatherService.find(id);
		}
		return weather;			
	}
	
	@PUT
	@Path("/{weatherId}")
	public Weather updateWeather(@PathParam("weatherId") long id, Weather weather){
		weather.setId(id);
		synchronized(weatherService){
			return weatherService.updateWeather(weather);
		}
	}
	
	@DELETE
	@Path("/{weatherId}")
	public void deleteWeather(@PathParam("weatherId") long id){
		synchronized(weatherService){
			weatherService.deleteWeather(id);
		}
	}
	
	@POST
	public Weather addWeather(Weather weather){
		System.out.println("Adding Weather!");
		Weather temp = null;
		synchronized(weatherService){
			temp = weatherService.add(weather);
		}
		return temp;
	}

}