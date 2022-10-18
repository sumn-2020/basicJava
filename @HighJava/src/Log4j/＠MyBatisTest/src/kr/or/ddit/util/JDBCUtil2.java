package kr.or.ddit.util;

import java.sql.Statement;
import java.util.Properties;
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
 * 방법1) Properties객체 이용하기 
 */
public class JDBCUtil2 {
	
	static Properties prop; //Properties 객체변수 선언

	
	static {
		
		prop = new Properties(); // Properties 객체 생
		
		try {
			
			prop.load(new FileInputStream("res/db.properties"));
			Class.forName(prop.getProperty("driver"));

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
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
