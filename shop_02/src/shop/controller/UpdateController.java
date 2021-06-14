package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.MypageService;
import shop.vo.MemberVO;

public class UpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String adress = request.getParameter("adress");
	
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setName(name);
		member.setMail(mail);
		member.setPhone(phone);
		member.setAdress(adress);
		
		MypageService service = MypageService.getInstance();
		MemberVO m = service.memberUpdate(member);

		request.setAttribute("member", m);
		HttpUtil.forward(request, response, "/mypage.do?p=w");
	}
}
