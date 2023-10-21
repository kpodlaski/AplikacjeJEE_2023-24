package applogic;

public class Department {
    private int id;
    private String name;

    public Department(int id,String name) {
        this.id = id;
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
