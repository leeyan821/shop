package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.MemberService;
import shop.vo.MemberVO;

public class MailChkController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("mail");
		MemberService service = MemberService.getInstance();		
		MemberVO member = service.emailSearch(email);
		if(member==null) 
			request.setAttribute("error", "아이디가 존재하지 않습니다.");
		request.setAttribute("member",member);

		HttpUtil.forward(request, response, "/findMember.jsp");	
	}
}
