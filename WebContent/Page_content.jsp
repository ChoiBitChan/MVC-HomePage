<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="board_modify_page.Bdo" method="post">
			<input type="hidden" name="bNum" value="${ content_view.bNum }">
			<tr>
				<td> 번호 </td>
				<td> ${ content_view.bNum } </td>
			</tr>
			<tr>
				<td> 조회 </td>
				<td> ${ content_view.bHit } </td>
			</tr>
			<tr>
				<td> 아이디 </td>
				<td> <input type="hidden" name="bId" value="${ content_view.bId }">${ content_view.bId }</td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="hidden" name="bTitle" value="${ content_view.bTitle }">${ content_view.bTitle }</td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <input type="hidden" style="width:200px; height:200px;" name="bContent" value="${ content_view.bContent }">${ content_view.bContent }</td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="Modify">
				&nbsp;&nbsp;
				<input type="button" value="Board" onclick="location.href='board_page.Bdo'">
				&nbsp;&nbsp;
				<input type="button" value="Delete" onclick="location.href='delete.Bdo?bNum=${content_view.bNum}&bId=${content_view.bId}'">
				&nbsp;&nbsp;
				<input type="button" value="Reply" onclick="location.href='board_reply_page.Bdo?bNum=${content_view.bNum}'">
				</td>
			</tr>
		</form>
	</table>

</body>
</html>