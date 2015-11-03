<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="mvcCalc.CalculatriceBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		CalculatriceBean bean = (CalculatriceBean) request.getAttribute("bean");
	%>

	<form action="#" method="get">
		a:<input type="text" name="a" value="<%=bean.getA()%>"></input> b:<input type="text" name="b" value="<%=bean.getB()%>"></input>
		<input type="submit" value="+"></input>

	</form>
	<h1><%=bean.getError()%></h1>
	<h1><%=bean.getResultat()%></h1>
</body>
</html>