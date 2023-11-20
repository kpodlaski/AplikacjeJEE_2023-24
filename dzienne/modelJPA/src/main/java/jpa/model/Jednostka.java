package jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Jednostka {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nazwa")
    private String nazwa;
    @ManyToMany
    @JoinTable(name = "pracjednlnk", catalog = "postgres", schema = "public",
            joinColumns = @JoinColumn(name = "id_jedn", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_prac", referencedColumnName = "id"))
    private List<Pracownik> pracownicy;

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

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(List<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }
}
