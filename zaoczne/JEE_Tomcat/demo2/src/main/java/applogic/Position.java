package applogic;

public class Position {
    private int id;
    private String name;
    private Department department;

    public Position(int id, String name, Department department) {
        this.id = id;
        this.setName(name);
        this.setDepartment(department);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
