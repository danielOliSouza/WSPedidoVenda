package br.com.adsddm.pedidovenda.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adsddm.pedidovenda.services.PedidoVendaServices;

/**
 * Servlet implementation class PedidoVendaServlet
 */
public class PedidoVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoVendaServices pedidoVendaServices;
    public PedidoVendaServlet() {
        super();
        pedidoVendaServices = new PedidoVendaServices();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txt = pedidoVendaServices.exemploJson();
		
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json");
	    response.getWriter().print(txt);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String json = request.getParameter("json");
		//String status = "OK";
		//if(!json.isEmpty()){
			pedidoVendaServices.salvar("");
		//}
		//else{
		//	status = "invalid";
		//}
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/plain");
	    response.getWriter().print("ok");
	}
}
