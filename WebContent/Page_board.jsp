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
	<%
		
		int lastPage = (Integer)request.getAttribute("lastPage");
	
		int pageNum = (Integer)request.getAttribute("pageNum");
		
	%>

	Board Page
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>작성자</td>
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
				<td></td>
				<td></td>
				<td>
					<%
						if(pageNum > 1) {
						%>
							<a href="board_page.Bdo?pageNum=1">≪</a>
							<a href="board_page.Bdo?pageNum=<%=pageNum - 1%>">＜</a>
						<% 
						}
						if(lastPage > 5) {
							for(int i = (pageNum); i <= (pageNum + 4); i++){
								if((pageNum + 4) > lastPage) {
									for(int j = pageNum; j <= lastPage; j++) {
										%>
										<a href="board_page.Bdo?pageNum=<%=j%>"><%=j%></a>						
										<%
									}
									if(pageNum != lastPage) {
									%>
										<a href="board_page.Bdo?pageNum=<%=pageNum + 1%>">＞</a>
										<a href="board_page.Bdo?pageNum=<%=lastPage%>">≫</a>
									<% 
									}
									return;
								} else if ((pageNum + 4) <= lastPage) {
								%>
									<a href="board_page.Bdo?pageNum=<%=i%>"><%=i%></a>
								<%
								}
							}
						} else {
							for(int i = 1; i <= lastPage; i++){
							%>
								<a href="board_page.Bdo?pageNum=<%=i%>"><%=i%></a>						
							<%
							}
						}
						if(pageNum != lastPage) {
						%>
							<a href="board_page.Bdo?pageNum=<%=pageNum + 1%>">＞</a>
							<a href="board_page.Bdo?pageNum=<%=lastPage%>">≫</a>
						<% 
						}
					%>
				</td>
				<td></td>
				<td></td>
			</tr>
			
			<tr>
				<td colspan="5"><input type="button" value="Write" onclick="location.href='write_page.Bdo'"></td>
			</tr>
	</table>
</body>
</html>