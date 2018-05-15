package businessLogic;

import command.ICommand;
import dao.TrainDao;
import entity.Train;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewTrainAdmin implements ICommand {

    @Override
    public String execute(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException, ClassNotFoundException, SQLException {
        Train train = new Train();
        train.setNumberTrain(servletRequest.getParameter("numberTrain"));
        train.setStartStation(servletRequest.getParameter("startStation"));
        train.setEndStation(servletRequest.getParameter("endStation"));
        TrainDao trainDao = new TrainDao();
        servletRequest.setAttribute("listOfTrains", trainDao.addNewTrain(train));
        return "/SuccessfulAddTrainAdmin.jsp";
    }
}
