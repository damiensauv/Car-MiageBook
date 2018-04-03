package Rest;

import Domain.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("user")
public class UserRest {

    @POST
    @Path("/signup")
    public User signUp() {
        User u = new User();
        u.setNom("damien");
        return u;
    }

    @POST
    @Path("/login")
    public User signIn() {
        return null;
    }

}
