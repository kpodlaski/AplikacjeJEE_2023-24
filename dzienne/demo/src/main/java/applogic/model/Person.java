package applogic.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Pracownik")
public class Person {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "imie")
    private String name;
    @Basic
    @Column(name = "nazwisko")
    private String surname;
    @ManyToOne
    @JoinColumn(name = "stanowisko", referencedColumnName = "id")
    private Position position;
    @ManyToMany(mappedBy = "personel")
    private List<Department> departments = new ArrayList<>();

    public Person(){}
    public Person (int id, String name, String surname, Position position){
        this(name,surname,position);
        this.id = id;
    }

    public Person(String name, String surname, Position position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String toString(){
        return String.format("[%1$d] %2$s %3$s, stanowisko: %4$s",id, name, surname, position);
    }
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> jednostki) {
        this.departments = jednostki;
    }
}
