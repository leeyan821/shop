package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.vo.MemberVO;
import shop.vo.ProdVO;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	public MemberDAO() {}
	public static MemberDAO getInstance() {
		return dao;
	}

	public boolean login(String id, String pwd) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn =JdbcDAO.con();
			pstmt=conn.prepareStatement("select * from member where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next())
				result = true;
			else
				result = false;
		}catch(Exception e)
		{
			System.out.print("login error"+e);
		}
		finally
		{
			JdbcDAO.close(conn, pstmt, rs);
		}		
		return result;
	}
	public MemberVO memberSearch(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		try
		{
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select * from member where id=?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPwd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setMail(rs.getString(4));
				member.setPhone(rs.getString(5));
				member.setAdress(rs.getString(6));
			}
		}catch(Exception e) {
			System.out.print("Search error"+e);
		}finally
		{
			JdbcDAO.close(conn, pstmt, rs);
		}
		return member;
	}
	public void join(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?,?);");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMail());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getAdress());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.print("join"+e);
		}finally {
			JdbcDAO.close(conn, pstmt);
		}	
	}
	public MemberVO mailSearch(String mail) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		try
		{
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select * from member where mail=?;");
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPwd(rs.getString(2));				
			}
		}catch(Exception e) {
			System.out.print("mail Search error"+e);
		}finally
		{
			JdbcDAO.close(conn, pstmt, rs);
		}
		return member;
	}
}
