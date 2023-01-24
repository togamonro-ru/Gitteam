<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
</head>
<body>
<h1>削除する図書のISBNを入力してください。</h1>
	<form action="DeleteServlet" method="post">
		ISBN：<input type="text" name="isbn"><br>
		<input type="submit" value="削除">
	</form>
	<a href="home">戻る</a>
</body>
</html>