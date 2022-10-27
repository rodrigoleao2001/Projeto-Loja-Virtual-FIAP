package br.com.fiap.jdbc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {

	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	// design pattern command
}
