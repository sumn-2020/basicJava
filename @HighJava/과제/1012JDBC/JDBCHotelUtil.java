package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC 드라이버를 로딩하고  Connection객체를 생성하는 기능 제공 
 *
 */
public class JDBCHotelUtil {
	
	
	//driver 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}
	
	
	//connection url
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "practice", "java");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//close
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) try{ rs.close(); } catch(SQLException ex) {} //rs가 null이 아니면 close 시켜주기 
		if(stmt != null) try{ stmt.close(); } catch(SQLException ex) {}
		if(pstmt != null) try{ pstmt.close(); } catch(SQLException ex) {}
		if(conn != null) try{ conn.close(); } catch(SQLException ex) {} //conn도  null이 아니면 close 시켜주기
	}

}
