package listener;

import entity.Operation;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public Listener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("users", new ArrayList<>());
       // sce.getServletContext().setAttribute("operations", new ArrayList<>());
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

    public void sessionCreated(HttpSessionEvent se) {
       // se.getSession().setAttribute("list", new ArrayList<>());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            se.getSession().setAttribute("connection", DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "password"));
        } catch (SQLException|ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        Connection connection = (Connection) se.getSession().getAttribute("connection");
        List<Operation> operations = (List<Operation>) se.getSession().getAttribute("operations");
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println(sbe.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
    }
}
