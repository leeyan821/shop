package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.vo.CustomVO;
import shop.vo.ProdVO;

public class ProductDAO {
	private static ProductDAO dao = new ProductDAO();
	public ProductDAO() {}
	public static ProductDAO getInstance() {
		return dao;
	}

	public ArrayList<ProdVO> productList() {
		ArrayList<ProdVO> list = new ArrayList<ProdVO>();
		Connection conn = null;
		ResultSet rs = null;	
		PreparedStatement pstmt = null;			
		ProdVO prod = null;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select * from product where category='product';");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				prod = new ProdVO();
				prod.setPid(rs.getString(1));
				prod.setName(rs.getString(2));
				prod.setPrice(Integer.parseInt(rs.getString(3)));
				prod.setDetail(rs.getString(5));
				prod.setImg(rs.getString(7));
				list.add(prod);			
			}
		}catch(SQLException e) {
			System.out.println("prod error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
		return list;
	}
	public ProdVO prodChoose(String pid) {
		Connection conn = null;
		ResultSet rs = null;	
		PreparedStatement pstmt = null;			
		ProdVO prod = null;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select * from product where pid=?;");
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				prod = new ProdVO();
				prod.setPid(rs.getString(1));
				prod.setName(rs.getString(2));
				prod.setPrice(Integer.parseInt(rs.getString(3)));
				prod.setMax(Integer.parseInt(rs.getString(4)));
				prod.setDetail(rs.getString(5));
				prod.setImg(rs.getString(7));		
			}
		}catch(SQLException e) {
			System.out.println("product choose error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
		return prod;
	}
	public void cartAdd(String pid, String id, int count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select id from cart;");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				if(num<rs.getInt(1))
				num = rs.getInt(1);
			}
			num = num+1;

			pstmt = conn.prepareStatement("insert into cart values(?,?,?,?);");
			pstmt.setString(1, num+"");
			pstmt.setString(2, pid);
			pstmt.setString(3, id);
			pstmt.setString(4, count+"");
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("cart Add error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
	}
	public ProdVO accChk(String acc) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProdVO prod = null;
		int num = 0;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select * from product where pid=?;");
			pstmt.setString(1, acc);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(4);
			}
			if(num<=0) {
				return prod;
			}
			
			pstmt = conn.prepareStatement("select * from product where pid=?;");
			pstmt.setString(1, acc);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				prod = new ProdVO();
				prod.setPid(rs.getString(1));
				prod.setName(rs.getString(2));
				prod.setPrice(Integer.parseInt(rs.getString(3)));
				prod.setMax(Integer.parseInt(rs.getString(4)));
				prod.setDetail(rs.getString(5));
				prod.setImg(rs.getString(7));		
			}
			
		}catch(SQLException e) {
			System.out.println("add acc error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
		return prod;
	}
	public void insertProd(String pid, String id, int cnt, String address) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select id from purchase;");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				if(num<rs.getInt(1))
				num = rs.getInt(1);
			}
			num = num+1;
			
			pstmt = conn.prepareStatement("insert into purchase values(?,?,?,?,current_date,?);");
			pstmt.setString(1, num+"");
			pstmt.setString(2, pid);
			pstmt.setString(3, id);
			pstmt.setString(4, cnt+"");
			pstmt.setString(5, address);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("purchase error"+e);
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}	
	}
	public void deleteMax(String pid, int cnt) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select max from product where pid=?;");
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				num = rs.getInt(1);
			}
			num = num-cnt;
			pstmt = conn.prepareStatement("update product set max=? where pid=?;");
			pstmt.setString(1, num+"");
			pstmt.setString(2, pid);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("max error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}			
	}
	public ArrayList<ProdVO> accList() {
		ArrayList<ProdVO> list = new ArrayList<ProdVO>();
		Connection conn = null;
		ResultSet rs = null;	
		PreparedStatement pstmt = null;			
		ProdVO prod = null;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select * from product where category='acc';");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				prod = new ProdVO();
				prod.setPid(rs.getString(1));
				prod.setName(rs.getString(2));
				prod.setPrice(Integer.parseInt(rs.getString(3)));
				prod.setDetail(rs.getString(5));
				prod.setImg(rs.getString(7));
				list.add(prod);			
			}
		}catch(SQLException e) {
			System.out.println("acc error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
		return list;
	}
	public ArrayList<ProdVO> bestChk() {
		ArrayList<ProdVO> list = new ArrayList<ProdVO>();
		Connection conn = null;
		ResultSet rs = null;	
		PreparedStatement pstmt = null;			
		ProdVO prod = null;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select sum(count) as sum, pid from purchase group by pid order by sum desc;");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				prod = new ProdVO();
				prod.setSum(Integer.parseInt(rs.getString(1)));
				prod.setPid(rs.getString(2));	
				list.add(prod);
			}
		}catch(SQLException e) {
			System.out.println("best check error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
		return list;
	}
	public ArrayList<ProdVO> bestList(ArrayList<ProdVO> prod) {
		ArrayList<ProdVO> list = new ArrayList<ProdVO>();
		Connection conn = null;
		ResultSet rs = null;	
		PreparedStatement pstmt = null;			
		ProdVO best = null;
		ProdVO product = null;
		try {
			conn = JdbcDAO.con();
			for(int i=0;i<prod.size();i++) {
				best = prod.get(i);
				String id = best.getPid();
				pstmt = conn.prepareStatement("select * from product where pid=?;");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
				product = new ProdVO();
				product.setPid(rs.getString(1));
				product.setName(rs.getString(2));
				product.setPrice(Integer.parseInt(rs.getString(3)));
				product.setDetail(rs.getString(5));
				product.setImg(rs.getString(7));
				list.add(product);
				}
			}
		}catch(SQLException e) {
			System.out.println("best error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
		return list;
	}
	public ArrayList<CustomVO> cusList() {
		ArrayList<CustomVO> list = new ArrayList<CustomVO>();
		Connection conn = null;
		ResultSet rs = null;	
		PreparedStatement pstmt = null;			
		CustomVO prod = null;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select * from custom;");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				prod = new CustomVO();
				prod.setId(rs.getString(6));
				prod.setName(rs.getString(1));
				prod.setPrice(Integer.parseInt(rs.getString(2)));
				prod.setColor(rs.getString(3));
				prod.setDetail(rs.getString(4));
				prod.setImg(rs.getString(5));
				list.add(prod);			
			}
		}catch(SQLException e) {
			System.out.println("custom error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
		return list;
	}
	public String chkProdMax(String pid, int count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String re=null;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select max from product where pid=?;");
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				num = rs.getInt(1);
			}

			if(num-count < 0) {
				re = "n";
			}
		}catch(SQLException e) {
			System.out.println("max error");
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}	
		return re;
	}
	public ArrayList<CustomVO> customOrder(String type, String[] flower, String plus) {
		ArrayList<CustomVO> list = new ArrayList<CustomVO>();
		Connection conn = null;
		ResultSet rs = null;	
		PreparedStatement pstmt = null;			
		CustomVO prod = null;
		try {
			conn = JdbcDAO.con();
			pstmt = conn.prepareStatement("select * from custom where `cusid`=?;");
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				prod = new CustomVO();
				prod.setId(rs.getString(6));
				prod.setName(rs.getString(1));
				prod.setPrice(Integer.parseInt(rs.getString(2)));
				prod.setColor(rs.getString(3));
				prod.setDetail(rs.getString(4));
				prod.setImg(rs.getString(5));
				list.add(prod);			
			}
			for(int i=0; i<flower.length;i++) {
				pstmt = conn.prepareStatement("select * from custom where `cusid`=?;");
				pstmt.setString(1, flower[i]);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					prod = new CustomVO();
					prod.setId(rs.getString(6));
					prod.setName(rs.getString(1));
					prod.setPrice(Integer.parseInt(rs.getString(2)));
					prod.setColor(rs.getString(3));
					prod.setDetail(rs.getString(4));
					prod.setImg(rs.getString(5));
					list.add(prod);			
				}
			}
			pstmt = conn.prepareStatement("select * from custom where `cusid`=?;");
			pstmt.setString(1, plus);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				prod = new CustomVO();
				prod.setId(rs.getString(6));
				prod.setName(rs.getString(1));
				prod.setPrice(Integer.parseInt(rs.getString(2)));
				prod.setColor(rs.getString(3));
				prod.setDetail(rs.getString(4));
				prod.setImg(rs.getString(5));
				list.add(prod);			
			}
		}catch(SQLException e) {
			System.out.println("custom Order error"+e);
		}finally {	
			JdbcDAO.close(conn, pstmt, rs);
		}
		return list;
	}
}
