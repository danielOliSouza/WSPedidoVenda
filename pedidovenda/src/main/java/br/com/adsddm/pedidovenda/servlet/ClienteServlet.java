package br.com.adsddm.pedidovenda.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adsddm.pedidovenda.services.ClienteService;


public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteService clienteService;
	
    public ClienteServlet() {
        super();
        clienteService = new ClienteService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = clienteService.todosProdutosJSON();
		
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");
		
	    response.getWriter().print(json);
	}

}
