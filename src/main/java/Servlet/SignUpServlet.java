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
import java.io.PrintWriter;

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
        RequestDispatcher view = request.getRequestDispatcher("/Template/inscription.jsp");
        view.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // TODO gere erreur si il y a qui manque(VIDE)
        String email = request.getParameter("email");
        String pseudo = request.getParameter("pseudo");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        User user = new User(email, pseudo, password, name, surname);

        if (userService.signup(user)) {
            RequestDispatcher view = request.getRequestDispatcher("/Template/login.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Template/inscription.jsp");
            PrintWriter out = response.getWriter();
            out.println("<div class=\"alert alert-danger\"> Une erreur s'est produite</div>");
            rd.include(request, response);
        }

    }
}
