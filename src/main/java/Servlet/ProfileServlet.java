package Servlet;

import Domain.User;
import Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileServlet extends HttpServlet {

    private UserService userService;

    public ProfileServlet() {
        this.userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // TODO Check if User Connect
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("user");

        User user = userService.getUser(id);
        List<User> friends = new ArrayList<>();
        for (Integer i : user.getFriends()){
            friends.add(userService.getUser(i));
        }

        request.setAttribute("friends", friends);
        request.setAttribute("user", user);

        RequestDispatcher view = request.getRequestDispatcher("/Template/profile.jsp");
        view.forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

    }
}
