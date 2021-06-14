package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.ProductService;
import shop.vo.ProdVO;

public class ProdFindController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		
		ProductService service = ProductService.getInstance();
		ProdVO product = new ProdVO();
		product = service.prodChoose(pid);
		request.setAttribute("product", product);

		HttpUtil.forward(request, response,"/prodChoose.jsp" );
	}

}
