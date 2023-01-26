<%@page import="dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="dto.BookDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧リスト</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>図書一覧リスト</h1>
	<table border="1" class="table">
		<tr>
			<th>ID</th>
			<th>図書名</th>
			<th>ISBN</th>
		</tr>
		<%
			List<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
			for(BookDTO s : list){
		%>		
				<tr>
					<td><%=s.getId() %></td>
					<td><%=s.getName() %></td>
					<td><%=s.getIsbn() %></td>
				
				</tr>
		<%} %>

	</table>
	<a href="home">戻る</a>
</body>
</html>