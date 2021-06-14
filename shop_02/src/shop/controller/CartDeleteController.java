package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.MypageService;

public class CartDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id = (String)request.getParameter("c");
		String orderId = request.getParameter("a");
		String path=null;
		
		MypageService service = MypageService.getInstance();
		if(id==null && orderId!=null) {
			int count = Integer.parseInt(request.getParameter("count"));
			service.orderDelete(orderId, count);
			path="/result/orderDelete.jsp";
		}else if(id != null && orderId==null) {
			service.cartDelete(id);
			path="/cart.do";
		}		
		HttpUtil.forward(request, response, path);
	}
}
