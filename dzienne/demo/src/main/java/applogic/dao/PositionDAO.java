package applogic.dao;

import applogic.model.Position;

import java.util.List;

public interface PositionDAO {
    Position getPositionById(int id);
    List<Position> getPositionsByName(String name);
    boolean updatePosition(Position position);
    Position insertPosition(Position position);
    boolean deletePosition(Position position);
}
