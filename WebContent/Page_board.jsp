<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	Board Page
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회</td>
		</tr>
		<c:forEach items="${ list }" var="dto">
			<tr>
				<td>${ dto.bNum }</td>
				<td>${ dto.bId }</td>
				<td>
					<c:forEach begin="1" end="${ dto.bIndent }">-</c:forEach>
					<a href="content_page.Bdo?bNum=${ dto.bNum }">${ dto.bTitle }</a></td>
				<td>${ dto.bDate }</td>
				<td>${ dto.bHit }</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="5"><input type="button" value="Write" onclick="location.href='write_page.Bdo'"></td>
			</tr>
	</table>
</body>
</html>