package applogic.jdbc.dao;

import applogic.dao.DAO;
import applogic.model.Department;
import applogic.model.Person;
import applogic.model.Position;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class DAOImpl implements DAO {
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private String connectionString;
    private String user;
    private String passwd;
    private Logger logger = Logger.getLogger("BazyDanych");

    PositionDAOImpl positionDAO;
    PersonDAOImpl personDAO;
    DepartmentDAOImpl departmentDAO;

    public DAOImpl(String connectionString, String username, String password){
        this();
        this.connectionString=connectionString;
        this.user = username;
        this.passwd=password;
    }

    public DAOImpl() {
        positionDAO = new PositionDAOImpl(this);
        personDAO = new PersonDAOImpl(this);
        departmentDAO = new DepartmentDAOImpl(this);
    }

    public Logger getLogger(){
        return logger;
    }
    Connection createNewConnecton() throws SQLException {
        return DriverManager.getConnection(connectionString, user, passwd);
    }

    public String getConnectionString() {
        return connectionString;
    }

    public String getUser() {
        return user;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public Position getPositionById(Connection connection, int id){
        return positionDAO.getPositionById(connection, id);
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



    public List<Position> getPositionByName(Connection connection, String name){
        return positionDAO.getPositionByName(connection, name);
    }


    public boolean updatePosition(Connection connection, Position position) {
        return positionDAO.updatePosition(connection, position);
    }


    public Position insertPosition(Connection connection, Position position) {
        return positionDAO.insertPosition(connection, position);
    }


    public boolean deletePosition(Connection connection, Position position) {
        return positionDAO.deletePosition(connection, position);
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

    public List<Person> getPersonsInDepartment(Connection connection, Department department) {
        return personDAO.getPersonsInDepartment(connection, department);
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

    public Person getPersonById(Connection connection, int id) {
        return personDAO.getPersonById(connection, id);
    }


    public List<Person> getPersonByName(Connection connection, String name) {
        return personDAO.getPersonByName(connection, name);
    }


    public List<Person> getPersonBySurname(Connection connection, String sname) {
        return personDAO.getPersonBySurname(connection, sname);
    }


    public List<Person> getPersonByPosition(Connection connection, Position position) {
        return personDAO.getPersonByPosition(connection, position);
    }



    public boolean updatePerson(Connection connection, Person person) {
        return personDAO.updatePerson(connection, person);
    }


    public boolean deletePerson(Connection connection, Person person) {
        return personDAO.deletePerson(connection, person);
    }


    public Person insertPerson(Connection connection, Person person) {
        return personDAO.insertPerson(connection, person);
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

    public Department getDepartmentById(Connection connection, int id) {
        return departmentDAO.getDepartmentById(connection, id);
    }


    public List<Department> getDepartmentByName(Connection connection, String name) {
        return departmentDAO.getDepartmentByName(connection, name);
    }


    public List<Department> getDepartmentByPerson(Connection connection, Person person) {
        return departmentDAO.getDepartmentByPerson(connection, person);
    }


    public boolean updateDepartment(Connection connection, Department dep) {
        return departmentDAO.updateDepartment(connection, dep);
    }


    public boolean deleteDepartment(Connection connection, Department dep) {
        return departmentDAO.deleteDepartment(connection, dep);
    }


    public Department insertDepartment(Connection connection, Department dep) {
        return departmentDAO.insertDepartment(connection, dep);
    }


}
