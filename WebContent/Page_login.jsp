<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	LogIn Page
	<br/>
	<form action="login.Mdo" method="post">
		아이디 : <input type="text" name="id" size="20"><br />
		비밀번호 : <input type="password" name="pw" size="20"><br />
		<input type="submit" value="Login">
		&nbsp;&nbsp;&nbsp;
		<input type="button" value="Join" onclick="location.href='join_page.Mdo'">
	</form>
</body>
</html>