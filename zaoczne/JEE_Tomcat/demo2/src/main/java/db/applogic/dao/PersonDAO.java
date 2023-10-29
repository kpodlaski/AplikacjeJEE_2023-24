package db.applogic.dao;

import db.applogic.*;

import java.sql.*;
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
                ResultSet rs = stm.getResultSet();

                PreparedStatement ptm = conn.prepareStatement("Select * from Pracownik where id=?");
                ptm.setInt(1,id);

                ptm = conn.prepareStatement("Select * from Pracownik where imie=?");
                ptm.setString(1,"adam");
                ptm.execute();
                rs = ptm.getResultSet();
                //stm.execute("Select * FROM pg_catalog.pg_tables");

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
            stm.execute(
                    "Select pracownik.id as pid, imie, nazwisko, stanowisko.id as sid, nazwa  " +
                            "FROM pracownik, Stanowisko where pracownik.stanowisko = Stanowisko.id\n");
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

    public List<Person> getPersonsByName(String name, Connection conn){
        List<Person> result = new ArrayList<>();
        boolean needCloseConn = false;
        try {
            if (conn == null) {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            String query = "Select pracownik.id as pid, imie, nazwisko, stanowisko.id as sid, nazwa  " +
                    "FROM pracownik, Stanowisko where pracownik.stanowisko = Stanowisko.id and imie=?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1,name);
            pstm.execute();
            //stm.execute("Select * FROM pg_catalog.pg_tables");
            ResultSet rs = pstm.getResultSet();
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
            pstm.close();
            if (needCloseConn) {
                conn.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    public List<Person> getPersonsBySurname(String surname, Connection conn){
        List<Person> result = new ArrayList<>();
        boolean needCloseConn = false;
        try {
            if (conn == null) {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            String query = "Select pracownik.id as pid, imie, nazwisko, stanowisko.id as sid, nazwa  " +
                    "FROM pracownik, Stanowisko where pracownik.stanowisko = Stanowisko.id and nazwisko=?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1,surname);
            pstm.execute();
            //stm.execute("Select * FROM pg_catalog.pg_tables");
            ResultSet rs = pstm.getResultSet();
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
            pstm.close();
            if (needCloseConn) {
                conn.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    public List<Person> getPersonsByPosition(Position position,Connection conn){
        List<Person> result = new ArrayList<>();
        boolean needCloseConn = false;
        try {
            if (conn == null) {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            String query = "Select pracownik.id as pid, imie, nazwisko, stanowisko.id as sid, nazwa  " +
                    "FROM pracownik, Stanowisko where pracownik.stanowisko = Stanowisko.id and pracownik.stanowisko=?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1,position.getId());
            pstm.execute();
            //stm.execute("Select * FROM pg_catalog.pg_tables");
            ResultSet rs = pstm.getResultSet();
            while (rs.next()) {
                Position pos = new Position(rs.getInt("sid"),rs.getString("nazwa"));
                Person p  = new Person(
                        rs.getInt("pid"),
                        rs.getString("imie"),
                        rs.getString("nazwisko"),
                        pos);
                result.add(p);
            }
            rs.close();
            pstm.close();
            if (needCloseConn) {
                conn.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    public List<Person> getPersonsByNameAndSurname(String name, String surname, Connection conn){
        List<Person> result = new ArrayList<>();
        boolean needCloseConn = false;
        try {
            if (conn == null) {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            String query = "Select pracownik.id as pid, imie, nazwisko, stanowisko.id as sid, nazwa  " +
                    "FROM pracownik, Stanowisko where pracownik.stanowisko = Stanowisko.id and imie=? and nazwisko=?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setString(2,surname);
            pstm.execute();
            //stm.execute("Select * FROM pg_catalog.pg_tables");
            ResultSet rs = pstm.getResultSet();
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
            pstm.close();
            if (needCloseConn) {
                conn.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    public Person updatePerson(Person p, Connection conn){
        boolean needCloseConn = false;
        int result=-1;
        try{
            if (conn == null)
            {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            DAO.updatePosition(p.getPosition(), conn);
            ResultSet rs;
            //Base have no sequences so we need check existing ids
            String query = "UPDATE Pracownik  SET imie = ?, nazwisko=?, stanowisko=? WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1,p.getName());
            pstm.setString(2,p.getSurname());
            pstm.setInt(3,p.getPosition().getId());
            pstm.setInt(4,p.getId());
            result = pstm.executeUpdate();
            pstm.close();
            if (needCloseConn){
                conn.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        if (result>0)
            return p;
        else return null;
    }

    public Person insertPerson(Person p, Connection conn){
        boolean needCloseConn = false;
        int result=-1;
        try{
            if (conn == null)
            {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            Position pos = DAO.insertOrUpdatePosition(p.getPosition(), conn);
            ResultSet rs;
            Statement stm = conn.createStatement();
            stm.execute("SELECT Max(id) From Pracownik");
            rs = stm.getResultSet();
            if (rs.next()) {
                p.setId(rs.getInt("max") + 1);
                p.setPosition(pos);
                rs.close();
                stm.close();
                //Base have no sequences so we need check existing ids
                String query = "INSERT INTO Pracownik  VALUES (?,?,?,?,?)";
                PreparedStatement pstm = conn.prepareStatement(query);
                pstm.setInt(1, p.getId());
                pstm.setString(2, p.getName());
                pstm.setString(3, p.getSurname());
                pstm.setInt(4, p.getPosition().getId());
                result = pstm.executeUpdate();
                pstm.close();
                if (needCloseConn) {
                    conn.close();
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        if (result>0)
            return p;
        else return null;
    }

    public int deletePerson(Person person, Connection conn){
        boolean needCloseConn = false;
        int result=-1;
        try{
            if (conn == null)
            {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            ResultSet rs;
            String query = "DELETE FROM Pracownik  WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1,person.getId());
            result = pstm.executeUpdate();
            pstm.close();
            //Need to delete all records from pracownikjednlnk
            String query2 = "DELETE FROM PracJednLnk  WHERE id_prac = ?";
            pstm = conn.prepareStatement(query2);
            pstm.setInt(1,person.getId());
            pstm.executeUpdate();
            pstm.close();
            if (needCloseConn){
                conn.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}

