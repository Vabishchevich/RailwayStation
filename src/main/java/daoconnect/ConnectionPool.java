package daoconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue; //������������� ���������������� � ������������� ������������
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPool {

    private static final String driverClassName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/railwaystation";
    private static final String username = "root";
    private static final String password = "root";
    private static final int maxConnection = 50;
    private static ArrayBlockingQueue<Connection> freeConnections; //ArrayBlockingQueue - ���������� ������������� ������������� ������, �.�. 
    //������������ ����� ��������� ����������� (FIFO).
    private static ArrayBlockingQueue<Connection> allConnections;
    private static ConnectionPool connectionPool;

    private static final Logger logger = Logger.getLogger(ConnectionPool.class.getName()); //��������� ������� �� ����� ������

    private ConnectionPool() {
        freeConnections = new ArrayBlockingQueue<>(maxConnection);
        allConnections = new ArrayBlockingQueue<>(maxConnection);
    }

    public static ConnectionPool initConnection() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
            try {
                Class.forName(driverClassName); //���� ��� ������ �� �������� � ������ ����������, �� ���������� ��������� �� ����� 
                //���������� ���������, ����� ������������ ����� forName(), ����� �������� ������ Class
                int i = 0;
                while (i != maxConnection) {
                    freeConnections.add(newConnection());
                    i++;
                }
                allConnections.addAll(freeConnections);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connectionPool;
    }

    public Connection getConnection() throws SQLException {
        Connection con;
        if (!freeConnections.isEmpty()) {
            con = (Connection) freeConnections.poll(); //poll - ���������� � ��������� ������� �� ������ �������. ���� ������� �����, ���������� 
            //�������� null
            if (con.isClosed()) {
                allConnections.remove(); //remove - ���������� � ��������� ������� �� ������ �������. ���� ������� �����, ���������� ���������� 
                //NoSuchElementException
                con = newConnection();
                allConnections.add(con);
            }
        } else {
            con = newConnection();
        }
        return con;
    }

    private static Connection newConnection() throws SQLException {
        Connection con;
        con = DriverManager.getConnection(url, username, password);
        return con;
    }

    //����������������� ���� ���� ����� ���� �������� ������ ����� ������� ������������
    public synchronized void freeConnection(Connection con) {
        if ((con != null) && (freeConnections.size() <= maxConnection)) {
            freeConnections.add(con);
        }
    }

    public void closeConnection() {
        for (Connection con : allConnections) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        freeConnections.clear();
    }

    @Override
    protected void finalize() throws Throwable { //����� Throwable ���������� ���� ������ � ���������� �� ����� Java
        super.finalize();
        closeConnection();
    }
}
