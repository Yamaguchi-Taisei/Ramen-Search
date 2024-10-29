<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ラーメン検索システム</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" href="styleInput.css">
</head>
<body>
	<div class="section">
		<h1>ラーメン値段種類検索</h1>
		<p>値段が安いtop3を表示します</p>
		<br>
		<%-- -------- 入力フォーム -------- --%>
		<form action="HanteiRamenPrice" method="post">
			<div>
				ラーメンの種類を選択してください <select name="ramenType" class="form-select">
					<option value="二郎系">二郎</option>
					<option value="家系">家系</option>
				</select>
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
