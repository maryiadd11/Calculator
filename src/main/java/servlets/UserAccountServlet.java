package servlets;

import entity.User;
import service.UserService;
import service.UserServiceImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet (name = "UserAccountServlet", urlPatterns = "/account")
public class UserAccountServlet extends HttpServlet {

    private static final String INVALID_NAME_FIELD = "Name should be longer";
    private static final String INVALID_PASSWORD_FIELD = "Password should be longer";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/account.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        UserService userService = UserServiceImplementation.getInstance((Connection) session.getAttribute("connection"));
        User user = (User) session.getAttribute("user");
        String value = req.getParameter("value");

        if (req.getParameter("field").equals("name")) {
            if (checkField(value)) {
                user.setName(value);
            } else {
                req.setAttribute("message", INVALID_NAME_FIELD);
                req.getRequestDispatcher("auth/jsp").forward(req,resp);
                return;
            }
        }
        if (req.getParameter("field").equals("password")) {
            if (checkField(value)) {
                user.setPassword(value);
            } else {
                req.setAttribute("message", INVALID_PASSWORD_FIELD);
                req.getRequestDispatcher("auth/jsp").forward(req,resp);
                return;
            }
        }
        userService.update(user);
        resp.sendRedirect("/");
    }

    private boolean checkField (String field) {
        return field.length() >= 5;
    }
}
