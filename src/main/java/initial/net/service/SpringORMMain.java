package initial.net.service;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import initial.net.models.Weather;

public class SpringORMMain {

	public static void test() {
		// Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");

		// Get service from context. (service's dependency (ProductDAO) is autowired in
		// ProductService)
		WeatherService weatherService = ctx.getBean(WeatherService.class);

		// Do some data operation
		weatherService.add(new Weather("Sofia", 25.6, 27.9, 33.1));
		weatherService.add(new Weather("Paris", 35.6, 37.9, 29.3));

		System.out.println("listAll: " + weatherService.listAll());

		// Test transaction rollback (duplicated key)

		try {
			weatherService.addAll(Arrays.asList(new Weather("London", 45.6, 47.9, 19.3),
					new Weather("Munich", 25.6, 47.9, 24.3), new Weather("Frankfurt", 35.6, 37.9, 21.3)));
		} catch (DataAccessException dataAccessException) {
		}

		// Test element list after rollback
		System.out.println("listAll: " + weatherService.listAll());

		ctx.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
}