package applogic.dao;

import applogic.model.Department;
import applogic.model.Person;

import java.util.List;

public interface DepartmentDAO {
    Department getDepartmetById(int id);
    List<Department> getDepartmentByName(String name);
    List<Department> getDepartmentByPerson(Person person);
    boolean updateDepartment(Department dep);
    boolean deleteDepartment(Department dep);
    Department insertDepartment(Department dep);
}
