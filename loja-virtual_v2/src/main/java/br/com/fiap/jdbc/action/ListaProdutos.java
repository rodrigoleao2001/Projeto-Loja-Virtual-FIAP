package br.com.fiap.jdbc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.jdbc.dao.ProdutoDAO;
import br.com.fiap.jdbc.model.Produto;

public class ListaProdutos implements Acao {

	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProdutoDAO produtoDAO = new ProdutoDAO();

		List<Produto> produtos = new ArrayList<Produto>();
		produtos = produtoDAO.listarTodos();

		request.setAttribute("produtos", produtos);
		return "forward:listaProdutos.jsp";

	}

}
