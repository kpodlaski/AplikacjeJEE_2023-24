package applogic.dao;

import applogic.model.Department;
import applogic.model.Person;

import java.util.List;

public interface DepartmentDAO {
    Department getDepartmentById(int id);
    List<Department> getDepartmentsByName(String name);
    List<Department> getDepartmentsByPerson(Person person);
    boolean updateDepartment(Department dep);
    boolean deleteDepartment(Department dep);
    Department insertDepartment(Department dep);
}
