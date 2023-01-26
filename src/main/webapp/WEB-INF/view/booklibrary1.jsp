<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書登録</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>図書を登録してください</h1>
	<form action="Register_servlet" method="post">
	<p>図書名入力：<input type="text" name="name"></p>
	<p>ISBN：<input type="text" name="isbn"></p>
	<input type="submit" value="送信">
	<a href="home">戻る</a>
	</form>
</body>
</html>