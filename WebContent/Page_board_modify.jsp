<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%	
    	String bNum = (String)session.getAttribute("bNum");
		String id = (String)session.getAttribute("id");
    	String bTitle = (String)session.getAttribute("bTitle");
    	String bContent = (String)session.getAttribute("bContent");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	Modify Page
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="board_modify.Bdo" method="post">
			<input type="hidden" name="bNum" value=<%=bNum %>>
			<tr>
				<td> 아이디 </td>
				<td> <input type="hidden" name="bId" size="20" value=<%=id %>><%=id %></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="bTitle" size = "50" value=<%=bTitle %>></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea name="bContent" rows="10"><%=bContent %></textarea></td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="Modify">
				&nbsp;&nbsp;
				<input type="button" value="Board" onclick="location.href='board_page.Bdo?pageNum=${ 1 }'"></td>
			</tr>
		</form>
	</table>
</body>
</html>