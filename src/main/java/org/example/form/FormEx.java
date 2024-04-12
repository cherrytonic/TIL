package org.example.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/formex")

public class FormEx extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet");
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        System.out.println("name: " + name + "| id: " + id + "| password: " + password + "| phone: " + phone + "| address: " + address);
        PrintWriter pw = response.getWriter();
        pw.write("<html>");
        pw.write("<head>");
        pw.write("</head>");
        pw.write("<body>");
        pw.write("<h1>접수완료</h1>");
        pw.write("</body>");
        pw.write("</html>");
        pw.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String food = request.getParameter("food");
        System.out.println("name: " + name + "| id: " + id + "| password: " + password + "| phone: " + phone + "| address: " + address + "| gender: " + gender + "| food: " + food);
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.write("<html>");
        pw.write("<head>");
        pw.write("</head>");
        pw.write("<body>");
        pw.write("<h1>접수완료</h1>");
        pw.write("</body>");
        pw.write("</html>");
        pw.close();
    }
}
