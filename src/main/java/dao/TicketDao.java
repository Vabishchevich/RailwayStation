package dao;

import entity.IdTables;
import entity.NumberPlace;
import entity.Rout;
import entity.Ticket;
import daoconnect.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketDao {

    private ConnectionPool connectionPool;

    public TicketDao() {
        connectionPool = ConnectionPool.initConnection();
    }

    static final Logger logger = Logger.getLogger("TicketDao");

    public List<Ticket> showTickets(String numberPassport) {
        List<Ticket> ticket = new ArrayList<>();
        int countPlaces = 0;
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select rout.StartStation,rout.EndStation,rout.TimeStart,"
                    + "rout.TimeEnd,rout.NumberTrain,ticket.NumberPassport,date.Date,"
                    + "railcar.NumberRailCar,railcar.TypeRailCar,ticket.IdTicket,ticket.NumberPlace\n"
                    + "from ticket\n"
                    + "inner join rout on ticket.IDRout = rout.IDRout\n"
                    + "inner join date on ticket.IDDate = date.IDDate\n"
                    + "inner join railcar on ticket.IDRailCar = railcar.IDRailCar\n"
                    + " where  ticket.NumberPassport = " + "'" + numberPassport + "'");
            while (rs.next()) {
                Rout rout = new Rout(rs.getString(1), rs.getString(2),
                        rs.getString(7));

                ticket.add(new Ticket(rout, rs.getString(5), rs.getString(9),
                        rs.getString(6), rs.getTime(3), rs.getTime(4),
                        rs.getInt(8), rs.getInt(11), rs.getInt(10)));
                countPlaces++;
            }
            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ticket;
    }

    public IdTables idTables(Ticket ticket) {
        IdTables idTables = new IdTables();
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select rout.IDRout,date.IDDate,railcar.IDRailCar "
                    + "from rout "
                    + "inner join date on rout.NumberTrain = date.NumberTrain "
                    + "inner join railcar on rout.NumberTrain = railcar.NumberTrain "
                    + "where rout.StartStation =" + "'" + ticket.getRout().getStartStation() + "'"
                    + "and rout.EndStation =" + "'" + ticket.getRout().getEndStation() + "'"
                    + "and rout.TimeStart =" + "'" + ticket.getStartTime() + "'"
                    + "and rout.TimeEnd =" + "'" + ticket.getEndTime() + "'"
                    + "and rout.NumberTrain=" + "'" + ticket.getNumberTrain() + "'"
                    + "and date.Date = " + "'" + ticket.getRout().getStartDate() + "'"
                    + "and railcar.NumberRailCar =" + "'" + ticket.getNumberRailCar() + "'"
                    + "and railcar.TypeRailCar =" + "'" + ticket.getWagonClass() + "'");
            while (rs.next()) {

                idTables = new IdTables(rs.getInt(1), rs.getInt(3), rs.getInt(2));
            }
            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(idTables);
        return idTables;
    }

    public int buyTicket(String passportNumber, IdTables idTables, int numberPlace) {
        System.out.println(passportNumber);
        System.out.println(idTables);
        int IdTicket = 0;
        try {
            Connection connection = connectionPool.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ticket");
            while (rs.next()) {
                if (IdTicket < rs.getInt(1)) {
                    IdTicket = rs.getInt(1);
                }
            }
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ticket VALUES(?,?,?,?,?,?)");
            IdTicket++;
            preparedStatement.setInt(1, IdTicket);
            preparedStatement.setInt(2, idTables.getIdRout());
            preparedStatement.setInt(3, idTables.getIdRailCar());
            preparedStatement.setString(4, passportNumber);
            preparedStatement.setInt(5, idTables.getIdDate());
            preparedStatement.setInt(6, numberPlace);

            preparedStatement.executeUpdate();
            connectionPool.freeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IdTicket;
    }

    public List<NumberPlace> showNumberPlace(String numberPassport) {
        List<NumberPlace> numberPlaceList = new ArrayList<>();

        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ticket.NumberPlace "
                    + "from ticket "
                    + "where ticket.NumberPassport = " + "'" + numberPassport + "'");
            while (rs.next()) {
                numberPlaceList.add(new NumberPlace(rs.getInt(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberPlaceList;
    }

    public void deleteTicket(int idTicket) {
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            int rs = st.executeUpdate("delete \n"
                    + "from ticket\n"
                    + "where ticket.IdTicket = " + "'" + idTicket + "'");

            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
