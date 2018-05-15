package dao;

import daoconnect.*;
import entity.CountPlace;
import entity.NumberPlace;
import entity.NumberRailCar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlaceDao {

    private final ConnectionPool connectionPool;

    public PlaceDao() {
        connectionPool = ConnectionPool.initConnection();
    }

    static final Logger logger = Logger.getLogger("PlaceDao");

    public List<NumberRailCar> getNumberRailCar(CountPlace countPlace, String numberTrain) {
        List<NumberRailCar> numberRailCars = new ArrayList<>();
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select distinct NumberRailCar "
                    + " from railcar "
                    + " where railcar.TypeRailCar =" + "'" + countPlace.getTypeRailCar() + "'"
                    + "and railcar.NumberTrain = " + "'" + numberTrain + "'"
                    + "and railcar.CountPlaces != 0");
            while (rs.next()) {
                numberRailCars.add(new NumberRailCar(rs.getInt(1)));
            }
            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberRailCars;
    }

    public List<NumberPlace> getPlace(int numberRailCar, String numberTrain) {
        List<NumberPlace> numberPlaces = new ArrayList<>();
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select NumberPlace\n"
                    + " from place\n"
                    + " inner join railcar on place.IdRailCar = railcar.IDRailCar\n"
                    + " where  railcar.NumberRailCar = " + "'" + numberRailCar + "'"
                    + " and railcar.NumberTrain = " + "'" + numberTrain + "'"
                    + " order by NumberPlace Desc limit 1 ");
            while (rs.next()) {
                numberPlaces.add(new NumberPlace(rs.getInt(1)));
            }
            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberPlaces;
    }

    public void deletePlace(NumberPlace numberPlace) {
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            int rs = st.executeUpdate("delete \n"
                    + " from place\n"
                    + " where place.NumberPlace = " + "'" + numberPlace.getNumberPlace() + "'");
            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public NumberRailCar getIdRailCar(int idTicket) {
        NumberRailCar numberRailCar = new NumberRailCar();
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ticket.IdRailCar \n"
                    + "from ticket \n"
                    + "where ticket.idTicket =" + "'" + idTicket + "'");
            while (rs.next()) {

                numberRailCar.setNumberRailCar(rs.getInt(1));
            }
            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberRailCar;
    }

    public void addPlace(int idRailCar, int numberPlace) {
        try {
            Connection connection = connectionPool.getConnection();
            int IdPlace = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM place");
            while (rs.next()) {
                if (IdPlace < rs.getInt(1)) {
                    IdPlace = rs.getInt(1);
                }
            }
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO place VALUES(?,?,?)");
            IdPlace++;
            preparedStatement.setInt(1, IdPlace);
            preparedStatement.setInt(2, idRailCar);
            preparedStatement.setInt(3, numberPlace);

            preparedStatement.executeUpdate();
            connectionPool.freeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void edit(int idRailCar) {
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            PreparedStatement ps
                    = con.prepareStatement("UPDATE railcar SET CountPlaces = CountPlaces - 1 "
                            + " WHERE IDRailCar = " + "'"
                            + idRailCar + "'");
            ps.executeUpdate();
            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PlaceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editBeforeDelete(NumberRailCar idRailCar) {
        try {
            Connection con1 = connectionPool.getConnection();
            Statement st = con1.createStatement();
            PreparedStatement ps1
                    = con1.prepareStatement("UPDATE railcar SET CountPlaces = CountPlaces + 1 "
                            + " WHERE IDRailCar = " + "'"
                            + idRailCar.getNumberRailCar() + "'");
            ps1.executeUpdate();
            connectionPool.freeConnection(con1);
        } catch (SQLException ex) {
            Logger.getLogger(PlaceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
