package org.example.hijsp;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello-servlet")

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        System.out.println("init");
        message = "안녕자기!";
    }
//    public void service(HttpServletRequest request,
//                        HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("service called");
//        super.service(request, response);
//    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        out.close();

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doPost");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head></head><body>");
        out.println("<h1>POST방식으로 호출되었습니다.</h1>");
        out.println("</body></html>");
        out.close();
    }

    public void destroy() {
        System.out.println("destroy");
    }
}