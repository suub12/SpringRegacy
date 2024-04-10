<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save</title>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>
    <form action="/member/save" method="post">
        <input type="text" name="userEmail" placeholder="이메일" id="userEmail">
        <p id="check-result"></p>
        <input type="text" name="userPw" placeholder="비밀번호">
        <input type="text" name="userName" placeholder="이름">
        <input type="text" name="userAge" placeholder="나이">
        <input type="text" name="userPhoneNumber" placeholder="전화번호">
        <input type="submit" value="회원가입">
    </form>
</body>