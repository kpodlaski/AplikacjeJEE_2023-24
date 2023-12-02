package applogic.jpa.dao;

import applogic.dao.DAO;
import applogic.model.Department;
import applogic.model.Person;
import applogic.model.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.List;
import java.util.logging.Logger;

public class DAOImpl implements DAO {
    {
        emf = Persistence.createEntityManagerFactory("docker");
        em = emf.createEntityManager();
    }

    private Logger logger = Logger.getLogger("BazyDanych");

    PositionDAOImpl positionDAO;
    PersonDAOImpl personDAO;
    DepartmentDAOImpl departmentDAO;

    static EntityManagerFactory emf;
    static EntityManager em;

    public Logger getLogger(){
        return logger;
    }
    @Override
    public Position getPositionById(int id) {
        return positionDAO.getPositionById(id);
    }

    @Override
    public List<Position> getPositionsByName(String name) {
        return positionDAO.getPositionsByName(name);
    }

    @Override
    public boolean updatePosition(Position position) {
        return positionDAO.updatePosition(position);
    }

    @Override
    public Position insertPosition(Position position) {
        return positionDAO.insertPosition(position);
    }

    @Override
    public boolean deletePosition(Position position) {
        return positionDAO.deletePosition(position);
    }

    @Override
    public Person getPersonById(int id) {
        return personDAO.getPersonById(id);
    }

    @Override
    public List<Person> getPersonsByName(String name) {
        return personDAO.getPersonsByName(name);
    }

    @Override
    public List<Person> getPersonsBySurname(String sname) {
        return personDAO.getPersonsBySurname(sname);
    }

    @Override
    public List<Person> getPersonsByPosition(Position position) {
        return personDAO.getPersonsByPosition(position);
    }

    @Override
    public List<Person> getPersonsInDepartment(Department department) {
        return personDAO.getPersonsInDepartment(department);
    }

    @Override
    public boolean updatePerson(Person person) {
        return personDAO.updatePerson(person);
    }

    @Override
    public boolean deletePerson(Person person) {
        return personDAO.deletePerson(person);
    }

    @Override
    public Person insertPerson(Person person) {
        return personDAO.insertPerson(person);
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentDAO.getDepartmentById(id);
    }

    @Override
    public List<Department> getDepartmentsByName(String name) {
        return departmentDAO.getDepartmentsByName(name);
    }

    @Override
    public List<Department> getDepartmentsByPerson(Person person) {
        return departmentDAO.getDepartmentsByPerson(person);
    }

    @Override
    public boolean updateDepartment(Department dep) {
        return departmentDAO.updateDepartment(dep);
    }

    @Override
    public boolean deleteDepartment(Department dep) {
        return departmentDAO.deleteDepartment(dep);
    }

    @Override
    public Department insertDepartment(Department dep) {
        return departmentDAO.insertDepartment(dep);
    }
}
