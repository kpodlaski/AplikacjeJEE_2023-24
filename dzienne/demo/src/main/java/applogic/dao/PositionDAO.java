package applogic.dao;

import applogic.model.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionDAO {
    Position getPositionById(int id) throws SQLException;
    List<Position> getPositionByName(String name) ;
    boolean updatePosition(Position position);
    Position insertPosition(Position position);
    boolean deletePosition(Position position);
}
