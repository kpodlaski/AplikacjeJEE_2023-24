package applogic.model;

import jakarta.persistence.*;

@Entity
@Table(name="Stanowisko")
public class Position {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nazwa")
    private String name;

    public Position(){}
    public Position(int id, String name){
        this(name);
        this.id = id;
    }
    public Position(String name) {
        this.name = name;
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

    public String toString(){
        return String.format("[%1$d] %2$s",id, name);
    }
}
