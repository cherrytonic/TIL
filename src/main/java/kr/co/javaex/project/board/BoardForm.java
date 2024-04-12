package kr.co.javaex.project.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/board")
public class BoardForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        PrintWriter pw = response.getWriter();
        System.out.println(name + title + text);
        pw.write("<html>");
        pw.write("<head>");
        pw.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">");
        pw.write("</head>");
        pw.write("<body>");
        pw.write("<div class=\"mb-3\">");
        pw.write("<h1>작성완료</h1>");
        pw.write("제목:" + name);
        pw.write("<br/>작성자:" + title);
        pw.write("<br/>내용:" + text);
        pw.write("<div class=\"mb-3\">");
        pw.write("</body>");
        pw.write("</html>");
        pw.close();
    }
}
