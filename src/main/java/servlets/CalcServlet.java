package servlets;

import dao.OperationDBDao;
import dao.OperationDao;
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

import static service.CalcService.run;

@WebServlet (name = "CalcServlet", urlPatterns = "/calc")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/calc.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        OperationDao operationDao = OperationDBDao.getInstance((Connection) req.getSession().getAttribute("connection"));

        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String type = req.getParameter("type");
        double result = run(num1, num2, type);


        List<Operation> operations;
        if ((operations = (List<Operation>) req.getSession().getAttribute("operations")) == null) {
            operations = new ArrayList<>();
            req.getSession().setAttribute("operations", operations);
        }
        User user = (User) req.getSession().getAttribute("user");
        operations.add(new Operation(user.getId(), num1, num2, type, result));

        req.setAttribute("result", result);
        req.getRequestDispatcher("/calc.jsp").forward(req, resp);
    }
}
