package applogic.model;

public class Position {
    private int id = -1;
    private String name;

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
