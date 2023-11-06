package pgtest;

import applogic.dao.DAO;
import applogic.jdbc.dao.DAOImpl;
import applogic.model.Person;
import applogic.model.Position;

import java.sql.*;

public class PgTest {
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
        // minId= ";1"; //';1'
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

    public static void main(String[] args) {

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
        for (Position p : dao.getPositionByName("e")){
            System.out.println(p);
        }
        System.out.println("------");
        Person p = dao.getPersonById(2);
        System.out.println(p);
    }
}
