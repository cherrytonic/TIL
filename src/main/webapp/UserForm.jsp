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
    <title>회원</title>
</head>
<body>
<h1>회원가입</h1>
<form action="/user" method="post">
    <div class="mb-3">
        <label for="id" class="form-label">아이디: </label>
        <input type="text" class="form-control" id="id" name="id" placeholder="">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">비밀번호: </label>
        <input type="text" class="form-control" id="password" name="password" placeholder="">
    </div>
    <div class="mb-3">
        <label for="name" class="form-label">이름: </label>
        <input type="text" class="form-control" id="name" name="name" placeholder="">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">email: </label>
        <input type="text" class="form-control" id="email" name="email" placeholder="">
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">전화번호: </label>
        <input type="text" class="form-control" id="phone" name="phone" placeholder="">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
