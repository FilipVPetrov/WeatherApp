package initial.net.dao;

import  initial.net.models.Weather;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

/**
 * @author Filip
 *
 */
@Component
public class WeatherDao {

	@PersistenceContext
	private EntityManager em;

	
	public void persist(Weather weather) {
		em.persist(weather);
	}

	@SuppressWarnings("unchecked")
	public List<Weather> findAll() {
		return em.createQuery("SELECT w FROM Weather w").getResultList();
	}
	
	public Weather find(long id) {
		return em.find(Weather.class, id);
	}
	
	public List<Weather> findByCity(String city) {
		Query query = em.createQuery(
				"SELECT w FROM Weather AS w WHERE w.city = ?1", Weather.class);
		query.setParameter(1, city);
		@SuppressWarnings("unchecked")
		List<Weather> results = (List<Weather>) query.getResultList();
		return results;
	}
	
	/*@param: start ranges - inclusive
	 *@param: end ranges - inclusive
	 * */
	public List<Weather> findByTemperatureRange(double start, double end){
		Query query = em.createQuery(
				"SELECT w FROM Weather AS w WHERE w.temperature BETWEEN ?1 AND ?2", Weather.class);
		query.setParameter(1, start);
		query.setParameter(2, end);		
		@SuppressWarnings("unchecked")
		List<Weather> results = new ArrayList<Weather>((List<Weather>) query.getResultList());
		return results;
	}
	
	public Weather updateWeather(Weather weather) {
		Weather temp = em.find(Weather.class, weather.getId());
		em.getTransaction().begin();
		temp.setCity(weather.getCity());
        temp.setLatitude(weather.getLatitude());
        temp.setLongitude(weather.getLongitude());
        temp.setTemperature(weather.getTemperature());
        em.getTransaction().commit();
        return temp;
	}
	
	public Weather deleteWeather(long id) {
		Weather weather = em.find(Weather.class, id);
		em.remove(weather);
		return weather;
	}

}