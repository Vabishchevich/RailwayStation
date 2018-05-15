package businessLogic;

import command.ICommand;
import dao.UserDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteInformationAboutUsers implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        List<String> usersAll = Arrays.asList(request.getParameterValues("users"));
        UserDao user = new UserDao();
        for (int i = 0; i < usersAll.size(); i++) {
            user.deleteUsers(Integer.parseInt(usersAll.get(i)));
        }
        return "/SuccessfulDeleteAdmin.jsp";
    }
}
