package jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pracownik {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "imie")
    private String imie;
    @Basic
    @Column(name = "nazwisko")
    private String nazwisko;
    @ManyToOne
    @JoinColumn(name = "stanowisko", referencedColumnName = "id")
    private Stanowisko stanowisko;
    @ManyToMany(mappedBy = "pracownicy")
    private List<Jednostka> jednostki;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    public List<Jednostka> getJednostki() {
        return jednostki;
    }

    public void setJednostki(List<Jednostka> jednostki) {
        this.jednostki = jednostki;
    }
}
