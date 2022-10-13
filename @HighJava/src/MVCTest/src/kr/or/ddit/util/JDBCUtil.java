package kr.or.ddit.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC 드라이버를 로딩하고 Connection 객체를 생성하는 기능 제공
 */
public class JDBCUtil {

	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패!");
			e.printStackTrace();
		}
	}

	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "practice", "java");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) try{ rs.close(); } catch(SQLException ex) {} //rs가 null이 아니면 close 시켜주기 
		if(stmt != null) try{ stmt.close(); } catch(SQLException ex) {}
		if(pstmt != null) try{ pstmt.close(); } catch(SQLException ex) {}
		if(conn != null) try{ conn.close(); } catch(SQLException ex) {} //conn도  null이 아니면 close 시켜주기
	}
	

}
