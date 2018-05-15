package businessLogic;

import command.ICommand;
import dao.PlaceDao;
import entity.CountPlace;
import entity.Ticket;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class ChoiceTypeRailCarUser implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        String passportNumber = request.getParameter("numberPassport");
        String wagonClass = request.getParameter("choiceTypeRailCar");
        HttpSession session = request.getSession();
        Ticket ticket = (Ticket) session.getAttribute("ticketVO");
        ticket.setPassportNumber(passportNumber);
        ticket.setWagonClass(wagonClass);
        CountPlace countPlace = new CountPlace();
        countPlace.setTypeRailCar(request.getParameter("choiceTypeRailCar"));
        PlaceDao placeDao = new PlaceDao();
        request.setAttribute("choicePlace", placeDao.getNumberRailCar(countPlace, ticket.getNumberTrain()));
        return "/RequestChoiceRailCarUser.jsp";
    }
}
