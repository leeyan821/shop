package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.MemberService;
import shop.vo.MemberVO;

public class JoinController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String id = request.getParameter("uid");	
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("uname");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("umail");
		String adress = request.getParameter("adress");
		
		MemberService service = MemberService.getInstance();		
		MemberVO check = service.memberSearch(id);
		if(check!=null) {
			request.setAttribute("error", "over");
			HttpUtil.forward(request, response, "/result/joinOutput.jsp");
			return;
		}
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setMail(mail);
		member.setPhone(phone);
		member.setAdress(adress);
		
		service.join(member);	
		request.setAttribute("error", "com");
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/result/joinOutput.jsp");
	}
}
