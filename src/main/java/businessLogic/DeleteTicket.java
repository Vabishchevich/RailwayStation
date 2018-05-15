package businessLogic;

import command.ICommand;
import dao.PlaceDao;
import dao.TicketDao;
import entity.NumberRailCar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteTicket implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        List<String> idTicket = Arrays.asList(request.getParameterValues("tickets"));
        List<Integer> numberPlaces;
        numberPlaces = new ArrayList<>();
        for (int i = 0; i < idTicket.size(); i++) {
            numberPlaces.add(Integer.parseInt(request.getParameter(idTicket.get(i))));
        }
//        if (numberPlaces.isEmpty()) {
//            return "/error_notCheckedTicket.jsp";
//        }
        PlaceDao placeDao = new PlaceDao();
        List<NumberRailCar> numberRailCars = new ArrayList<>();
        for (int i = 0; i < idTicket.size(); i++) {
            numberRailCars.add(placeDao.getIdRailCar(Integer.parseInt(idTicket.get(i))));
        }
        TicketDao ticketDao = new TicketDao();
        for (int i = 0; i < idTicket.size(); i++) {
            placeDao.addPlace(numberRailCars.get(i).getNumberRailCar(), numberPlaces.get(i));
            placeDao.editBeforeDelete(placeDao.getIdRailCar(Integer.parseInt(idTicket.get(i))));
            ticketDao.deleteTicket(Integer.parseInt(idTicket.get(i)));
        }
        return "/HomePageUser.jsp";
    }
}
