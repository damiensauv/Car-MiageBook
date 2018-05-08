package Rest;

import Domain.User;
import Service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("user")
public class UserRest {

    private UserService userService;

    public UserRest() {
        this.userService = UserService.getInstance();
    }

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


    @POST
    @Path("/follow")
    public Response follow(@Context HttpServletRequest request, String id) {

        Integer idfriend = Integer.valueOf(id);

        HttpSession session = request.getSession();
        Integer iduser = (Integer) session.getAttribute("user");
        User user = userService.getUser(iduser);

        boolean ret = userService.addFriendTo(user.getId(), idfriend);
        int r = 1;
        if (ret)
            r = 0;

        return Response.status(201).entity(r).build();
    }

    @POST
    @Path("/unfollow")
    public Response unfollow(@Context HttpServletRequest request, String id) {

        Integer idfriend = Integer.valueOf(id);

        HttpSession session = request.getSession();
        Integer iduser = (Integer) session.getAttribute("user");
        User user = userService.getUser(iduser);

        boolean ret = userService.UnFriendTo(user.getId(), idfriend);
        int r = 1;
        if (ret)
            r = 0;

        return Response.status(201).entity(r).build();
    }

}
