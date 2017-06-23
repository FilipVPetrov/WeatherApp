package initial.net.beans;

import javax.ws.rs.QueryParam;

public class WeatherFilterBean {

	private @QueryParam("city") String city;
	private @QueryParam("startT") Double startTemperature;
	private @QueryParam("endT") Double endTemperature;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getStartTemperature() {
		return startTemperature;
	}
	public void setStartTemperature(Double startTemperature) {
		this.startTemperature = startTemperature;
	}
	public Double getEndTemperature() {
		return endTemperature;
	}
	public void setEndTemperature(Double endTemperature) {
		this.endTemperature = endTemperature;
	}
	
}
