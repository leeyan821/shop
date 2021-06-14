package shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDAO {
	public static Connection con() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","say17405*");
		}catch(Exception e) {
			System.out.println("connect error"+e);
		}
		return conn;
	}
	public static void close(Connection conn, PreparedStatement pstmt) {
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception e) {
				System.out.print("Conn close error"+e);
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.print("Pstmt close error"+e);
			}
		}
	}	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null)
		{
			try {
				rs.close();
			}catch(Exception e) {
				System.out.print("Rs close error"+e);
			}
		}
		close(conn,pstmt);
	}
}
