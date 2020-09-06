package entity;

public class User {

   // private static int incId = 1;
    private int id;

    private String login;
    private String name;
    private String password;

    public User() {
    }

    public User(int id, String login, String name, String password) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.password = password;
    }

    public User(String login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}