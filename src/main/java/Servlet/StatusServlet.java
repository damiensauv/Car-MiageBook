package Servlet;

import Domain.Status;
import Service.StatusService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatusServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("s"));

        StatusService ss = StatusService.getInstance();

        Status status = ss.find(id);

        request.setAttribute("status", status);

        RequestDispatcher view = request.getRequestDispatcher("/Template/status.jsp");
        view.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


    }


}
