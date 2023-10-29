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

    public List<Position> getPositionsByName(String Name, Connection conn) {
        return positionDAO.getPositionsByNazwa(Name, conn);
    }

    public Position insertPosition(Position position, Connection conn) {
        return positionDAO.insertPosition(position, conn);
    }

    public Position updatePosition(Position position, Connection conn) {
        return positionDAO.updatePosition(position, conn);
    }

    public int deletePosition(Position position, Connection conn) {
        return positionDAO.deletePosition(position, conn);
    }

    public Position insertOrUpdatePosition(Position position, Connection conn) {
        return positionDAO.insertOrUpdatePosition(position, conn);
    }

    public List<Person> getPersonsByName(String name, Connection conn) {
        return personDAO.getPersonsByName(name, conn);
    }

    public List<Person> getPersonsBySurname(String surname, Connection conn) {
        return personDAO.getPersonsBySurname(surname, conn);
    }

    public List<Person> getPersonsByPosition(Position position, Connection conn) {
        return personDAO.getPersonsByPosition(position, conn);
    }

    public List<Person> getPersonsByNameAndSurname(String name, String surname, Connection conn) {
        return personDAO.getPersonsByNameAndSurname(name, surname, conn);
    }

    public Person updatePerson(Person p, Connection conn) {
        return personDAO.updatePerson(p, conn);
    }

    public Person insertPerson(Person p, Connection conn) {
        return personDAO.insertPerson(p, conn);
    }

    public int deletePerson(Person person, Connection conn) {
        return personDAO.deletePerson(person, conn);
    }

}
