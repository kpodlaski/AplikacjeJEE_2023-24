package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "captcha", value = "/captcha")
public class Captcha extends HttpServlet {

    public void init() {

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String value = req.getParameter("value");
        HttpSession session = req.getSession();
        if (value == null) {
            out.println("Write word in the form:<br/>");
            String word = generateNewWord();
            session.setAttribute("word",word);
            out.println(word);
            out.println("<form method=\"GET\" ><input id=\"value\" name=\"value\" >" +
                    "<input type=\"submit\"> </form> ");
        }
        String sesWord = (String) session.getAttribute("word");
        if (value.equals(sesWord)){
            out.println("Good text");
        }
        else {
            out.println("<a href=\"captcha\"> Try again </a>");
            req.removeAttribute("word");
        }
    }

    private String generateNewWord(){
        return "Alojzy";
    }
    public void destroy() {
    }
}
