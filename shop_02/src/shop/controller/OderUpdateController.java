package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.MypageService;

public class OderUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int beCnt = Integer.parseInt(request.getParameter("beCnt"));
		int count = Integer.parseInt(request.getParameter("count"));
		String address = request.getParameter("address");	
		String name = request.getParameter("name");

		MypageService service = MypageService.getInstance();
		service.orderUpdate(address, count, name,beCnt);
		
		HttpUtil.forward(request, response, "/orderList.do?o=w");
	}

}
