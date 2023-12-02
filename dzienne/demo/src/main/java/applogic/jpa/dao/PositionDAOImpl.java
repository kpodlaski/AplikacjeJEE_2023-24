package applogic.jpa.dao;

import applogic.dao.PositionDAO;
import applogic.model.Position;

import java.util.List;

public class PositionDAOImpl implements PositionDAO {
    @Override
    public Position getPositionById(int id) {
        return null;
    }

    @Override
    public List<Position> getPositionsByName(String name) {
        return null;
    }

    @Override
    public boolean updatePosition(Position position) {
        return false;
    }

    @Override
    public Position insertPosition(Position position) {
        return null;
    }

    @Override
    public boolean deletePosition(Position position) {
        return false;
    }
}
