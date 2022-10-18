package kr.or.ddit.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * db.properties파일의 내용을 DB접속정보를 설정하는 방법
 * 
 * 방법1) Properties객체 이용하기 방법2) ResourcesBundle 객체 이용하기
 */
public class JDBCUtil {

	static Properties prop; // Properties 객체변수 선언

	// Class.forName : 드라이버 로딩하기
	static {
		prop = new Properties(); // Properties객체 생성

		try {

			prop.load(new FileInputStream("res/db.properties"));  //db.properties파일에서 db정보 가져오기
			Class.forName(prop.getProperty("driver"));

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	// connection만들기 => conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "practice", "java");
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("password"));	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	//자원반납 : close(); 
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) try{ rs.close(); } catch(SQLException ex) {} //rs가 null이 아니면 close 시켜주기 
		if(stmt != null) try{ stmt.close(); } catch(SQLException ex) {}
		if(pstmt != null) try{ pstmt.close(); } catch(SQLException ex) {}
		if(conn != null) try{ conn.close(); } catch(SQLException ex) {} //conn도  null이 아니면 close 시켜주기
	}

	
}
