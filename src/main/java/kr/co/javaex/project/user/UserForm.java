package kr.co.javaex.project.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/user")
public class UserForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        PrintWriter pw = response.getWriter();
        pw.write("<html>");
        pw.write("<head>");
        pw.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">");
        pw.write("</head>");
        pw.write("<body>");
        pw.write("<div class=\"mb-3\">");
        pw.write("<h1>가입완료</h1>");
        pw.write("이름:" + name);
        pw.write("<br/>id:" + id);
        pw.write("<br/>email:" + email);
        pw.write("<br/>phone:" + phone);
        pw.write("<div class=\"mb-3\">");
        pw.write("</body>");
        pw.write("</html>");
        pw.close();
    }
}
