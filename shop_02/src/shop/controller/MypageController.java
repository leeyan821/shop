package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.service.MemberService;
import shop.vo.MemberVO;

public class MypageController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/mypage.jsp";
		String p = request.getParameter("p");
		if(p.equals("up")) {
			path="/memberUpdate.jsp";
		}
		else if(p.equals("w")) {
			path = "/mypage.jsp";
		}
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
	
		MemberService service = MemberService.getInstance();
		MemberVO member = service.memberSearch(id);
		
		request.setAttribute("member", member);

		HttpUtil.forward(request, response, path);
	}
}
