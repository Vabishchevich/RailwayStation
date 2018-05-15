package dao;

import daoconnect.ConnectionPool;
import entity.Rout;
import entity.Train;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainDao {

    private final ConnectionPool connectionPool;

    public TrainDao() {
        connectionPool = ConnectionPool.initConnection();
    }

    static final Logger logger = Logger.getLogger("TrainDao");

    public List<Train> selectionTrain(Rout rout) {
        List<Train> trains = new ArrayList<>();
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT t.NumberTrain, t.StartStation, t.EndStation, "
                    + "r.TimeStart,r.TimeEnd,SUM(v.CountPlaces) "
                    + "FROM train t "
                    + "INNER JOIN railcar v ON t.NumberTrain = v.NumberTrain "
                    + "INNER JOIN rout r ON t.NumberTrain = r.NumberTrain "
                    + "INNER JOIN date d ON t.NumberTrain = d.NumberTrain "
                    + "WHERE r.StartStation =" + "'" + rout.getStartStation() + "'"
                    + "AND r.EndStation =" + "'" + rout.getEndStation() + "'"
                    + "AND d.Date =" + "'" + rout.getStartDate() + "'"
                    + "AND v.CountPlaces != 0 "
                    + "GROUP BY t.NumberTrain");
            while (rs.next()) {
                trains.add(new Train(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTime(4), rs.getTime(5), rs.getInt(6)));
            }
            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trains;
    }

    public List<Train> selectionTrainTwo(Rout rout) {
        List<Train> trains = new ArrayList<>();
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT t.NumberTrain, t.StartStation, t.EndStation, "
                    + "r.TimeStart,r.TimeEnd,SUM(v.CountPlaces) "
                    + "FROM train t "
                    + "INNER JOIN railcar v ON t.NumberTrain = v.NumberTrain "
                    + "INNER JOIN rout r ON t.NumberTrain = r.NumberTrain "
                    + "INNER JOIN date d ON t.NumberTrain = d.NumberTrain "
                    + "WHERE d.Date =" + "'" + rout.getStartDate() + "'"
                    + "AND v.CountPlaces != 0 "
                    + "GROUP BY t.NumberTrain");
            while (rs.next()) {
                trains.add(new Train(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTime(4), rs.getTime(5), rs.getInt(6)));
            }
            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trains;
    }

    public Object addNewTrain(Train train) {
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO train VALUES(?,?,?)");
            preparedStatement.setString(1, train.numberTrain);
            preparedStatement.setString(2, train.startStation);
            preparedStatement.setString(3, train.endStation);
            preparedStatement.executeUpdate();
            connectionPool.freeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
