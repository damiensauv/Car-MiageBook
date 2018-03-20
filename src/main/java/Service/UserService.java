package Service;

import Domain.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserService {

    @POST
    @Path("/signup")
    @Produces(MediaType.APPLICATION_JSON)
    public User signUp() {
        User u = new User();
        u.setNom("damien");
        return u;
    }

}
