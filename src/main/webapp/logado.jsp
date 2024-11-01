<%@page import="br.edu.ifsp.dsw1.login.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	HttpSession sessao = request.getSession(false);
	if (sessao == null || sessao.getAttribute(Constant.ATTR_USER) == null) {
		out.println("<a href=\"login.html\">Faça o login.</a>");
	} else {
		out.println("<h1>Sistema Liberado</h1>");
	}
	%>
</body>
</html>