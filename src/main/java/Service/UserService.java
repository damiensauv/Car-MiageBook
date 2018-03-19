package Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api/user")
public class UserService {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public String getIt() {


        return "Got it!";
    }

}
