package servlets;

import entity.Operation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/history")
public class OperationsHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List <Operation> operations = (List<Operation>) getServletContext().getAttribute("operations");

        for (Operation op : operations) {
            resp.getWriter().println(op);
        }
    }
}
