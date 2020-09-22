package servlets;

import dao.OperationDBDao;
import dao.OperationDao;
import dao.exceptions.NoResultException;
import entity.Operation;
import entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet (urlPatterns = "/history")
public class OperationsHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/history.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OperationDao operationDao = OperationDBDao.getInstance((Connection) req.getSession().getAttribute("connection"));
        User user = (User) req.getSession().getAttribute("user");
        List<Operation> report = new ArrayList<>();
        if (operationDao.operationsListByUserIdContain(user.getId())) {
            report.addAll(operationDao.getOperationsListByUserId(user.getId()));
        }
        if (req.getSession().getAttribute("operations") != null) {
            report.addAll((List<Operation>) req.getSession().getAttribute("operations"));
        }
        req.setAttribute("report", report);
        req.getRequestDispatcher("/history.jsp").forward(req, resp);

    }

}
