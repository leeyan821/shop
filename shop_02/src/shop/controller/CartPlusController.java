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

public class CartPlusController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int count = Integer.parseInt(request.getParameter("count"));
		String pid = request.getParameter("pid");
		String[] acc = request.getParameterValues("acc");
		String a = request.getParameter("cart");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ProductService service = ProductService.getInstance();
		
		if(id==null) {
			HttpUtil.forward(request, response, "/result/prodAdd.jsp");
		}
		
		String re = service.chkProdMax(pid, count);

		if(re!=null) {
			request.setAttribute("re", re);
			HttpUtil.forward(request, response, "/result/purchase.jsp");
			return;
		}
		
		if(!acc[0].equals("none")) {
			ProdVO accProd = service.accChk(acc[0]);
			if(accProd == null) {
				HttpUtil.forward(request, response, "/result/accError.jsp");
				return;
			}
		}

		if(a.equals("장바구니")) {
			service.cartAdd(pid,id,count);
			if(!acc[0].equals("none")){
				service.cartAdd(acc[0], id, 1);
			}
			HttpUtil.forward(request, response, "/result/prodAdd.jsp");
			return;
		}else if(a.equals("구매")) {
			ProdVO prod = service.prodChoose(pid);
			MemberService s = MemberService.getInstance();
			MemberVO member = s.memberSearch(id);
			request.setAttribute("member", member);
			request.setAttribute("prod", prod);
			request.setAttribute("cnt", count);
			if(!acc[0].equals("none")) {
				ProdVO accProd = service.accChk(acc[0]);
				request.setAttribute("accProd", accProd);
			}	
			HttpUtil.forward(request, response, "/order.jsp");
			}
		}
}
