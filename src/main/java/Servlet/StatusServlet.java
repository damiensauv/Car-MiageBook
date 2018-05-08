package Servlet;

import Domain.Commentaire;
import Domain.Status;
import Domain.User;
import Persistance.DataMapper.UserMapper;
import Service.StatusService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class StatusServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("s"));
        StatusService ss = StatusService.getInstance();
        Status status = ss.find(id);
        List<Commentaire> coms = ss.findComs(status.getId());

        request.setAttribute("status", status);
        request.setAttribute("coms", coms);

        RequestDispatcher view = request.getRequestDispatcher("/Template/status.jsp");
        view.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String path = request.getServletPath();

        Integer idst = Integer.valueOf(request.getParameter("s"));
        if (path.equals("/commentaire")) {


            String co = request.getParameter("comment");


            HttpSession session = request.getSession();
            Integer id = (Integer) session.getAttribute("user");
            User u = UserMapper.getInstance().find(id);

            Commentaire commentaire = new Commentaire(co, u, idst);

            StatusService.getInstance().insertCommentaire(commentaire);

        }
        response.sendRedirect(request.getContextPath() + "/status?s=" + idst);


    }


}
