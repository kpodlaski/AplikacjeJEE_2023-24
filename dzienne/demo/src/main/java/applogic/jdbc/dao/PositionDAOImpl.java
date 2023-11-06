package applogic.jdbc.dao;

import applogic.model.Person;
import applogic.model.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PositionDAOImpl implements applogic.dao.PositionDAO {
    private final Connection con;

    public PositionDAOImpl(Connection con){
        this.con  = con;
    }
    @Override
    
    public Position getPositionById(int id) throws SQLException {
        Position position = null;
        PreparedStatement pstm = con.prepareStatement("Select * from Stanowisko where id>?");
        pstm.setInt(1,id);
        pstm.execute();
        ResultSet rs =  pstm.getResultSet();
        while(rs.next()){
            String name = rs.getString("nazwa");
            int pid = rs.getInt("id");
            position = new Position(pid, name);
        }
        rs.close();pstm.close();
        return position;
    }
    @Override
    public List<Position> getPositionByName(String name) {return null;}
    @Override
    public boolean updatePosition(Position position) {return false;}
    @Override
    public Position insertPosition(Position position) {return null;}
    @Override
    public boolean deletePosition(Position position) {return false;}
}
