package applogic.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private int id = -1;
    private String name;
    private List<Person> personel = new ArrayList<>();

    public Department(int id, String name ){
        this(name);
        this.id = id;
    }
    public Department(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
