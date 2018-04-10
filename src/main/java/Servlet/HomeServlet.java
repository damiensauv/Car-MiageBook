package Servlet;

import Persistance.DataMapper.UserMapper;
import Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

    private UserMapper userMapper;
    private UserService userService;

    public HomeServlet(){
        userMapper = UserMapper.getInstance();
        userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/Template/home.html");
        view.forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String path = request.getServletPath();

        // post status
        if (path.equals("/homeStatus")){

            String status = request.getParameter("status");
            // recup from session la personne co

            HttpSession session = request.getSession();

            Object id = session.getAttribute("user");

            System.out.println("Status =>" + status + " id => " + id);


        }
        else if (path.equals("/homeCommentaire")){

        }



        RequestDispatcher view = request.getRequestDispatcher("/Template/home.html");
        view.forward(request, response);
    }
}
