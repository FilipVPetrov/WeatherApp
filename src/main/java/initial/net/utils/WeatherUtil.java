package initial.net.utils;

import initial.net.models.Weather;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class WeatherUtil {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("InitialWebApp");

	public static void main(String args[]) {
		WeatherUtil weatherUtil = new WeatherUtil();
		weatherUtil.updateWeather(new Weather(1, "Munich", 11.1,13.1,15.6));
		weatherUtil.findByTemperatureRange(10.1, 30);
//		weatherUtil.createWeather();	
//		weatherUtil.delete(2201L);
//		for (int i = 0; i < 100; i++) {
//			weatherUtil.createWeather();			
//		}
//		weatherUtil.getAllWeathers();
//		weatherUtil.findByCity("Berlin");
//		weatherUtil.find(2001);
	}
	
	public void createWeather(){
		EntityManager entityManager = null;
		try{
			entityManager = entityManagerFactory
					.createEntityManager();
			entityManager.getTransaction( ).begin( );
			Weather weather = new Weather("Berlin",33.2,66.1,21.1);
			entityManager.persist(weather);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally{
			entityManager.close();
		}
	}
	public Weather addWeather(Weather weather){
		EntityManager entityManager = null;
		Weather temp = null;
		try {
			entityManager = entityManagerFactory
					.createEntityManager();
			entityManager.getTransaction( ).begin( );
			temp = new Weather(weather.getCity(),weather.getLongitude(), 
					weather.getLatitude(), weather.getTemperature());
			entityManager.persist(temp);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally{
			entityManager.close();
		}
		return temp;
	}

	@SuppressWarnings("unchecked")
	public List<Weather> getAllWeathers() {
		EntityManager entityManager = null;
		List<Weather> list =  null;
		try {
			entityManager = entityManagerFactory
					.createEntityManager();
			Query query = entityManager.createQuery("SELECT w FROM Weather w");
			list = (List<Weather>) query.getResultList();
	
			for (Weather w : list) {
				System.out.println(w.toString());
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();	
		}finally{
			entityManager.close();
		}
		return list;
	}
	public Weather find(long id){
		EntityManager entityManager = null;
		Weather weather = null;
		try {
			entityManager = entityManagerFactory
					.createEntityManager();
			weather = entityManager.find(Weather.class, id);
			System.out.println("Is found: "+weather);
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally{
			entityManager.close();
		}
		return weather;
	}
	
	@SuppressWarnings("unchecked")
	public List<Weather> findByCity(String city){
		EntityManager entityManager = null;
		List<Weather> results =  null;
	    try{
			entityManager = entityManagerFactory
					.createEntityManager();
			Query query = entityManager.createQuery(
					"SELECT w FROM Weather AS w WHERE w.city = ?1", Weather.class);
			query.setParameter(1, city);
			results = (List<Weather>) query.getResultList();
			System.out.println("findByCity");
			for (Weather w : results) {
				System.out.println(w.toString());	
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally{
			entityManager.close();
		}
		return results;		
	}
	
	@SuppressWarnings("unchecked")
	public List<Weather> findByTemperatureRange(double start, double end){
		EntityManager entityManager = null;
		List<Weather> results =  null;
	    try{
			entityManager = entityManagerFactory
					.createEntityManager();
			Query query = entityManager.createQuery(
					"SELECT w FROM Weather AS w WHERE w.temperature BETWEEN ?1 AND ?2", Weather.class);
			query.setParameter(1, start);
			query.setParameter(2, end);			
			results = new ArrayList<Weather>((List<Weather>) query.getResultList());
			System.out.println("findByTemperatureRange");
			for (Weather w : results) {
				System.out.println(w.toString());	
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally{
			entityManager.close();
		}
		return results;
	}
	
	public Weather updateWeather(Weather weather){
		EntityManager entityManager = null;
		Weather temp = null;
	    try{
			entityManager = entityManagerFactory
					.createEntityManager();
	        entityManager.getTransaction().begin();
	        temp = entityManager.find(Weather.class, weather.getId());
	        temp.setCity(weather.getCity());
	        temp.setLatitude(weather.getLatitude());
	        temp.setLongitude(weather.getLongitude());
	        temp.setTemperature(weather.getTemperature());
	        System.out.println("updateWeather " + weather.toString());
	        entityManager.getTransaction().commit();
	        this.find(weather.getId());
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally{
	    	entityManager.close();
	    }
	    return temp;
	}
	
	public Weather deleteWeather(long id){
		EntityManager entityManager = null;
		Weather weather = null;
		try {
			entityManager = entityManagerFactory
					.createEntityManager();
			entityManager.getTransaction().begin();
			weather = entityManager.find(Weather.class, id);
			entityManager.remove(weather);
			System.out.println("Removed: "+weather);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally{
			entityManager.close();
		}
		return weather;
	}
}
