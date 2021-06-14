package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.service.MemberService;
import shop.service.ProductService;
import shop.vo.CustomVO;
import shop.vo.MemberVO;

public class CustOrderController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String[] flower = request.getParameterValues("flower");
		String plus = request.getParameter("plus");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(flower == null) {
			request.setAttribute("error", "하나 이상의 꽃을 선택해 주세요");
			HttpUtil.forward(request, response, "/customOrder.jsp");
			return;
		}
		if(type.equals("cus1")) {
			if(flower.length > 1) {
				request.setAttribute("error", "type1 : 하나의 꽃만 선택해 주세요");
				HttpUtil.forward(request, response, "/customOrder.jsp");
				return;
			}
		}else if( type.equals("cus2")) {
			if(flower.length > 3) {
				request.setAttribute("error", "type2 : 2~3개의 꽃만 선택해 주세요");
				HttpUtil.forward(request, response, "/customOrder.jsp");
				return;
			}else if(flower.length < 2) {
				request.setAttribute("error", "type2 : 꽃을 1개 이상 선택해 주세요");
				HttpUtil.forward(request, response, "/customOrder.jsp");
				return;
			}
		}
		ProductService service = ProductService.getInstance();
		ArrayList<CustomVO> custom = service.customOrder(type, flower, plus);
		MemberService s = MemberService.getInstance();
		MemberVO member = s.memberSearch(id);
		request.setAttribute("member", member);
		request.setAttribute("custom", custom);
		HttpUtil.forward(request, response, "/cusOrderList.jsp");
	}
}
