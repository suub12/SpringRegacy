<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <form action="/member/update" method="post" name="updateForm">
        id: <input type="text" name="id" value="${member.id}"readonly>
        email: <input type="text" name="userEmail" value="${member.userEmail}"readonly>
        password: <input type="text" name="userPw" id="userPw">
        name: <input type="text" name="userName" value="${member.userName}" readonly>
        age: <input type="text" name="userAge" value="${member.userAge}">
        mobile: <input type="text" name="userPhoneNumber" value="${member.userPhoneNumber}">
        <input type="button" value="수정" onclick="update()">

    </form>
</div>
</body>
<script>
    const update = () => {
        const passwordDB = '${member.userPw}';
        const password = document.getElementById("userPw").value;
        if (passwordDB == password) {
            document.updateForm.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다!");
        }
    }
</script>
</html>