package businessLogic;

import command.ICommand;
import dao.UserDao;
import entity.UserView;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginVerification implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        UserView user = new UserView();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setRole(request.getParameter("role"));
        UserDao userdao = new UserDao();
        request.setAttribute("user", userdao.addUser(user));
        if ("admin".equals(request.getParameter("login")) && "admin".equals(request.getParameter("password")) && "admin".equals(request.getParameter("role"))) {
            return "/AdminHomePage.jsp";
        } else {
            return "/HomePageUser.jsp";
        }
    }
}
