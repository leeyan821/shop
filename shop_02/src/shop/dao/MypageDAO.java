package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.vo.CartVO;
import shop.vo.MemberVO;


public class MypageDAO {
	private static MypageDAO dao = new MypageDAO();
	public MypageDAO() {}
	public static MypageDAO getInstance() {
		return dao;
	}
	public MemberVO update(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("update member set name=?, mail=?,phone=?,adress=? where id=?;");
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getMail());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAdress());
			pstmt.setString(5, member.getId());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.print("update error"+e);
		}finally {
			JdbcDAO.close(conn, pstmt);
		}
		return member;
	}
	
	public ArrayList<CartVO> cart(String id) {
		ArrayList<CartVO> list = new ArrayList<CartVO>();
		Connection conn = null;
		ResultSet rs = null;	
		PreparedStatement pstmt = null;		
		CartVO cart = null;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select a.name, a.price, b.count, a.image, b.id, b.pid from product a, cart b where b.mid=? and b.pid=a.pid;");
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cart = new CartVO();
				cart.setName(rs.getString(1));
				cart.setPrice(Integer.parseInt(rs.getString(2)));
				cart.setCount(Integer.parseInt(rs.getString(3)));
				cart.setImage(rs.getString(4));
				cart.setId(rs.getString(5));
				cart.setPid(rs.getString(6));
				list.add(cart);			
			}
		}catch(SQLException e) {
			System.out.println("cart error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
		return list;
	}
	public void cartDelete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("delete from cart where id=?;");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.print("delete error"+e);
		}finally {
			JdbcDAO.close(conn, pstmt);
		}		
	}
	public void orderDelete(String order, int count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		try
		{
			conn = JdbcDAO.con();			
			pstmt = conn.prepareStatement("select a.max from product a, purchase b where b.id=? and b.pid=a.pid;");
			pstmt.setString(1,order);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				num = rs.getInt(1);
			}
			
			num = num + count;
			pstmt = conn.prepareStatement("update product set max=? where pid=(select pid from purchase where id=?);");
			pstmt.setString(1, num+"");
			pstmt.setString(2, order);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from purchase where id=?;");
			pstmt.setString(1, order);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.print("delete error"+e);
		}finally {
			JdbcDAO.close(conn, pstmt);
		}	
	}
	public ArrayList<CartVO> order(String id) {
		ArrayList<CartVO> list = new ArrayList<CartVO>();
		Connection conn = null;
		ResultSet rs = null;	
		PreparedStatement pstmt = null;		
		CartVO order = null;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select a.name, a.price, b.count, a.image, b.odate, b.address, b.id, a.pid from product a, purchase b where b.mid=? and b.pid=a.pid;");
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				order = new CartVO();
				order.setName(rs.getString(1));
				order.setPrice(Integer.parseInt(rs.getString(2)));
				order.setCount(Integer.parseInt(rs.getString(3)));
				order.setImage(rs.getString(4));
				order.setDate(rs.getString(5));
				order.setAddress(rs.getString(6));
				order.setId(rs.getString(7));
				order.setPid(rs.getString(8));
				list.add(order);			
			}
		}catch(SQLException e) {
			System.out.println("order error"+e);
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
		return list;
	}
	public void orderUpdate(String address, int count, String name, int beCnt) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("update purchase set address=?, count=?, odate=current_date where pid=(select pid from product where name=?);");
			pstmt.setString(1,address);
			pstmt.setInt(2,count);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
			if(count > beCnt) {
				int num = count - beCnt;
				pstmt = conn.prepareStatement("update product set max=max-? where name=?;");
				pstmt.setInt(1, num);
				pstmt.setString(2, name);	
				pstmt.executeUpdate();
			}else if(count < beCnt) {
				int num = beCnt - count;
				pstmt = conn.prepareStatement("update product set max=max+? where name=?;");
				pstmt.setInt(1, num);
				pstmt.setString(2, name);
				pstmt.executeUpdate();
			}		
		}catch(Exception e) {
			System.out.print("order update"+e);
		}finally {
			JdbcDAO.close(conn, pstmt);
		}
	}
	public CartVO orderChoose(String o) {
		Connection conn = null;
		ResultSet rs = null;	
		PreparedStatement pstmt = null;			
		CartVO order = null;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select a.name, a.price, b.count, a.image, b.odate, b.address, b.id, a.pid from product a, purchase b where b.id=? and b.pid=a.pid;");
			pstmt.setString(1, o);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order = new CartVO();
				order.setName(rs.getString(1));
				order.setPrice(Integer.parseInt(rs.getString(2)));
				order.setCount(Integer.parseInt(rs.getString(3)));
				order.setImage(rs.getString(4));
				order.setDate(rs.getString(5));
				order.setAddress(rs.getString(6));
				order.setId(rs.getString(7));
				order.setPid(rs.getString(8));		
			}
		}catch(SQLException e) {
			System.out.println("order choose error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
		return order;
	}
}
