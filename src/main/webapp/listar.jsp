<%@page import="br.edu.ifsp.dsw1.comsingleton.Pessoa"%>
<%@page import="java.util.List"%>
<jsp:include page="/includes/topo.jsp" />
    
<%
List<Pessoa> lista = (List<Pessoa>) request.getAttribute("lista");

if (lista != null) {
%>
	<ul>
	
	<% for (var p : lista) { %>
  		<li> <%= p.getNome() %> </li>
	<%} %>
	
	</ul>
<%} %>
        
<jsp:include page="/includes/rodape.jsp" />