package businessLogic;

import command.ICommand;
import dao.TicketDao;
import entity.NumberPlace;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PrivateOfficeUsers implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        String numberPassport = request.getParameter("numberPassport");
        TicketDao ticketDao = new TicketDao();
        List<NumberPlace> numberPlace;
        numberPlace = ticketDao.showNumberPlace(numberPassport);
        if (numberPlace.isEmpty()) {
            return "/ErrorNumberPassportUser.jsp";
        } else {
            request.setAttribute("tickets", ticketDao.showTickets(numberPassport));
            return "/ViewTicketsUser.jsp";
        }
    }
}
