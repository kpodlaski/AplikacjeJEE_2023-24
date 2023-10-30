package applogic.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Department> departments = new ArrayList<>();

    public List<Department> getDepartments() {
        return departments;
    }

    public Company(){
        Position pos = new Position("Kierownik");
        Person p = new Person("Anna","Annewska", pos);
        Department dep = new Department("Marketing");
        dep.addPerson(p);
        pos = new Position("Specjalista");
        p = new Person("Tomasz","Tomaszewski", pos);
        dep.addPerson(p);
        departments.add(dep);
        p = new Person("Zofia","Zoficka", pos);
        dep = new Department("Produkcja");
        dep.addPerson(p);
        pos = new Position("Inżynier produkcji");
        p = new Person("Adam", "Adamski", pos);
        dep.addPerson(p);
        departments.add(dep);
    }


}
