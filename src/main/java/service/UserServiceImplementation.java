package service;

import dao.UserDBDao;
import dao.UserDao;
import entity.User;
import service.exception.DuplicateUserException;
import service.exception.UserNotFoundException;
import java.sql.Connection;
import java.util.List;


public class UserServiceImplementation implements UserService{
    private UserDao userDao;

    private UserServiceImplementation (UserDao userDao) {
        this.userDao = userDao;
    }

    private static UserService instance = null;

    public static UserService getInstance(Connection connection) {
        if (instance == null) {
            return new UserServiceImplementation(UserDBDao.getInstance(connection));
        } else {
            return instance;
        }
    }

    @Override
    public void create(User user) {
        if (userDao.containsByLogin(user.getLogin())) {
            throw new DuplicateUserException();
        }
        userDao.create(user);
    }

    @Override
    public User getById(long id) {
        if (userDao.containsById(id)) {
            return userDao.getById(id);
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getByLogin(String login) {
        if (userDao.containsByLogin(login)) {
            return userDao.getByLogin(login);
        }
        throw new UserNotFoundException();
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void deleteById(long id) {
        if (userDao.containsById(id)){
            userDao.deleteById(id);
        }
    }

    @Override
    public void update(User user) {
        if (userDao.containsById(user.getId())){
            userDao.update(user);
        }
    }

    @Override
    public void update(String name, long id) {

    }
}
