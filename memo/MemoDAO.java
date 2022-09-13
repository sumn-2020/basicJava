package memo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

//Database Access Object 데이터베이스에 접근하는 객체
public class MemoDAO {
	
	public List<MemoVO> getMemos() throws Exception {
		//0. 드라이버 로딩
//		getClass().forName("oracle.jdbc.driver.OracleDriver"); //방법1
		DriverManager.registerDriver(new OracleDriver()); //방법2
		
		//1. 접속
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JHS", "java");
		
		//2. 쿼리 작성
		Statement statement = connection.createStatement();
		//문자열 관리방법 : String vs StringBuilder(ArrayList의 형태) vs StringBuffer(Vector의 형태, Thread Safe)
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("    no, ");
		builder.append("    title, ");
		builder.append("    content, ");
		builder.append("    writer, ");
		builder.append("    register_date, ");
		builder.append("    modify_date ");
		builder.append("FROM ");
		builder.append("    memo ");
		String sql = builder.toString();//toString하면 문자열로 바뀜 
		
		//3. 쿼리 전송
		ResultSet resultSet = statement.executeQuery(sql);
		
		//4. 결과 정리
		List<MemoVO> list = new ArrayList<>();
		
		while(resultSet.next()) {
			int no = resultSet.getInt("no");
			String title = resultSet.getString("title");
			String content = resultSet.getString("content");
			String writer = resultSet.getString("writer");
			Date registerDate = resultSet.getDate("register_date");
			Date modifyDate = resultSet.getDate("modify_date");
			//momoVO안에 이것들을 하나씩 넣어준다 =>momoVO파일로 가서 필드랑 gettersetter 다 만든 후 
			// List<MemoVO> list = new ArrayList<>()만든 후 여기에다가 memoVO안에 있는 내용물들을 넣어 준다. 
			list.add(new MemoVO(no, title, content, writer, registerDate, modifyDate));
		}
		
		//5. 자원 반납
		resultSet.close();
		statement.close();
		connection.close();
		
		return list;
	}

}
