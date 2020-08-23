package servlets;

import service.CalcService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet (urlPatterns = "/", loadOnStartup = 0)
public class HomeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Initializing");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String type = req.getParameter("type");
        CalcService servlet = new CalcService(num1, num2, type);
        double result = servlet.run();
        resp.getWriter().println(result);
    }

    @Override
    public void destroy() {
        System.out.println("Closing");
    }
}
