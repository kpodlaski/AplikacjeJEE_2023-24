package applogic.jdbc.dao;

import applogic.dao.DAO;
import applogic.dao.PersonDAO;
import applogic.dao.PositionDAO;
import applogic.model.Person;
import applogic.model.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private final DAO dao;
    private final String connectionString;

    public PersonDAOImpl(DAO dao, String connectionString) {
        this.dao = dao;
        this.connectionString = connectionString;
    }


    public Person getPersonById(Connection connection, int id) {
        Person person = null;
        PreparedStatement pstm = null;
        ConnetcionAndExceptionHandlingWrapper conHandler = new ConnetcionAndExceptionHandlingWrapper();
        try {
            conHandler.startTry((DAOImpl) dao, connection, connectionString);
            pstm = conHandler.prepareStatement("SELECT pracownik.id as pid, imie, nazwisko, stanowisko.id as sid, nazwa FROM Pracownik, Stanowisko WHERE pracownik.id=? AND pracownik.stanowisko=stanowisko.id");
            pstm.setInt(1, id);
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            while (rs.next()) {
                person = getPersonFromRS(rs);
            }

        } catch (SQLException e) {
            conHandler.catchCause(dao.getLogger(),"sql operation", e);
        }
        finally {
            conHandler.finallyCause(dao.getLogger());
        }
        return person;
    }



    public List<Person> getPersonByName(Connection connection, String name) {
        return null;
    }

    public List<Person> getPersonBySurname(Connection connection, String sname) {
        return null;
    }

    public List<Person> getPersonByPosition(Connection connection, Position position) {
        return null;
    }

    public boolean updatePerson(Connection connection, Person person) {
        return false;
    }

    public boolean deletePerson(Connection connection, Person person) {
        return false;
    }

    public Person insertPerson(Connection connection, Person person) {
        return null;
    }

    Person getPersonFromRS(ResultSet rs) throws SQLException {
        int pid = rs.getInt("pid");
        String name = rs.getString("imie");
        String surname = rs.getString("nazwisko");
        Position position = PositionDAOImpl.getPositionFromRS(rs);
        return new Person(pid,name,surname,position);
    }

    public Person getPersonById(int id) {
        return getPersonById(null, id);
    }

    @Override
    public List<Person> getPersonByName(String name) {
        return getPersonByName(null,name);
    }

    @Override
    public List<Person> getPersonBySurname(String sname) {
        return getPersonBySurname(null,sname);
    }

    @Override
    public List<Person> getPersonByPosition(Position position) {
        return getPersonByPosition(null,position);
    }

    @Override
    public boolean updatePerson(Person person) {
        return updatePerson(null, person);
    }

    @Override
    public boolean deletePerson(Person person) {
        return deletePerson(null,person);
    }

    @Override
    public Person insertPerson(Person person) {
        return insertPerson(null,person);
    }
}
