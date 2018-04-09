package Servlet;

import Domain.User;
import Persistance.DataMapper.UserMapper;
import Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpServlet extends HttpServlet {

    private UserMapper userMapper;
    private UserService userService;

    public SignUpServlet() {
        userMapper = UserMapper.getInstance();
        userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/Template/inscription.html");
        view.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String email = request.getParameter("email");
        String pseudo = request.getParameter("pseudo");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println(email);

        userService.checkUserExistEmail(email);
        userService.checkUserExistPseudo(pseudo);
        // faire les conditions pour les check

        User user = new User(email, pseudo, password, name, surname);

        try {
            userMapper.insert(user); // check retour / Exception !
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // voir pour envoyer un truc comme quoi bien inscrit

        RequestDispatcher view = request.getRequestDispatcher("/Template/login.html");
        view.forward(request, response);
    }
}
