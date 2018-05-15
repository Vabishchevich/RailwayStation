package businessLogic;

import command.ICommand;
import dao.TrainDao;
import entity.Rout;
import entity.Ticket;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class ToBookATicketUser implements ICommand {

    @Override
    public String execute(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ClassNotFoundException, SQLException {
        Ticket ticket = new Ticket();
        Rout rout = new Rout();
        rout.setStartStation(servletRequest.getParameter("startStation"));
        rout.setEndStation(servletRequest.getParameter("endStation"));
        rout.setStartDate(servletRequest.getParameter("date"));
        ticket.setRout(rout);
        HttpSession session = servletRequest.getSession();
        session.setAttribute("ticketVO", ticket);
        TrainDao trainDao = new TrainDao();
        servletRequest.setAttribute("listOfTrains", trainDao.selectionTrain(rout));
        if (trainDao.selectionTrain(rout).isEmpty()) {
            return "/ErrorRoutTrainUser.jsp";
        } else {
            return "/RequestChoiceTrainUser.jsp";
        }
    }
}
