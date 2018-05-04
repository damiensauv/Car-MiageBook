package Servlet;

import Domain.User;
import Persistance.DataMapper.UserMapper;
import Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    private UserMapper userMapper;
    private UserService userService;

    public LoginServlet() {
        userMapper = UserMapper.getInstance();
        userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // TODO check if already connect in session

        RequestDispatcher view = request.getRequestDispatcher("/Template/login.jsp");
        view.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        User user = null;
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if ((user = userService.login(email, password)) != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user.getId());

            RequestDispatcher view = request.getRequestDispatcher("/Template/home.jsp");
            view.forward(request, response);

        } else {

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Template/login.jsp");
            PrintWriter out = response.getWriter();
            out.println("<div class=\"alert alert-danger\"> Login ou mot de passe invalide</div>");
            rd.include(request, response);

        }


    }

}
