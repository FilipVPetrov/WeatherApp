package initial.net.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import initial.net.dao.WeatherDao;
import initial.net.models.Weather;

@Component
public class WeatherService {

	@Autowired
	private WeatherDao weatherDao;
	
	@Transactional
	public Weather add(Weather weather) {
		weatherDao.persist(weather);
		return weather;
	}
	
	@Transactional
	public void addAll(Collection<Weather> weathers) {
		for(Weather weather : weathers) {
			weatherDao.persist(weather);
		}
	}
	
	@Transactional(readOnly = true)
	public List<Weather> listAll(){
		return weatherDao.findAll();
	}
	
	@Transactional
	public Weather find(long id) {
		return weatherDao.find(id);
	}
	
	@Transactional
	public List<Weather> findByCity(String city) {
		return weatherDao.findByCity(city);
	}
	
	@Transactional
	public List<Weather> findByTemperatureRange(double start, double end) {
		return weatherDao.findByTemperatureRange(start, end);
	}
	
	@Transactional
	public Weather updateWeather(Weather weather) {
		return weatherDao.updateWeather(weather);
	}
	
	@Transactional
	public Weather deleteWeather(long id) {
		return weatherDao.deleteWeather(id);
	}
}
