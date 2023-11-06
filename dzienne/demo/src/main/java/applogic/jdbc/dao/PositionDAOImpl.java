package applogic.jdbc.dao;

import applogic.dao.DAO;
import applogic.model.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class PositionDAOImpl implements applogic.dao.PositionDAO {
    private final DAO dao;
    private final String connectionString;

    public PositionDAOImpl(DAO dao, String connectionString){
        this.dao  = dao;
        this.connectionString = connectionString;
    }
    public List<Position> getPositionByName(Connection connection, String name) {
        List<Position> positions = new ArrayList<>();
        PreparedStatement pstm = null;
        ConnetcionAndExceptionHandlingWrapper conHandler = new ConnetcionAndExceptionHandlingWrapper();
        try {
            conHandler.startTry((DAOImpl) dao,connection, connectionString);
            pstm = conHandler.prepareStatement("Select id as sid, nazwa from Stanowisko where nazwa like ?");
            pstm.setString(1,'%'+name+'%');
            pstm.execute();
            ResultSet rs =  pstm.getResultSet();
            while(rs.next()) {
                positions.add(getPositionFromRS(rs));
            }
        }
        catch (SQLException e){
            conHandler.catchCause(dao.getLogger(),"sql query", e);
        }
        finally{
            conHandler.finallyCause(dao.getLogger());
        }
        return positions;
    }
    public boolean updatePosition(Connection connection, Position position) {
        ConnetcionAndExceptionHandlingWrapper conHandler = new ConnetcionAndExceptionHandlingWrapper();
        boolean result = false;
        try {
            conHandler.startTry((DAOImpl) dao, connection, connectionString);
            PreparedStatement pstm = conHandler.prepareStatement("UPDATE Stanowisko Set nazwa = ? WHERE id=?");

            pstm.setString(1, position.getName());
            pstm.setInt(2, position.getId());
            //Log query
            dao.getLogger().log(Level.INFO, "[SQL]"+pstm);
            result = pstm.execute();
        } catch (SQLException e) {
            conHandler.catchCause(dao.getLogger(),"sql operation", e);
        }
        finally {
            conHandler.finallyCause(dao.getLogger());
        }
        return result;
    }
    public Position insertPosition(Connection connection, Position position) {
        ConnetcionAndExceptionHandlingWrapper conHandler = new ConnetcionAndExceptionHandlingWrapper();
        boolean result = false;
        try {
            conHandler.startTry((DAOImpl) dao, connection, connectionString);
            PreparedStatement pstm = conHandler.prepareStatement("Select Max(id) From Stanowisko");
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            int maxId = 0;
            if (rs.next()) maxId = rs.getInt(1);
            position.setId(maxId+1);
            pstm = conHandler.prepareStatement("INSERT INTO Stanowisko VALUES(?,?)");
            pstm.setInt(1, position.getId());
            pstm.setString(2, position.getName());
            result = pstm.execute();
        } catch (SQLException e) {
            conHandler.catchCause(dao.getLogger(),"sql operation", e);
        }
        finally {
            conHandler.finallyCause(dao.getLogger());
        }
        if (result) return position;
        return null;
    }
    public boolean deletePosition(Connection connection, Position position) {
        ConnetcionAndExceptionHandlingWrapper conHandler = new ConnetcionAndExceptionHandlingWrapper();
        boolean result = false;
        try {
            conHandler.startTry((DAOImpl) dao, connection, connectionString);
            PreparedStatement pstm = conHandler.prepareStatement("DELETE FROM Stanowisko WHERE id=?");
            pstm.setInt(1, position.getId());
            result = pstm.execute();
        } catch (SQLException e) {
            conHandler.catchCause(dao.getLogger(),"sql operation", e);
        }
        finally {
            conHandler.finallyCause(dao.getLogger());
        }
        return result;
    }
    static Position getPositionFromRS(ResultSet rs) throws SQLException {
        String name = rs.getString("nazwa");
        int pid = rs.getInt("sid");
        return new Position(pid, name);
    }

    public Position getPositionById(Connection connection, int id){
        Position position = null;
        PreparedStatement pstm = null;
        ConnetcionAndExceptionHandlingWrapper conHandler = new ConnetcionAndExceptionHandlingWrapper();
        try {
            conHandler.startTry((DAOImpl) dao, connection, connectionString);
            pstm = conHandler.prepareStatement("Select id as sid, nazwa from Stanowisko where id=?");
            pstm.setInt(1, id);
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            while (rs.next()) {
                String name = rs.getString("nazwa");
                int pid = rs.getInt("sid");
                position = new Position(pid, name);
            }

        } catch (SQLException e) {
            conHandler.catchCause(dao.getLogger(),"sql operation", e);
        }
        finally {
            conHandler.finallyCause(dao.getLogger());
        }
        return position;
    }

    @Override
    public Position getPositionById(int id) {
        return getPositionById(null,id);
    }

    @Override
    public List<Position> getPositionByName(String name) {
        return getPositionByName(null,name);
    }

    @Override
    public boolean updatePosition(Position position) {
        return updatePosition(null, position);
    }

    @Override
    public Position insertPosition(Position position) {
        return insertPosition(null,position);
    }

    @Override
    public boolean deletePosition(Position position) {
        return deletePosition(null,position);
    }
}
