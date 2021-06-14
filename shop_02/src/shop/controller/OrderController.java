package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.service.MypageService;
import shop.vo.CartVO;

public class OrderController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String o = request.getParameter("o");
		String path = null;

		MypageService service = MypageService.getInstance();
		if(o.equals("w")) {
			ArrayList<CartVO> list = service.order(id);
			request.setAttribute("list", list);
			path="/orderList.jsp";			
		}
		else {
			CartVO order = service.orderChoose(o);
			request.setAttribute("order", order);		
			path="/orderUpdate.jsp";
		}
		HttpUtil.forward(request, response, path);
	}
}
