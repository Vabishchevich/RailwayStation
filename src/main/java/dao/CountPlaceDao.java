package dao;

import daoconnect.*;
import entity.CountPlace;
import entity.NumberTrain;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountPlaceDao {

    private final List<CountPlace> countPlaces;
    private final ConnectionPool connectionPool;

    static final Logger logger = Logger.getLogger("CountPlaceDao");
    private static final String SELECT_QUERY = "select railcar.TypeRailCar, sum(railcar.CountPlaces) from railcar \n"
            + "where railcar.NumberTrain = ? \n"
            + "and railcar.CountPlaces != 0 "
            + "group by railcar.TypeRailCar";

    public CountPlaceDao() {
        countPlaces = new ArrayList<>();
        connectionPool = ConnectionPool.initConnection();
    }

    public List<CountPlace> getNumberPlace(NumberTrain numberTrain) {
        try {
            Connection con = connectionPool.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, numberTrain.getNumberTrain());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                countPlaces.add(new CountPlace(rs.getInt(2), rs.getString(1)));
            }
            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countPlaces;
    }
}
