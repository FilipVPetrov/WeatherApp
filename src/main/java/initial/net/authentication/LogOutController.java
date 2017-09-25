package initial.net.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/logout")
public class LogOutController {

	@GET
	public void logOut(@Context HttpServletRequest req) {
		System.out.println("User " + req.getRemoteUser() + " logout.");
		HttpSession session = req.getSession(true);
		session.invalidate();
	}
}
