<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
  	 	String name = (String)session.getAttribute("name");
		String id = (String)session.getAttribute("id");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	Modify Page
	<br/>
	<form action="modify.Mdo" method="post">
		아이디 : <input type="hidden" name="id" size="20" value=<%=id %>><%=id %><br/>
		비밀번호 : <input type="password" name="pw" size="20"><br />
		이름 : <input type="text" name="name" size="20"><br />
		<input type="submit" value="Modify"">
		&nbsp;&nbsp;&nbsp;
		<input type="reset" value="Reset">
		&nbsp;&nbsp;&nbsp;
		<input type="button" value="Main" onclick="location.href='main_page.Mdo'">
	</form>
</body>
</html>