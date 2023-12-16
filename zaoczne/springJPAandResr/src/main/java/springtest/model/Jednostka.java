package springtest.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Jednostka {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nazwa")
    private String nazwa;
    @ManyToMany
    @JoinTable(name = "pracjednlnk", //catalog = "postgres", schema = "public",
            joinColumns = @JoinColumn(name = "id_jedn", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_prac", referencedColumnName = "id"))
    private Collection<Pracownik> pracownicy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jednostka jednostka = (Jednostka) o;

        if (id != jednostka.id) return false;
        if (nazwa != null ? !nazwa.equals(jednostka.nazwa) : jednostka.nazwa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        return result;
    }

    public Collection<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(Collection<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }
}
