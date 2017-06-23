package initial.net.home;

import initial.net.models.Weather;
import initial.net.utils.WeatherUtil;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("/weather")
public class HomeController {
	private static final Logger logger = Logger.getLogger(HomeController.class);

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayhello() {
		logger.debug("sample debug message");
		logger.info("sample info message");
		logger.warn("sample warning message");
		logger.error("sample error message");
		String result = "Home page!\n"+ "Time Now is : " + new Date().toString()+"\n\n\n";
		WeatherUtil weatherUtil = new WeatherUtil();
		weatherUtil.createWeather();
		List<Weather> list = weatherUtil.getAllWeathers();
		for(Weather weather : list){
			result += weather.toString()+"\n";
		}
		return result;
	}
	
	@GET
	@Produces("text/html")
	public String getXml() {
	    return "<html><body><h1>Home Page!</body></h1></html>";
	}
}
