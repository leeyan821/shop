package shop.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String,Controller> list = null;
	String charset = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/login.do", new LoginController());
		list.put("/logout.do", new LogoutController());
		list.put("/join.do", new JoinController());
		list.put("/idcheck.do", new IdChkController());
		list.put("/mailchk.do", new MailChkController());
		list.put("/mypage.do", new MypageController());
		list.put("/memberUpdate.do", new UpdateController());
		list.put("/cart.do", new CartController());
		list.put("/delete.do", new CartDeleteController());
		list.put("/orderList.do", new OrderController());
		list.put("/orderUpdate.do", new OderUpdateController());
		list.put("/product.do", new ProdController());
		list.put("/prodSearch.do", new ProdFindController());
		list.put("/cartPlus.do", new CartPlusController());
		list.put("/orderPlus.do", new OrderPlusController());
		list.put("/customOrder.do", new CustOrderController());
		list.put("/customPlus.do", new CustomPlusController());
		list.put("/cartOrder.do", new CartOrderController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subcontroller = list.get(path);
		subcontroller.execute(req, resp);
	}
}
