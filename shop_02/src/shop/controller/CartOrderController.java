package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.service.MemberService;
import shop.service.ProductService;
import shop.vo.MemberVO;
import shop.vo.ProdVO;

public class CartOrderController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = Integer.parseInt(request.getParameter("count"));
		String pid = request.getParameter("pid");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ProductService service = ProductService.getInstance();

		ProdVO prod = service.prodChoose(pid);
		MemberService s = MemberService.getInstance();
		MemberVO member = s.memberSearch(id);
		request.setAttribute("member", member);
		request.setAttribute("prod", prod);
		request.setAttribute("cnt", count);
		HttpUtil.forward(request, response, "/order.jsp");
	}
}
