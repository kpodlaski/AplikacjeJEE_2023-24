package applogic.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Person> personel = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addPerson(Person p){
        personel.add(p);
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
}
