<%--
  Created by IntelliJ IDEA.
  User: DA
  Date: 2024-04-12
  Time: 오후 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Practice2</title>
</head>
<body>
<form action="/formex" method="get">
    <h1>GET</h1>
    이름 : <input type="text" name="name" size="10"><br/>
    아이디 : <input type="text" name="id" size="10"><br/>
    비밀번호 : <input type="text" name="password" size="10"><br/>
    전화번호 : <input type="text" name="phone" size="10"><br/>
    주소 : <input type="text" name="address" size="10"><br/>
    <input type="submit" value="전송">
</form>
</body>
</html>