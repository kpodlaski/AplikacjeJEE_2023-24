package pgtest;

import java.sql.*;

public class PgTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

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
}
