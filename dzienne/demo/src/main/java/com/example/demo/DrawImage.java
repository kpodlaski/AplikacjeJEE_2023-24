package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet(name = "image", value = "/img")
public class DrawImage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        HttpSession session = req.getSession();
        String sesWord = (String) session.getAttribute("word");
        if (sesWord == null){
            sesWord = "No Session";
        }
        InputStream in = drawText(sesWord);
        OutputStream out = resp.getOutputStream();
        int c;
        while ( (c = in.read())>0){
            out.write(c);
        }
        out.close();
        System.out.println("DONE !!!");
    }

    private InputStream drawText(String text) throws IOException {
        BufferedImage off_Image =
                new BufferedImage(100, 50,
                        BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = off_Image.createGraphics();
        g2.drawString(text,15,15);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(off_Image, "jpg", os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        return is;
    }
}
