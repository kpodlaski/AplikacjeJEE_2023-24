package db.applogic.dao;

import db.applogic.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO{
    private DAO DAO ;

    public PositionDAO(DAO dao){
        this.DAO = dao;
    }

    public Position insertOrUpdatePosition(Position position, Connection conn) {
        Position _p = getPositionById(position.getId(), conn);
        if (_p == null){
            return insertPosition(position,conn);
        }
        else {
            return updatePosition(position,conn);
        }
    }

    public List<Position> getAllPositions(Connection conn){
        List<Position> results = new ArrayList<>();
        boolean needCloseConn = false;
        try{
            if (conn == null)
                {
                    conn = this.DAO.getConnection();
                    needCloseConn = true;
                }
            Statement stm = conn.createStatement();
            stm.execute("Select * from Stanowisko");
            //stm.execute("Select * FROM pg_catalog.pg_tables");
            ResultSet rs = stm.getResultSet();
            while(rs.next()){
                Position p = new Position(rs.getInt("id"), rs.getString("nazwa"));
                results.add(p);
            }
            rs.close();stm.close();
            if (needCloseConn){
                conn.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return results;
    }

    public List<Position> getPositionsByNazwa(String nazwa, Connection conn){
        List<Position> results = new ArrayList<>();
        boolean needCloseConn = false;
        try{
            if (conn == null)
            {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            String query = "Select * from Stanowisko where nazwa=?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1,nazwa);
            pstm.execute();
            //stm.execute("Select * FROM pg_catalog.pg_tables");
            ResultSet rs = pstm.getResultSet();
            while(rs.next()){
                Position p = new Position(rs.getInt("id"), rs.getString("nazwa"));
                results.add(p);
            }
            rs.close();pstm.close();
            if (needCloseConn){
                conn.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return results;
    }

    public Position insertPosition(Position position, Connection conn) {
        boolean needCloseConn = false;
        int result=-1;
        try{
            if (conn == null)
            {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            ResultSet rs;
            //Base have no sequences so we need check existing ids
            Statement stm = conn.createStatement();
            stm.execute("SELECT Max(id) From stanowisko");
            rs = stm.getResultSet();
            if (rs.next()){
                position.setId(rs.getInt("max")+1);
                rs.close();
                stm.close();
                String query = "INSERT INTO Stanowisko VALUES (?,?)";
                PreparedStatement pstm = conn.prepareStatement(query);
                pstm.setInt(1,position.getId());
                pstm.setString(2,position.getName());
                result = pstm.executeUpdate();
                pstm.close();
            }
            if (needCloseConn){
                conn.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        if (result>0)
            return position;
        else return null;
    }

    public Position updatePosition(Position position, Connection conn) {
        boolean needCloseConn = false;
        int result=-1;
        try{
            if (conn == null)
            {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            ResultSet rs;
            //Base have no sequences so we need check existing ids
            String query = "UPDATE Stanowisko  SET nazwa = ? WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(2,position.getId());
            pstm.setString(1,position.getName());
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
            return position;
        else return null;
    }

    public int deletePosition(Position position, Connection conn){
        boolean needCloseConn = false;
        int result=-1;
        try{
            if (conn == null)
            {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            ResultSet rs;
            //Base have no sequences so we need check existing ids
            String query = "DELETE FROM Stanowisko  WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1,position.getId());
            result = pstm.executeUpdate();
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

    public Position getPositionById(int id,Connection conn){
        Position result = null;
        boolean needCloseConn = false;
        try{
            if (conn == null)
            {
                conn = this.DAO.getConnection();
                needCloseConn = true;
            }
            Statement stm = conn.createStatement();
            stm.execute("Select * from Stanowisko where id="+id);
            //stm.execute("Select * FROM pg_catalog.pg_tables");
            ResultSet rs = stm.getResultSet();
            while(rs.next()){
                result = new Position(rs.getInt("id"), rs.getString("nazwa"));
            }
            rs.close();stm.close();
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
