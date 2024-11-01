<%@page import="br.edu.ifsp.dsw1.comsessao.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Pessoa pessoa = new Pessoa();
pessoa.setNome(request.getParameter("text_name"));
pessoa.setEmail(request.getParameter("text_email"));
session.setAttribute("objetoPessoa", pessoa);
%>

<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dados Pessoais</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
  	<div class="container">
  		<h1>Endereço</h1>
  		<!-- <form action="save.do" method="post"> -->
	  	<form action="salvarcomsessao.do" method="post">
	  	
	  		<div class="mb-3">
			  <label for="address" class="form-label">Logradouro</label>
			  <input type="text" class="form-control" id="address" name="text_street_address" placeholder="Digite nome da rua, avenida, praça, etc.">
			</div>
			<div class="mb-3">
			  <label for="number" class="form-label">Número</label>
			  <input type="number" class="form-control" id="number" name="text_number" placeholder="Digite o número da residência.">
			</div>
			<div class="mb-3">
			  <label for="city" class="form-label">Cidade</label>
			  <input type="text" class="form-control" id="city" name="text_city" placeholder="Digite o nome da cidade.">
			</div>
			<div class="mb-3">
			  <label for="cep" class="form-label">CEP</label>
			  <input type="text" class="form-control" id="cep" name="text_cep" placeholder="Digite o cep.">
			</div>
	  	
	  		<button type="submit" class="btn btn-success">Salvar</button>
	  		
	  	</form>
    
    </div>
    
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>