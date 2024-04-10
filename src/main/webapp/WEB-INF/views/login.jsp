<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="/member/loginForm" method="post">
        <input type="text" name="userEmail" placeholder="이메일">
        <input type="text" name="userPw" placeholder="비밀번호">
        <input type="submit" value="로그인">
    </form>
</body>
</html>