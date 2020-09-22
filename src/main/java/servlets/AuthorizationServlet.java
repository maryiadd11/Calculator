package servlets;

import entity.User;
import service.UserService;
import service.UserServiceImplementation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet (name = "AuthServlet", urlPatterns = "/auth")
public class AuthorizationServlet extends HttpServlet {

    private static final String INVALID_LOGIN = "Invalid login";
    private static final String INVALID_PASSWORD = "Invalid password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserService userService = UserServiceImplementation.getInstance((Connection) req.getSession().getAttribute("connection"));
        User user;
        if (userService.containsByLogin(login)) {
            user = userService.getByLogin(login);
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/");
                return;
            } else {
                req.setAttribute("password", INVALID_PASSWORD);
            }
        } else {
            req.setAttribute("login", INVALID_LOGIN);
        }
        req.getRequestDispatcher("/auth.jsp").forward(req,resp);
    }
}
