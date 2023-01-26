<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="favicon/1.ico">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/k-20.css">
<title>アカウント登録</title>
</head>
<body>
<h3>新規会員登録</h3>
	<form action="acountcheck" method="post">
		名前：<input type="text" name="name"><br>
		メール：<input type="email" name="mail"><br>
		電話：<input type="text" name="phon"><br>
		パスワード：<input type="password" name="password"><br>
		
		<input type="submit" class="button"value="登録">
	</form>
	<a href="home"class="button">戻る</a>
</body>
</html>