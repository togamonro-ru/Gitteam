<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="dto.BookAccountDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
<h1>図書管理システム</h1>
<%
BookAccountDTO ac = (BookAccountDTO)session.getAttribute("user");
	%>
<p>ようこそ<%=ac.getName() %>さん</p>
<a href="BookLibraryServlet">書籍追加</a>
<a href="DeleteFormServlet">書籍破棄</a>
<a href="BookListServlet">書籍一覧</a>
</body>
</html>