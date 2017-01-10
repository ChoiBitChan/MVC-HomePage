<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script language="JavaScript" src="members.js" charset="UTF-8"></script>
</head>
<body>
	Join Page
	<br/>
	<form action="join.Mdo" method="post" name="reg_frm">
		아이디 : <input type="text" name="id" size="20"><br />
		비밀번호 : <input type="password" name="pw" size="20"><br />
		이름 : <input type="text" name="name" size="20"><br />
		<input type="button" value="Join" onclick="infoConfirm()"> &nbsp;&nbsp;&nbsp; <input type="reset" value="Reset">
	</form>
</body>
</html>