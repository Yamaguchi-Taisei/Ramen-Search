<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ラーメン検索結果</title>
<link rel="stylesheet" href="styleOutput.css">
</head>
<body>
	<h1>選ばれたのはこのラーメンです。</h1>

	<%-- -------- リクエストから各値を取得 -------- --%>
	<%
	String type = (String) request.getAttribute("type");
	String cal = (String) request.getAttribute("cal");
	String name = (String) request.getAttribute("name");
	String loc = (String) request.getAttribute("loc");
	String price = (String) request.getAttribute("price");
	String review = (String) request.getAttribute("review");
	String url = (String) request.getAttribute("url");
	String jpg = (String) request.getAttribute("jpg");
	%>

	<table border="1">
		<tr>
			<th>Name</th>
			<th>Photo</th>
			<th>Calorie</th>
			<th>Location</th>
			<th>URL</th>
		</tr>
		<%
		if (type != null && cal != null && name != null && loc != null && price != null && review != null && url != null) {
		%>
		<tr>
			<td><%=name%></td>
			<td><img src="./ramen img/<%=jpg%>" width="100" height="100"></td>
			<td><%=cal%></td>
			<td><%=loc%></td>
			<td><a href="<%=url%>"><%=url%></a></td>
		</tr>
		<%
		} else {
		out.println("Error: One or more values are null.");
		}
		%>
	</table>

	<a href="<%=request.getContextPath()%>/RamenInputRandom.jsp">戻る</a>
	<a href="<%=request.getContextPath()%>/RamenHome.jsp">ホームに戻る</a>
</body>
</html>
