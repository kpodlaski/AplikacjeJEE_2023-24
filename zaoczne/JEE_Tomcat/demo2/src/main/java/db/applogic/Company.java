package db.applogic;

import applogic.Department;
import applogic.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Person> personel = new ArrayList<>();

    public Company(){


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersonel() {
        return personel;
    }

    public void setPersonel(List<Person> personel) {
        this.personel = personel;
    }

    public Person findPersonByName(String name){
        Person result = null;

        return result;
    }
    public Person findPersonById(int id){

        return null;
    }

    public Department findDepartmentById(int id){

            return null;
    }

    public List<Person> getPersonsInDepartment(Department d){
        List<Person> result = new ArrayList<>();
        for(Person p : getPersonel() ) {
            if (p.getPosition().getDepartment().getId() == d.getId()) {
                result.add(p);
            }
        }
        return result;
    }


}
