package com.example.demo2;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import db.applogic.Person;
import db.applogic.Position;
import db.applogic.dao.DAO;
import db.applogic.dao.PersonDAO;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        try{
        Class.forName("org.postgresql.Driver");
        String connString= "jdbc:postgresql://172.17.0.2:5432/postgres?user=postgres";
        Connection conn = DriverManager.getConnection(connString);
        Statement stm = conn.createStatement();
        stm.execute("Select * from Jednostka");
        //stm.execute("Select * FROM pg_catalog.pg_tables");
        ResultSet rs = stm.getResultSet();
        while(rs.next()){
            out.println(rs.getString("nazwa"));
        }
        rs.close();stm.close();conn.close();

        DAO dao = new DAO();
        List<Person> persons = dao.getAllPersons(null);
        for (Person p : persons){
            out.println(p.getName()+" "+p.getSurname());
            out.println("<br/>");
        }
        //TEST DAO Position operations
        Position p = new Position(0,"Senior Developer");
        p = dao.insertPosition(p,null);
        out.println("<br/> insert: new id "+p.getId()+" nazwa="+p.getName());
        p.setName("Junior Developer");
        p = dao.updatePosition(p,null);
        out.println("<br/> update: new id "+p.getId()+" nazwa="+p.getName());
        int i = dao.deletePosition(p,null);
        out.println("<br/> delete: number of rows: "+i);
        }
        catch (Exception e){
            out.println(e);
        }


        out.println("</body></html>");
    }

    public void destroy() {
    }
}