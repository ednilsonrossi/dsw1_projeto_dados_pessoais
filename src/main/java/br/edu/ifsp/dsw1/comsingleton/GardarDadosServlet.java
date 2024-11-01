package br.edu.ifsp.dsw1.comsingleton;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/salvar.do")
public class GardarDadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// Recuperar referência do singleton
		Dados dados = Dados.getInstance();
		
		// Recuperar os parametros da requisição http
		var name = request.getParameter("text_name");
		var email = request.getParameter("text_email");
		var address = request.getParameter("text_street_address");
		var number = request.getParameter("text_number");
		var city = request.getParameter("text_city");
		var cep = request.getParameter("text_cep");
		
		// Inserir um objeto pessoa no singleton
		dados.insert(new Pessoa(name, email, address, Integer.parseInt(number), city, cep));
		
		// Definir um ATRIBUTO para o request
		request.setAttribute("lista", dados.getAll());
		
		// obter a referência do dispatcher
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/listar.jsp");
		
		// encaminhar o fluxo para a página JSP listar.jsp
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Dados dados = Dados.getInstance();
		
		var dispatcher = request.getRequestDispatcher("/includes/topo.jsp");
		dispatcher.include(request, response);
		
		var out = response.getWriter();
		out.println("<ul>");	
		for( var p : dados.getAll()) {
			out.println("<li>" + p.getNome() + "</li>");
		}
		out.println("</ul>");
		
		dispatcher = request.getRequestDispatcher("/includes/rodape.jsp");
		dispatcher.include(request, response);
	}
}
