package db.applogic.dao;

import db.applogic.Person;
import db.applogic.Position;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DAO {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    String connString= "jdbc:postgresql://172.17.0.2:5432/postgres?user=postgres";

    private PositionDAO positionDAO = new PositionDAO(this);
    private PersonDAO personDAO = new PersonDAO(this);

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connString);
    }

    public Person getPersonById(int id, Connection conn) {
        return personDAO.getPersonById(id, conn);
    }

    public List<Person> getAllPersons(Connection conn) {
        return personDAO.getAllPersons(conn);
    }

    public List<Position> getAllPositions(Connection conn) {
        return positionDAO.getAllPositions(conn);
    }

    public Position getPositionById(int id, Connection conn) {
        return positionDAO.getPositionById(id, conn);
    }
}
