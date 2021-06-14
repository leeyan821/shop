package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.service.MypageService;
import shop.vo.CartVO;

public class CartController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		MypageService service = MypageService.getInstance();
		ArrayList<CartVO> list = service.cart(id);
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/cart.jsp");
	}
}
