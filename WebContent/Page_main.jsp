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
	Main Page
	<br/>
	[<%= id %>] WellCome.
	<br/>
	<input type="button" value="Modify" onclick="location.href='modify_page.Mdo'">
	<input type="button" value="Board" onclick="location.href='board_page.Bdo'">
</body>
</html>