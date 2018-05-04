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
import java.util.List;

public class AllUserServlet extends HttpServlet {

    private UserService userService;

    public AllUserServlet() {
        this.userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // TODO Check if User Connect
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("user");

        List<User> users = userService.getAllUsersWithout(id);

        request.setAttribute("users", users);

        RequestDispatcher view = request.getRequestDispatcher("/Template/AllUsers.jsp");
        view.forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

    }


}
