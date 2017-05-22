package br.com.adsddm.pedidovenda.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adsddm.pedidovenda.services.ProdutoService;

/**
 * Servlet implementation class TodosProdutos
 */


@WebServlet("/produto")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProdutoService produtoService;
	
	
    public ProdutoServlet() {
        super();
        produtoService = new ProdutoService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = produtoService.todosProdutosJSON();
		
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");
		
	    response.getWriter().print(json);
	}
}
