package dao;

import daoconnect.ConnectionPool;
import entity.UserView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {

    private final ConnectionPool connectionPool;

    public UserDao() {
        connectionPool = ConnectionPool.initConnection();
    }

    static final Logger logger = Logger.getLogger("UserDao");

    public Object addUser(UserView user) {
        try {
            Connection connection = connectionPool.getConnection();
            int userid = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                if (userid < rs.getInt(1)) {
                    userid = rs.getInt(1);
                }
            }
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES(?,?,?,?)");
            userid++;
            preparedStatement.setInt(1, userid);
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());

            preparedStatement.executeUpdate();
            connectionPool.freeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<UserView> viewAllUsers(UserView user) {
        List<UserView> usersAll = new ArrayList<>();
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users"
            //                    + "WHERE users.role =" + "'" + user.getRole()
            //                    + "GROUP BY u.userid"
            );
            while (rs.next()) {
                usersAll.add(new UserView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TrainDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersAll;
    }

    public void deleteUsers(int usersAll) {
        try {
            Connection con = connectionPool.getConnection();
            Statement st = con.createStatement();
            int rs = st.executeUpdate("delete \n"
                    + "from users\n"
                    + "where users.userid = " + "'" + usersAll + "'");

            connectionPool.freeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
