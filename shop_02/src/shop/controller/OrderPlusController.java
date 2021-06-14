package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.service.ProductService;

public class OrderPlusController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		String pid = request.getParameter("pid");
		String apid = request.getParameter("apid");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String address = request.getParameter("address");

		ProductService service = ProductService.getInstance();
		service.insertProd(pid, id, cnt, address);
		service.deleteMax(pid, cnt);
		if(apid!=null) {
			service.insertProd(apid, id, 1, address);
			service.deleteMax(apid, 1);
		}		
		HttpUtil.forward(request, response, "/result/purchase.jsp");
	}
}
