package applogic.dao;

import applogic.model.Person;
import applogic.model.Position;

import java.util.List;

public interface PersonDAO {
    Person getPersonById(int id);
    List<Person> getPersonByName(String name);
    List<Person> getPersonBySurname(String sname);
    List<Person> getPersonByPosition(Position position);
    boolean updatePerson(Person person);
    boolean deletePerson(Person person);
    Person insertPerson(Person person);
}
