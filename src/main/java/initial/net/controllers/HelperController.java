package initial.net.controllers;


import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class HelperController extends Application { 
	@Override public Set<Class<?>> getClasses() {  
		Set<Class<?>> resources = new HashSet<>();  
		resources.add(HomeController.class);  
		resources.add(WeathersController.class);
		return resources; 
	} 
//	@Override public Set getSingletons() {  
//		HashSet singletons = new HashSet();  
//		JacksonJsonProvider provider = new JacksonJaxbJsonProvider();  
//		singletons.add(provider);  
//		return singletons; 
//	}
}