package applogic.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Jednostka")
public class Department {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nazwa")
    private String name;
    @ManyToMany
    @JoinTable(name = "pracjednlnk", catalog = "postgres", schema = "public",
            joinColumns = @JoinColumn(name = "id_jedn", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_prac", referencedColumnName = "id"))
    private List<Person> personel = new ArrayList<>();

    public Department(){}
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
