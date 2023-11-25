package com.example.demo2;

import db.applogic.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.*;

public class DBTest {
    public static void main(String ... args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("org.postgresql.Driver");
        String connString= "jdbc:postgresql://localhost:32768/postgres?user=postgres";

        Connection conn = DriverManager.getConnection(connString);
        Statement stm = conn.createStatement();

        stm.execute("Select * from Jednostka");
        //stm.execute("Select * FROM pg_catalog.pg_tables");
        ResultSet rs = stm.getResultSet();
        while(rs.next()){
            System.out.println(rs.getString("nazwa"));
        }
        rs.close();
        stm.close();
        conn.close();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("localhost");
        EntityManager em = emf.createEntityManager();
        Position res = em.find(Position.class,2);
        System.out.println(res.getName()+" "+res.getId());
        em.close();
        emf.close();

    }
}
