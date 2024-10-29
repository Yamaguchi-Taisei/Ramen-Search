<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" href="stylehome.css">
</head>
<body>
	<div class="section">
		<h1>ラーメン便利検索</h1>
		<p>検索項目を選んで検索してください。</p>
		<div class="container-fluid">
			<div class="row g-3">
				<div class="col-lg-3 col-sm-6">
					<a href="RamenInputReview.jsp" class="btn btn-primary w-100">Review検索</a>
				</div>
				<div class="col-lg-3 col-sm-6">
					<a href="RamenInputPrice.jsp" class="btn btn-primary w-100">Price検索</a>
				</div>
				<div class="col-lg-3 col-sm-6">
					<a href="RamenInputBMI.jsp" class="btn btn-primary w-100">Bmi検索</a>
				</div>
				<div class="col-lg-3 col-sm-6">
					<a href="RamenInputRandom.jsp" class="btn btn-primary w-100">random検索</a>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>