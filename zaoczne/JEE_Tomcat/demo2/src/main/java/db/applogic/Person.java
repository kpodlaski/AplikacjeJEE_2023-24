package db.applogic;


import jakarta.persistence.*;

@NamedQueries({
        @NamedQuery(name="PersonByName", query = "select p from Person as p where name=:name"),
        @NamedQuery(name="PersonBySurname", query = "select p from Person as p where surname=:surname"),
})
@Entity
@Table(name="Pracownik")
public class Person {

        @Id
        @Column(name = "id")
        private int id;
        @Basic
        @Column(name = "imie")
        private String name;
        @Basic
        @Column(name = "nazwisko")
        private String surname;

        @OneToOne
        @JoinColumn(name="stanowisko",
                referencedColumnName = "id")
        private Position position;

        public Person(){}
        public Person(int id, String name, String surname, Position position) {
            this.id = id;
            this.setName(name);
            this.setSurname(surname);
            this.setPosition(position);
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person pracownik = (Person) o;

        if (id != pracownik.id) return false;
        if (name != null ? !name.equals(pracownik.name) : pracownik.name != null) return false;
        if (surname != null ? !surname.equals(pracownik.surname) : pracownik.surname != null) return false;
        if (position != null ? !position.equals(pracownik.position) : pracownik.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
