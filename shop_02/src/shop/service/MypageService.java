package shop.service;

import java.util.ArrayList;

import shop.dao.MypageDAO;
import shop.vo.CartVO;
import shop.vo.MemberVO;

public class MypageService {
	private static MypageService service = new MypageService();
	private MypageService() {}
	public MypageDAO dao = MypageDAO.getInstance();
	public static MypageService getInstance() {
		return service;
	}
	public MemberVO memberUpdate(MemberVO member) {
		return dao.update(member);
	}
	public ArrayList<CartVO> cart(String id) {
		return dao.cart(id);
	}
	public void cartDelete(String id) {
		dao.cartDelete(id);		
	}
	public void orderDelete(String order, int count) {
		dao.orderDelete(order,count);		
	}
	public ArrayList<CartVO> order(String id) {
		return dao.order(id);
	}
	public void orderUpdate(String address, int count, String name, int beCnt) {
		dao.orderUpdate(address,count,name,beCnt);
	}
	public CartVO orderChoose(String o) {
		return dao.orderChoose(o);
	}
}
