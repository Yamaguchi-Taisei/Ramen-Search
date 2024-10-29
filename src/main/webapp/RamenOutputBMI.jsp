<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ラーメンBMI検索結果</title>
<link rel="stylesheet" href="styleOutput.css">
</head>
<body>
	<h1>ラーメンBMI結果</h1>

	<%-- -------- リクエストから各値を取得 -------- --%>
	<%
	List<String> typeListout = (List<String>) request.getAttribute("typeListout");
	%>
	<%
	List<String> calListout = (List<String>) request.getAttribute("calListout");
	%>
	<%
	List<String> nameListout = (List<String>) request.getAttribute("nameListout");
	%>
	<%
	List<String> locListout = (List<String>) request.getAttribute("locListout");
	%>
	<%
	List<String> priceListout = (List<String>) request.getAttribute("priceListout");
	%>
	<%
	List<String> reviewListout = (List<String>) request.getAttribute("reviewListout");
	%>
	<%
	List<String> urlListout = (List<String>) request.getAttribute("urlListout");
	%>
	<%
	List<String> jpgListout = (List<String>) request.getAttribute("jpgListout");
	%>

	<p>
		あなたは<%=request.getAttribute("humantype")%>です。
	</p>

	<table border="1">
		<tr>
			<th>lank</th>
			<th>name</th>
			<th>photo</th>
			<th>price</th>
			<th>calorie</th>
			<th>Location</th>
			<th>URL</th>
		</tr>
		<%
		if (typeListout != null && calListout != null && nameListout != null &&
				locListout != null && priceListout != null && reviewListout != null &&
				urlListout != null) {

			int size = typeListout.size();
			for (int i = 0; i < size; i++) {
		%>
		<tr>
			<td><%=i + 1%></td>
			<td><%=nameListout.get(i)%></td>
			<td><img src="./ramen img/<%=jpgListout.get(i)%>" width="100"
				height="100"></td>
			<td><%=priceListout.get(i)%></td>
			<td><%=calListout.get(i)%></td>
			<td><%=locListout.get(i)%></td>
			<td><a href="<%=urlListout.get(i)%>"><%=urlListout.get(i)%></a></td>
		</tr>
		<%
		}
		} else {
		out.println("Error: One or more lists are null or of unequal length.");
		}
		%>
	</table>

	<a href="<%=request.getContextPath()%>/RamenInputBMI.jsp">戻る</a>
	<a href="<%=request.getContextPath()%>/RamenHome.jsp">ホームに戻る</a>
</body>
</html>