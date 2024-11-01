package br.edu.ifsp.dsw1.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/logar.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String username = "admin";
    private String passwd = "admin";
	

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String usuario = request.getParameter("text_usuario");
    	String senha = request.getParameter("text_senha");
    	
    	response.setContentType("text/html");
    	try (var out = response.getWriter() ) {
    		out.println("<html><body>");
    		
			if (autenticar(usuario, senha)) {
				HttpSession session = request.getSession();
				session.setAttribute(Constant.ATTR_USER, usuario);
				session.setMaxInactiveInterval(5 * 60);		// Tempo é dado em segundos
				out.println("<h2>Bem-vindo, " + usuario + "</h2>");
				out.println("<a href=\"logado.jsp\">Sistema</a>");
			} else {
				out.println("<h2>Usuário ou senha inválidos.</h2>");
			}
			
			out.println("</body></html>");
    	}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
	}
	
	private boolean autenticar(String user, String pass) {
		if (user != null && pass != null) {
			return username.equals(user) && passwd.equals(pass);
		}
		return false;
	}
}
