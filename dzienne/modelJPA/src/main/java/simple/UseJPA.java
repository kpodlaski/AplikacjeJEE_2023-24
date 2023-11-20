package simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jpa.model.Jednostka;
import jpa.model.Pracownik;
import jpa.model.Stanowisko;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

public class UseJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Stanowisko s = em.find(Stanowisko.class,2);
        System.out.println(s.getId()+" "+s.getNazwa());
        Pracownik p = em.find(Pracownik.class, 3);
        System.out.println(p.getImie()+" "+p.getNazwisko());
        System.out.println(p.getStanowisko().getNazwa());
        for(Jednostka j : p.getJednostki()){
            System.out.println(j.getNazwa());
        }
        System.out.println("-------------------");
        Query q = em.createQuery("select s from Stanowisko as s where s.nazwa like :nazwa ");
        q.setParameter("nazwa", "se%");
        for(Object o : q.getResultList()){
            System.out.println(o);
            Stanowisko st = (Stanowisko) o;
            System.out.println(st.getNazwa());
        }
        Stanowisko s1 = new Stanowisko();
        s1.setNazwa("praktykant");
        em.persist(s1);
        System.out.println(s1.getId());
        em.close();
    }
}
