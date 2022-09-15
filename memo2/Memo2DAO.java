package memo2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import memo.MemoVO;
import oracle.jdbc.driver.OracleDriver;

//Data Access Object : Service영역과 DB영역 사이에 연계를 해줌
public class Memo2DAO {
	//싱글톤
	private static Memo2DAO instance = new Memo2DAO();
	private Memo2DAO() {}
	public  static Memo2DAO getInstance() {
		return instance;
	}
	
	//MEMO 테이블의 목록을 가져옴
	public List<Memo2VO> getMemos() throws SQLException{
		//0. ojdbc8.jar 드라이버 로딩(메모리에 올림)
		DriverManager.registerDriver(new OracleDriver());
		
		//1.오라클에 접속
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JHS", "java");
		
		//2. 쿼리 작성(나 쿼리 작성할거야. 준비해줘)
		Statement statement = connection.createStatement();
		
//		StringBuilder builder = new StringBuilder();
//		builder.append("SELECT ");
//		builder.append("    no, ");
//		builder.append("    title, ");
//		builder.append("    content, ");
//		builder.append("    writer, ");
//		builder.append("    register_date, ");
//		builder.append("    modify_date ");
//		builder.append("FROM ");
//		builder.append("    memo ");
//		String sql = builder.toString();
		
		String sql = "SELECT NO, TITLE, CONTENT, WRITER, REGISTER_DATE, MODIFY_DATE FROM MEMO";
		
		//3. 쿼리를 실행
		ResultSet resultSet = statement.executeQuery(sql);
		
		//4. Memo2VO라는 버스에 한명씩 태우자 => Memo2VO 타입의 List를 선언
		//List : interface => class로 구현 => ArrayList클래스로 구현 
		List<Memo2VO> list = new ArrayList<Memo2VO>();
		
		//.next() : 다음행으로 이동
		while(resultSet.next()) {
			int no = resultSet.getInt("no");
			String title = resultSet.getString("title");
			String content = resultSet.getString("content");
			String writer = resultSet.getString("writer");
			Date registerDate = resultSet.getDate("register_date");
			Date modifyDate = resultSet.getDate("modify_date");
			//public Memo2VO(int no, String title, String content, String writer, Date registerDate, Date modifyDate) {
			list.add(new Memo2VO(no, title, content, writer, registerDate, modifyDate));
		}
		
		//5. 자원반납(메모리를 비우자)
		resultSet.close();
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	
	
	
	
}
