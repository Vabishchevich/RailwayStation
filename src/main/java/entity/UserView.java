package entity;

public class UserView {

    private int userid;
    private String login;
    private String password;
    private String role;

    public UserView() {
    }

    public UserView(int userid, String login, String password, String role) {
        this.userid = userid;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserView{"
                + "userid='" + login + '\''
                + "login='" + login + '\''
                + ", password='" + password + '\''
                + ", role='" + role + '\''
                + '}';
    }
}
