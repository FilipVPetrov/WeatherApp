package initial.net.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Weather")
public class Weather {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "city")
	private String city;

	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "temperature")
	private double temperature;
	
	public Weather() {
		super();
		this.city = "";
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.temperature = 0.0;
	}

	public Weather(String city, double longitude, double latitude,
			double temperature) {
		super();
		this.city = city;
		this.longitude = longitude;
		this.latitude = latitude;
		this.temperature = temperature;
	}

	public Weather(int id, String city, double longitude, double latitude,
			double temperature) {
		super();
		this.id = id;
		this.city = city;
		this.longitude = longitude;
		this.latitude = latitude;
		this.temperature = temperature;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public long getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", city=" + city + ", longitude="
				+ longitude + ", latitude=" + latitude + ", temperature="
				+ temperature + "]";
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
}
