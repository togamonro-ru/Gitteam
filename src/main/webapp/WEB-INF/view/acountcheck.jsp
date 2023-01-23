<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="dto.BookAccountDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/1.ico">
<link rel="stylesheet" href="css/k-20.css">
<title>登録内容確認</title>
</head>
<body>
<p>下記の内容で登録します。よろしいですか？</p>
	<%
	BookAccountDTO a = (BookAccountDTO)session.getAttribute("input_data");
	%>
	名前：<%=a.getName() %><br>
	メールアドレス：<%=a.getMail() %><br>
	電話番号：<%=a.getPhon() %><br>
	パスワード：********<br>

	<a href="acountfinish"class="button">OK</a><br>
	<a href="addacount"class="button">戻る</a>
</body>
</html>