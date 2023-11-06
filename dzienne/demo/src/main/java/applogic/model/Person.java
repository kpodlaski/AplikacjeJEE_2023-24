package applogic.model;

public class Person {
    private int id = -1;
    private String name;
    private String surname;
    private Position position;

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
}
