package applogic.jpa.dao;

import applogic.dao.DepartmentDAO;
import applogic.model.Department;
import applogic.model.Person;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public Department getDepartmentById(int id) {
        return null;
    }

    @Override
    public List<Department> getDepartmentsByName(String name) {
        return null;
    }

    @Override
    public List<Department> getDepartmentsByPerson(Person person) {
        return null;
    }

    @Override
    public boolean updateDepartment(Department dep) {
        return false;
    }

    @Override
    public boolean deleteDepartment(Department dep) {
        return false;
    }

    @Override
    public Department insertDepartment(Department dep) {
        return null;
    }
}
