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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/account.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        UserService userService = UserServiceImplementation.getInstance((Connection) session.getAttribute("connection"));
        User user = (User) session.getAttribute("user");
        userService.update(new User(user.getId(), req.getParameter("name"), user.getLogin(), req.getParameter("password")));
        resp.sendRedirect("/");
    }
}
