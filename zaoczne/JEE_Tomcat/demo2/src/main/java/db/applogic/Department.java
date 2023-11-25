package db.applogic;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name="Jednostka")
public class Department {
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
    private Collection<Person> personel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nazwa) {
        this.name = nazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department jednostka = (Department) o;

        if (id != jednostka.id) return false;
        if (name != null ? !name.equals(jednostka.name) : jednostka.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Person> getPersonel() {
        return personel;
    }

    public void setPersonel(Collection<Person> personel) {
        this.personel = personel;
    }
}
