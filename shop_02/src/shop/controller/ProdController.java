package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.ProductService;
import shop.vo.CustomVO;
import shop.vo.ProdVO;

public class ProdController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p = request.getParameter("p");
		String path = null;
		
		ProductService service = ProductService.getInstance();
		if(p.equals("p")) {
			ArrayList<ProdVO> list = service.productList();
			request.setAttribute("list", list);
			path="/product.jsp";
		}else if(p.equals("a")) {
			ArrayList<ProdVO> list = service.accList();
			request.setAttribute("list", list);
			path="/acc.jsp";
		}else if(p.equals("b")) {
			ArrayList<ProdVO> li = new ArrayList<ProdVO>();		
			ArrayList<ProdVO> prod = service.bestChk();
			if(prod==null) {
				request.setAttribute("list", prod);
				HttpUtil.forward(request, response, "/best.jsp");
				return;
			}
			li = service.bestList(prod);
			request.setAttribute("list", li);
			path="/best.jsp";
		}else if(p.equals("c")) {
			ArrayList<CustomVO> list = service.cusList();
			request.setAttribute("list", list);
			path="/custom.jsp";
		}
		HttpUtil.forward(request, response, path);
	}
}
