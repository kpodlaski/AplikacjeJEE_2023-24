package applogic;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Person> personel = new ArrayList<>();

    public Company(){
        name = "Firma Krzak abc";
        Department d = new Department(1,"Księgowość");
        Position p = new Position(1,"Główna Księgowa",d);
        Person person = new Person(1,"Alicja","Alicewska", p);
        getPersonel().add(person);
        p = new Position(2,"ksiegowy",d);
        person = new Person(2,"Tomasz","Tomaszewski", p);
        getPersonel().add(person);
        d = new Department(2,"IT");
        p = new Position(3,"Administartor Systemów IT",d);
        person = new Person(3,"Anna","Annewska",p);
        getPersonel().add(person);

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
        for(Person p : personel){
            if (p.getName().equals(name)){
                result = p;
                break;
            }
        }
        return result;
    }
    public Person findPersonById(int id){
        Person result = null;
        for(Person p : personel){
            if (p.getId() == id){
                result = p;
                break;
            }
        }
        return result;
    }

    public Department findDepartmentById(int id){
        Person result = null;
        for(Person p : personel){
            if (p.getPosition().getDepartment().getId() == id){
                result = p;
                break;
            }
        }
        if (result != null)
            return result.getPosition().getDepartment();
        else
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
