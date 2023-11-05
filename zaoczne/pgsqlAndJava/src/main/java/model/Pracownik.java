package model;

import jakarta.persistence.*;

@NamedQueries({
        @NamedQuery(name="PracownikByImie", query = "select p from Pracownik as p where imie=:imie"),
        @NamedQuery(name="PracownikByNazwisko", query = "select p from Pracownik as p where nazwisko=:nazw"),
})
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

    @OneToOne
    @JoinColumn(name="stanowisko",
            referencedColumnName = "id")
    private Stanowisko stanowisko;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pracownik pracownik = (Pracownik) o;

        if (id != pracownik.id) return false;
        if (imie != null ? !imie.equals(pracownik.imie) : pracownik.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(pracownik.nazwisko) : pracownik.nazwisko != null) return false;
        if (stanowisko != null ? !stanowisko.equals(pracownik.stanowisko) : pracownik.stanowisko != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (stanowisko != null ? stanowisko.hashCode() : 0);
        return result;
    }


}
