package businessLogic;

import command.ICommand;
import dao.UserDao;
import entity.UserView;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkWithUsers implements ICommand {

    @Override
    public String execute(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException, ClassNotFoundException, SQLException {
        UserView user = new UserView();
        UserDao userDao = new UserDao();
        servletRequest.setAttribute("listOfUsers", userDao.viewAllUsers(user));
        if (userDao.viewAllUsers(user).isEmpty()) {
            return "/ErrorViewUsers.jsp";
        } else {
            return "/ViewAllUsersAdmin.jsp";
        }
    }
}
