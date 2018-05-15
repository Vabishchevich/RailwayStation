package businessLogic;

import command.ICommand;
import dao.TrainDao;
import entity.Rout;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewTrainsAdmin implements ICommand {

    @Override
    public String execute(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException, ClassNotFoundException, SQLException {
        Rout rout = new Rout();
        rout.setStartDate(servletRequest.getParameter("date"));
        TrainDao trainDao = new TrainDao();
        servletRequest.setAttribute("listOfTrains", trainDao.selectionTrainTwo(rout));
        if (trainDao.selectionTrainTwo(rout).isEmpty()) {
            return "/ErrorViewTrainsAdmin.jsp";
        } else {
            return "/ViewAllTrainsAdmin.jsp";
        }
    }
}
