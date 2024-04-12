<%--
  Created by IntelliJ IDEA.
  User: DA
  Date: 2024-04-12
  Time: 오후 2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Practice</title>
</head>
<body>
    <form action="/formex" method="post">
        <h1>POST</h1>
        이름 : <input type="text" name="name" size="10"><br/>
        아이디 : <input type="text" name="id" size="10"><br/>
        비밀번호 : <input type="text" name="password" size="10"><br/>
        전화번호 : <input type="text" name="phone" size="10"><br/>
        주소 : <input type="text" name="address" size="10"><br/>
        성별 : <input type="radio" name="gender" value="m">남자<input type="radio" name="gender" value="f">여자<br/>
        좋아하는 음식 : <input type="checkbox" name="food" value="마라탕">마라탕
                    <input type="checkbox" name="food" value="짜장면">짜장면
                    <input type="checkbox" name="food" value="치킨">치킨
                    <input type="checkbox" name="food" value="민트초코">민트초코<br/>
        <input type="submit" value="전송">
    </form>
</body>
</html>
