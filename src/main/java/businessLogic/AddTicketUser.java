package businessLogic;

import command.ICommand;
import dao.PlaceDao;
import dao.TicketDao;
import dao.TrainDao;
import entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddTicketUser implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        HttpSession session = request.getSession();

        Ticket ticket = (Ticket) session.getAttribute("ticketVO");
        TrainDao trainDao = new TrainDao();

        List<Train> trains = new ArrayList<>();
        trains = trainDao.selectionTrain(ticket.getRout());
        for (int i = 0; i < trains.size(); i++) {
            if (ticket.getNumberTrain().equals(trains.get(i).getNumberTrain())) {
                ticket.setStartTime(trains.get(i).getStartTime());
                ticket.setEndTime(trains.get(i).getEndTime());
            }
        }

        NumberRailCar numberRailCar = new NumberRailCar();
        numberRailCar.setNumberRailCar(Integer.parseInt(request.getParameter("choiceNumberRailCar")));
        PlaceDao placeDao = new PlaceDao();
        NumberPlace numberPlace = new NumberPlace();
        List<NumberPlace> numberPlaces = new ArrayList<>();
        numberPlaces = placeDao.getPlace(Integer.parseInt(request.getParameter("choiceNumberRailCar")), ticket.getNumberTrain());
        numberPlace.setNumberPlace(numberPlaces.get(0).getNumberPlace());
        ticket.setNumberRailCar(numberRailCar.getNumberRailCar());
        ticket.setNumberPlace(numberPlace.getNumberPlace());

        placeDao.deletePlace(numberPlace);
        TicketDao ticketDao = new TicketDao();
        IdTables idTables = ticketDao.idTables(ticket);
        placeDao.edit(idTables.getIdRailCar());
        int idTicket = ticketDao.buyTicket(ticket.getPassportNumber(), idTables, ticket.getNumberPlace());
        ticket.setIdTicket(idTicket);
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(0, ticket);
        request.setAttribute("ticketVO", tickets);
        return "/ViewingOfTheReservedTicket .jsp";
    }
}
