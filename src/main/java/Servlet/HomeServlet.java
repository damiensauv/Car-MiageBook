package Servlet;

import Domain.Status;
import Domain.User;
import Persistance.DataMapper.StatusMapper;
import Persistance.DataMapper.UserMapper;
import Service.StatusService;
import Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {

    private UserMapper userMapper;
    private UserService userService;
    private StatusService statusService;
    private StatusMapper statusMapper;

    public HomeServlet() {
        userMapper = UserMapper.getInstance();
        userService = UserService.getInstance();
        statusMapper = StatusMapper.getInstance();
        statusService = StatusService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // TODO Check if User Connect
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("user");

        List<Status> status = statusService.getStatusUser(id);


        request.setAttribute("status", status);

        RequestDispatcher view = request.getRequestDispatcher("/Template/home.jsp");
        view.forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String path = request.getServletPath();

        // post status
        if (path.equals("/homeStatus")) {

            String statusString = request.getParameter("status");
            String titreString = request.getParameter("titre");
            // recup from session la personne co

            HttpSession session = request.getSession();
            Integer id = (Integer) session.getAttribute("user");
            User u = userMapper.find(id);

            Status status = new Status(statusString, titreString, u);


            statusService.insert(status);

        }


        response.sendRedirect(request.getContextPath() + "/home");
    }
}
