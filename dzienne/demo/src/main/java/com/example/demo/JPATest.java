package com.example.demo;

import applogic.model.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "jpaTester", value = "/jpa-test.html")
public class JPATest extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("docker");
        EntityManager em = emf.createEntityManager();
        Position s = em.find(Position.class,2);
        out.println(s.getId()+" "+s.getName());
        out.println("</body></html>");
        em.close();
        emf.close();
    }

    public void destroy() {
    }
}
