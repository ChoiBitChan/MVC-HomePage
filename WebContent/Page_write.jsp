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
	Write Page
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write.Bdo" method="post">
			<tr>
				<td> 아이디 </td>
				<td> <input type="hidden" name="bId" size="20" value=<%=id %>><%=id %> </td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="bTitle" size = "50"> </td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea name="bContent" rows="10" ></textarea> </td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="Write">
				&nbsp;&nbsp;
				<input type="button" value="List" onclick="location.href='board_page.Bdo'"></td>
			</tr>
		</form>
	</table>
</body>
</html>