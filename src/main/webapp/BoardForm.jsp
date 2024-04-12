<%--
  Created by IntelliJ IDEA.
  User: DA
  Date: 2024-04-12
  Time: 오후 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>게시판</title>
    </head>
        <body>
            <h1>게시글 작성</h1>
            <form action="/board" method="post">
                <div class="mb-3">
                    <label for="title" class="form-label">제목</label>
                    <input type="text" class="form-control" id="title" name= "title" placeholder="">
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">작성자</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="">
                </div>
                <div class="mb-3">
                    <label for="text" class="form-label">내용</label>
                    <textarea class="form-control" id="text" name="text" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </body>
</html>
