package servlets;

import entity.User;
import service.UserServiceImplementation;
import service.exceptions.DuplicateUserException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;


@WebServlet (urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {

    private static final String DUPLICATE_USER = "This login already exists";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reg.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        User user = new User(login, name, password);

        try {
            UserServiceImplementation.getInstance((Connection) req.getSession().getAttribute("connection")).create(user);
        } catch (DuplicateUserException e) {
            req.setAttribute("message", DUPLICATE_USER);
            req.getRequestDispatcher("/reg.jsp").forward(req,resp);
        }

        resp.sendRedirect("/");
    }
}
