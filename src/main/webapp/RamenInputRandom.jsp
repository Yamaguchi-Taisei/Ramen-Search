<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ラーメン身長検索システム</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" href="styleInput.css">
</head>
<body>
	<div class="section">
		<h1>ラーメンランダム検索</h1>
		<br>
		<%-- -------- 入力フォーム -------- --%>
		<form action="HanteiRamenRandom" method="post">
			<div class="mt-5">
				好きな数字を入れてください：<input type="text" name="num" class="form-control" placeholder="9桁以内でお願いします">
			</div>

			<div class="mt-5">
				<input type="submit" value="検索する" class="btn btn-primary">
			</div>
		</form>

		<a href="RamenHome.jsp">戻る</a>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>
