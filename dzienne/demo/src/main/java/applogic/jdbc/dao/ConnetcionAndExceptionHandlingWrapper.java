package applogic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnetcionAndExceptionHandlingWrapper {
    Connection con;
    List<PreparedStatement> pstms = new ArrayList<>();
    boolean newConnection = false;
    public Connection startTry(DAOImpl dao, Connection connection) throws SQLException {
        if (connection == null){
            con = dao.createNewConnecton();
            newConnection = true;
        }
        else {
            con = connection;
        }
        return con;
    }
    public void finallyCause(Logger logger){
        try {
            for (PreparedStatement pstm : pstms){
                pstm.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE,"closing pstm", e);;
        }
        try {
            if (newConnection){
                con.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE,"closing connection", e);;
        }
    }

    public void catchCause(Logger logger, String msg, Exception e) {
        logger.log(Level.SEVERE, "sql operation", e);
    }
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        PreparedStatement pstm = con.prepareStatement(sql);
        pstms.add(pstm);
        return pstm;
    }
}
