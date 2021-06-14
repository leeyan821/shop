package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.service.MemberService;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		if(id.isEmpty() || pwd.isEmpty()) {
			request.setAttribute("error", "ID/Password 모두 입력해주세요");
			HttpUtil.forward(request,response,"/login.jsp");
			return;
		}		
		MemberService service = MemberService.getInstance();
		String path=null;
				
		boolean result = service.Login(id,pwd);
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path="/main.jsp";
		}else {
			request.setAttribute("error", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			path="/logIn.jsp";
		}
		HttpUtil.forward(request, response, path);
		
	}
}
