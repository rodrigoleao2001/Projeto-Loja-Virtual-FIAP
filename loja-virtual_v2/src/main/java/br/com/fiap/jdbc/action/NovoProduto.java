package br.com.fiap.jdbc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.jdbc.dao.ProdutoDAO;
import br.com.fiap.jdbc.model.Produto;

public class NovoProduto implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		String nomeProduto = request.getParameter("nome");
		String descricaoProduto = request.getParameter("descricao");
		int idCategoria = Integer.parseInt(request.getParameter("categoria"));

		Produto produto = new Produto(nomeProduto, descricaoProduto, idCategoria);
		produtoDAO.salvarComCategoria(produto);

		return "redirect:produto?param=ListaProdutos";

	}

}
