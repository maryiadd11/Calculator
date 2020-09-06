package dao;

import entity.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDBDao implements UserDao {
    private Connection connection;

    private static final String CREATE_USER = "INSERT INTO users VALUES (default, ?, ?, ?)";
    private static final String GET_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String GET_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String GET_ALL = "SELECT * FROM users";
    private static final String UPDATE_BY_ID = "UPDATE users SET login = ?, name = ?, password = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE * FROM users WHERE id = ?";

    public UserDBDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User getById(long id) {
       try {
           PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
           statement.setLong(1, id);
           ResultSet resultSet = statement.executeQuery();
           if (resultSet.next()) {
               return new User(
                       resultSet.getString("name"),
                       resultSet.getString("login"),
                       resultSet.getString("password"));
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
        throw new UserNotFoundException();
    }

    @Override
    public User getByLogin(String login) {
        try {
            PreparedStatement statement = connection.prepareStatement(GET_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new UserNotFoundException();
    }

    @Override
    public List<User> getAll() {
        List <User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (users.isEmpty()) {
            throw new NoResultException();
        }
        return users;
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setLong(4, user.getId());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean containsById(long id) {
         try {
             PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
             statement.setLong(1, id);
             statement.executeQuery().next();
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
         return false;
    }

    @Override
    public boolean containsByLogin(String login) {
        try {
            PreparedStatement statement = connection.prepareStatement(GET_BY_LOGIN);
            statement.setString(1, login);
            statement.executeQuery().next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "password");
        UserDao userDao = new UserDBDao(connection);
        userDao.create(new User("", "", ""));
        //System.out.println(userDao.getById(1));
        //System.out.println(userDao.getByLogin("test"));
        //System.out.println(userDao.getAll());
        //userDao.update(new User(2, "hiuafs", "hbvsbk", "vbj"));
        //userDao.deleteById(2);
        //System.out.println(userDao.containsById(1));
        //System.out.println(userDao.containsByLogin("TEST"));
    }
}
