package br.edu.ifsp.dsw1.comsessao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/salvarcomsessao.do")
public class SalvarDadosSessaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pessoa pessoa = null;
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("objetoPessoa") == null) {
			response.sendRedirect("/index2.html");
		} else {
			pessoa = (Pessoa) session.getAttribute("objetoPessoa");
			pessoa.setEndereco(request.getParameter("text_street_address"));
			pessoa.setNumero(Integer.parseInt(request.getParameter("text_number")));
			pessoa.setCidade(request.getParameter("text_city"));
			pessoa.setCep(request.getParameter("text_cep"));
		}
		
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			out.println("<!doctype html> "); 
			out.println("<html lang=\"pt-br\"> ");  
			out.println("  <head> "); 
			out.println("    <meta charset=\"utf-8\"> ");
			out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> ");
			out.println("    <title>Dados Pessoais</title> ");
			out.println("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\"> ");
			out.println("  </head> "); 
			out.println("  <body> ");
			out.println("  	<div class=\"container\"> ");  		
			out.println("	  	<div class=\"card text-center\"> ");
			out.println("		    <div class=\"card-header\"> ");
			out.println("		      Informação ");
			out.println("		    </div> ");
			out.println("		    <div class=\"card-body\"> ");
			out.println("		      <h5 class=\"card-title\">Dados salvos com sucesso!</h5> ");
			out.println("		      <p class=\"card-text\">Nome: " + pessoa.getNome() + "</p> ");
			out.println("		      <p class=\"card-text\">E-mail: " + pessoa.getEmail() + "</p> ");
			out.println("		      <p class=\"card-text\">Endereço: " + pessoa.getEndereco() + ", n.º " + pessoa.getNumero() + "</p> ");
			out.println("		      <p class=\"card-text\">Cidade: " + pessoa.getCidade() + "</p> ");
			out.println("		      <p class=\"card-text\">CEP: " + pessoa.getCep() + "</p> ");
			out.println("		      <a href=\"index2.html\" class=\"btn btn-primary\">Voltar</a> ");
			out.println("		    </div> ");
			out.println("		    <div class=\"card-footer text-body-secondary\"> ");
			out.println("		      Obrigado! ");
			out.println("		    </div> ");
			out.println("		  </div> ");
			out.println("		    </div>");
			out.println("			<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script> ");
			out.println("  </body> ");
			out.println("</html> ");
		}
	}

}
