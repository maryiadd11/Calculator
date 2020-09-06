package servlets;

import entity.Operation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String type = req.getParameter("type");
        double result = run(num1, num2, type);
        req.setAttribute("result", result);

        List <Operation> operations = (List<Operation>) getServletContext().getAttribute("operations");
        Operation operation = new Operation (num1, num2, type, result);
        operations.add(operation);

        for (Operation op : operations) {
            if (operations != null) {
                req.getSession().setAttribute("operation", op);
            }
        }

        req.getRequestDispatcher("/calc.jsp").forward(req, resp);
    }

}
