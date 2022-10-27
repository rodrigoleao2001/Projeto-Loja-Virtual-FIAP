package br.com.fiap.jdbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.jdbc.action.Acao;

//     http://localhost:8080/loja-virtual/produto?param=ListaProdutos

@WebServlet("/produto")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//gerenciar entradas
		String parametro = request.getParameter("param");
		String endClasse = "br.com.fiap.jdbc.action." + parametro;
		String nome = null;

		try {
			Class classe = Class.forName(endClasse); // reflection
			@SuppressWarnings("deprecation")
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executar(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		
		//gerenciar as saídas
		String[] direcionador = nome.split(":");
		if (direcionador[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + direcionador[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(direcionador[1]);
		}
	}

}
