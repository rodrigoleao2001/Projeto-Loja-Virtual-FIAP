package br.com.fiap.jdbc.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.jdbc.dao.ProdutoDAO;

public class AlteraProduto implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProdutoDAO produtoDAO = new ProdutoDAO();

		int id = Integer.parseInt(request.getParameter("id"));
		String nomeProduto = request.getParameter("nome");
		String descricaoProduto = request.getParameter("descricao");
		int idCategoria = Integer.parseInt(request.getParameter("categoria"));

		produtoDAO.alterar(nomeProduto, descricaoProduto, idCategoria, id);

		return "redirect:produto?param=ListaProdutos";

	}

}
