package kr.or.ddit.util;

import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * db.properties파일의 내용으로 DB접속정보를 성정하는 방법
 * 
 * 방법2) ResourcesBundle 객체 이용하기
 */
public class JDBCUtil3 {
	
	static ResourceBundle bundle; //ResourceBundle 객체변수 선언

	
	static {
		
		bundle = ResourceBundle.getBundle("db"); 
		
		try {
			
		
			Class.forName(bundle.getString("driver"));

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패!");
			e.printStackTrace();
		} 
	}

	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(bundle.getString("url"), bundle.getString("username"), bundle.getString("password"));
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
