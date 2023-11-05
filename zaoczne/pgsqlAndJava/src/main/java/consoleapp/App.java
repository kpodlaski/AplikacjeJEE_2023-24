package consoleapp;

import jakarta.persistence.*;
import model.Jednostka;
import model.Pracownik;
import model.Stanowisko;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Stanowisko res = em.find(Stanowisko.class,2);
        System.out.println(res.getNazwa());
        Pracownik prac = em.find(Pracownik.class,1);
        System.out.println(prac.getId()+" "+prac.getNazwisko());
        System.out.println(prac.getStanowisko().getNazwa());
        Jednostka jedn = em.find(Jednostka.class, 2);
        System.out.println(jedn.getNazwa());
        System.out.println(jedn.getPracownicy());
        Query q =em.createQuery(
                "select p from Pracownik as p where imie like '%l%'");
        System.out.println("Zapytanie o Agaty");
        for (Object p : q.getResultList()){
            System.out.println(p.getClass().getName());
            System.out.println( ((Pracownik) p).getNazwisko());
        }
        Query nq = em.createNamedQuery("PracownikByNazwisko");
        nq.setParameter("nazw", "Alicewska");
        for (Pracownik p : (List<Pracownik>) nq.getResultList()){
            System.out.println(p.getImie()+" "+p.getNazwisko() );
        }
    }
}
