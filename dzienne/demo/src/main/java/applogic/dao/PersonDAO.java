package applogic.dao;

import applogic.model.Department;
import applogic.model.Person;
import applogic.model.Position;

import java.util.List;

public interface PersonDAO {
    Person getPersonById(int id);
    List<Person> getPersonsByName(String name);
    List<Person> getPersonsBySurname(String sname);
    List<Person> getPersonsByPosition(Position position);
    List<Person> getPersonsInDepartment(Department department);
    boolean updatePerson(Person person);
    boolean deletePerson(Person person);
    Person insertPerson(Person person);
}
