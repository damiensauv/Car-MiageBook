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

public class LoginServlet extends HttpServlet {

    private UserMapper userMapper;
    private UserService userService;

    public LoginServlet(){
        userMapper = UserMapper.getInstance();
        userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/Template/login.html");
        view.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        UserService.getInstance().checkUserExistEmail(email);

        // check mail & password
        UserService.getInstance().checkLogin(email, password);

        //get Id of user for sessions

        // creation cookie/session, si tout ce passe bien
        HttpSession session = request.getSession(true);
        session.setAttribute("user", 1);

        // envoyer vers la bonne pages !! // page accueil
        RequestDispatcher view = request.getRequestDispatcher("/Template/login.html");
        view.forward(request, response);
    }

}
