package com.example.demo;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello to " +
                " World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        int size =0;
        try {

        InputStream is = this.getClass().getClassLoader().getResourceAsStream("pong_palette.jpeg");
        System.out.println(is);

        int c;
        while ( (c=is.read())>0){
            size++;
        }
        }
        catch (Exception e)
        {
            out.println(e.getMessage());
        }
        out.println("SIZE of image:"+size);
        out.println("</body></html>");
    }

    public void destroy() {
    }
}