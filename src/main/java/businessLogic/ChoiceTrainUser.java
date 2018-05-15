package businessLogic;

import command.ICommand;
import dao.CountPlaceDao;
import entity.NumberTrain;
import entity.Ticket;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class ChoiceTrainUser implements ICommand {

    @Override
    public String execute(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ClassNotFoundException, SQLException {
        HttpSession session = servletRequest.getSession();
        Ticket ticket = (Ticket) session.getAttribute("ticketVO");
        String trainNumber = servletRequest.getParameter("numberTrain");
        NumberTrain numberTrain = new NumberTrain();
        numberTrain.setNumberTrain(trainNumber);
        ticket.setNumberTrain(trainNumber);
        CountPlaceDao placeDao = new CountPlaceDao();
        servletRequest.setAttribute("countPlace", placeDao.getNumberPlace(numberTrain));
        return "/RequestChoiceTypeRailCarUser.jsp";
    }
}
