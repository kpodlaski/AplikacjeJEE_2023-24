package db.applogic.dao;

import db.applogic.Position;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO{
    private DAO DAO ;

    public PositionDAO(DAO dao){
        this.DAO = dao;
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
