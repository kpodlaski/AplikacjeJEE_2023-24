package db.applogic.dao;

import db.applogic.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private DAO DAO;

    public PersonDAO(DAO dao) {
        this.DAO = dao;
    }

    public Person getPersonById(int id, Connection conn){
            Person result = null;
            boolean needCloseConn = false;
            try {
                if (conn == null) {
                    conn = this.DAO.getConnection();
                    needCloseConn = true;
                }
                Statement stm = conn.createStatement();
                stm.execute("Select * from Pracownik where id=" + id);
                //stm.execute("Select * FROM pg_catalog.pg_tables");
                ResultSet rs = stm.getResultSet();
                while (rs.next()) {
                    Position position = DAO.getPositionById(rs.getInt("stanowisko"), conn);
                    result = new Person(
                            rs.getInt("id"),
                            rs.getString("imie"),
                            rs.getString("nazwisko"),
                            position);
                }
                rs.close();
                stm.close();
                if (needCloseConn) {
                    conn.close();
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        return result;
    }

    public List<Person> getAllPersons(Connection conn){
        List<Person> result = new ArrayList<>();
        boolean needCloseConn = false;
        try {
            if (conn == null) {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            Statement stm = conn.createStatement();
            stm.execute("Select pracownik.id as pid, imie, nazwisko, stanowisko.id as sid, nazwa  FROM pracownik, Stanowisko where pracownik.stanowisko = Stanowisko.id\n");
            //stm.execute("Select * FROM pg_catalog.pg_tables");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Position position = new Position(rs.getInt("sid"),rs.getString("nazwa"));
                Person p  = new Person(
                        rs.getInt("pid"),
                        rs.getString("imie"),
                        rs.getString("nazwisko"),
                        position);
                result.add(p);
            }
            rs.close();
            stm.close();
            if (needCloseConn) {
                conn.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
