package shop.service;

import shop.dao.MemberDAO;
import shop.vo.MemberVO;

public class MemberService {
	private static MemberService service = new MemberService();
	private MemberService() {}
	public MemberDAO dao = MemberDAO.getInstance();
	public static MemberService getInstance() {
		return service;
	}
	public boolean Login(String id, String pwd) {
		return dao.login(id,pwd);
	}
	public MemberVO memberSearch(String id) {
		return dao.memberSearch(id);
	}
	public void join(MemberVO member) {
		dao.join(member);		
	}
	public MemberVO emailSearch(String mail) {
		return dao.mailSearch(mail);
	}
}
