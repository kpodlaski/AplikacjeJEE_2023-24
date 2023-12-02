package pgtest;

import applogic.dao.DAO;
import applogic.jdbc.dao.DAOImpl;
import applogic.model.Department;
import applogic.model.Person;
import applogic.model.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.*;

public class PgTest {

    // ----------------------
    //Zapytania ręcznie bez wykorzystania wzorca DAO
    // -----------------------
    public static void main_v1(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:32768/postgres",
                "postgres","password");
        Statement stm = con.createStatement();
        int minId= 1;
        stm.execute("Select * from Pracownik where id>"+minId);
        ResultSet rs =  stm.getResultSet();
        while(rs.next()){
            System.out.println(rs.getString("imie"));
            System.out.println(rs.getInt(1));
            System.out.println("-------------");
        }
        rs.close();stm.close();
        System.out.println("**************");
        PreparedStatement pstm = con.prepareStatement("Select * from Pracownik where id>?");
        pstm.setInt(1,minId);
        pstm.execute();
        rs =  pstm.getResultSet();
        while(rs.next()){
            System.out.println(rs.getString("imie"));
            System.out.println(rs.getInt(1));
            System.out.println("-------------");
        }
        rs.close();pstm.close();
        con.close();

    }

    // ----------------------
    // Zapytania ręcznie bez wykorzystania wzorca DAO
    // -----------------------
    public static void main_1(String[] args) {

        String connectionString = "jdbc:postgresql://localhost:32768/postgres";
        String username = "postgres";
        String password = "password";
        DAO dao = new DAOImpl(connectionString, username, password);
        Position pos = dao.getPositionById(4);
        System.out.println(pos);
        //Create
        //pos = new Position("administrator systemow IT");
        //dao.insertPosition(pos);
        //Update
        //pos.setName("administrator systemów IT");
        //dao.updatePosition(pos);
        //Delete
        //pos = new Position(5," dowolne ");
        //dao.deletePosition(pos);
        System.out.println("------");
        for (Position p : dao.getPositionsByName("e")){
            System.out.println(p);
        }
        System.out.println("------");
        Person p = dao.getPersonById(2);
        System.out.println(p);
    }

    public static void main(String[] a){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Position s = em.find(Position.class,2);
        System.out.println(s.getId()+" "+s.getName());
        Person p = em.find(Person.class, 3);
        System.out.println(p.getName()+" "+p.getSurname());
        System.out.println(p.getPosition().getName());
        for(Department j : p.getDepartments()){
            System.out.println(j.getName());
        }
        System.out.println("-------------------");
    }
}
