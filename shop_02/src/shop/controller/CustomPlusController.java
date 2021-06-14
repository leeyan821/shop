package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.service.ProductService;

public class CustomPlusController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String address = request.getParameter("address");
		String pid =request.getParameter("pid");
	
		ProductService service = ProductService.getInstance();
		service.insertProd(pid,id, 1, address);
		HttpUtil.forward(request, response, "/result/purchase.jsp");
	}

}
