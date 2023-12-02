package applogic.jpa.dao;

import applogic.dao.PersonDAO;
import applogic.model.Department;
import applogic.model.Person;
import applogic.model.Position;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public Person getPersonById(int id) {

        Person p = DAOImpl.em.find(Person.class, id);
        return p;
    }

    @Override
    public List<Person> getPersonsByName(String name) {
        return null;
    }

    @Override
    public List<Person> getPersonsBySurname(String sname) {
        return null;
    }

    @Override
    public List<Person> getPersonsByPosition(Position position) {
        return null;
    }

    @Override
    public List<Person> getPersonsInDepartment(Department department) {
        return null;
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean deletePerson(Person person) {
        return false;
    }

    @Override
    public Person insertPerson(Person person) {
        return null;
    }
}
