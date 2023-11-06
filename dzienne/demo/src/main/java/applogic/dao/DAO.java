package applogic.dao;

import java.util.logging.Logger;

public interface DAO extends DepartmentDAO, PersonDAO, PositionDAO{
    public Logger getLogger();
}
