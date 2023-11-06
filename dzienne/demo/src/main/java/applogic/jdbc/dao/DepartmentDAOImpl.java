package applogic.jdbc.dao;

import applogic.dao.DAO;
import applogic.dao.DepartmentDAO;
import applogic.model.Department;
import applogic.model.Person;

import java.sql.Connection;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    private final DAO dao;
    private final String connectionString;

    public DepartmentDAOImpl(DAO dao, String connectionString){
        this.dao =dao;
        this.connectionString = connectionString;
    }


    public Department getDepartmentById(Connection connection, int id) {
        return null;
    }

    public List<Department> getDepartmentByName(Connection connection, String name) {
        return null;
    }

    public List<Department> getDepartmentByPerson(Connection connection, Person person) {
        return null;
    }

    public boolean updateDepartment(Connection connection, Department dep) {
        return false;
    }

    public boolean deleteDepartment(Connection connection, Department dep) {
        return false;
    }

    public Department insertDepartment(Connection connection, Department dep) {
        return null;
    }

    @Override
    public Department getDepartmentById(int id) {
        return getDepartmentById(null,id);
    }

    @Override
    public List<Department> getDepartmentByName(String name) {
        return getDepartmentByName(null,name);
    }

    @Override
    public List<Department> getDepartmentByPerson(Person person) {
        return getDepartmentByPerson(null, person);
    }

    @Override
    public boolean updateDepartment(Department dep) {
        return updateDepartment(null,dep);
    }

    @Override
    public boolean deleteDepartment(Department dep) {
        return deleteDepartment(null,dep);
    }

    @Override
    public Department insertDepartment(Department dep) {
        return insertDepartment(null,dep);
    }
}
