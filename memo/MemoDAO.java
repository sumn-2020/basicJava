package memo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

//Database Access Object 데이터베이스에 접근하는 객체
public class MemoDAO {

	public List<MemoVO> getMemos() throws Exception {
		// 0. 드라이버 로딩
//		getClass().forName("oracle.jdbc.driver.OracleDriver"); //방법1
		DriverManager.registerDriver(new OracleDriver()); // 방법2

		// 1. 접속
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JHS", "java");

		// 2. 쿼리 작성
		Statement statement = connection.createStatement();
		// 문자열 관리방법 : String vs StringBuilder(ArrayList의 형태) vs StringBuffer(Vector의 형태,
		// Thread Safe)
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
		String sql = builder.toString();// toString하면 문자열로 바뀜

		// 3. 쿼리 전송
		ResultSet resultSet = statement.executeQuery(sql);

		// 4. 결과 정리
		List<MemoVO> list = new ArrayList<>();

		while (resultSet.next()) {
			int no = resultSet.getInt("no");
			String title = resultSet.getString("title");
			String content = resultSet.getString("content");
			String writer = resultSet.getString("writer");
			Date registerDate = resultSet.getDate("register_date");
			Date modifyDate = resultSet.getDate("modify_date");
			// momoVO안에 이것들을 하나씩 넣어준다 =>momoVO파일로 가서 필드랑 gettersetter 다 만든 후
			// List<MemoVO> list = new ArrayList<>()만든 후 여기에다가 memoVO안에 있는 내용물들을 넣어 준다.
			list.add(new MemoVO(no, title, content, writer, registerDate, modifyDate));
		}

		// 5. 자원 반납
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	

	//한 개만 보이게 하기
	public MemoVO getMemo(int searchNo) throws Exception {
		// 0. 드라이버 로딩
//		Class.forName("oracle.jdbc.driver.OracleDriver");
		DriverManager.registerDriver(new OracleDriver());
		// 1. 접속
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JHS", "java");
		// 2. 쿼리 작성
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
		builder.append("WHERE ");
		builder.append("    no = ? ");
		String sql = builder.toString();
		
		// 3. 준비된 쿼리에 데이터 입력
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, searchNo);
		
		// 4. 쿼리 실행
		ResultSet resultSet = statement.executeQuery();
		
		// 5. 쿼리 결과 가져오기
		MemoVO vo = null;
		if (resultSet.next()) {
			int no = resultSet.getInt("no");
			String title = resultSet.getString("title");
			String content = resultSet.getString("content");
			String writer = resultSet.getString("writer");
			Date registerDate = resultSet.getDate("register_date");
			Date modifyDate = resultSet.getDate("modify_date");
			vo = new MemoVO(no, title, content, writer, registerDate, modifyDate);
		}
		
		// 6. 자원 반납
		resultSet.close();
		statement.close();
		connection.close();

		return vo;
	}
	



	// 등록
	public int insertMemo(MemoVO vo) throws Exception { // 받아올 데이터가 두개 이상이면 아예 통째로 받아서 통째로 쓰는게 편함 MemoVO전체를 받아와서
		// 0. 드라이버 로딩
		DriverManager.registerDriver(new OracleDriver()); // 방법2

		// 1. 접속
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JHS", "java");

		// 2. 쿼리 작성
		Statement statement = connection.createStatement();

		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO memo ( ");
		builder.append("    no, ");
		builder.append("    title, ");
		builder.append("    content, ");
		builder.append("    writer ");
		builder.append(") VALUES ( ");
		builder.append("    seq_memo.NEXTVAL, ");
		builder.append("    '" + vo.getTitle() + "', "); // MemoVO에 있는 title 갸져오기
		builder.append("    '" + vo.getContent() + "', ");
		builder.append("    '" + vo.getWriter() + "' ");
		builder.append(") ");
		String sql = builder.toString();

		// 3. 쿼리 전송
		// insert, update, delete 명령문을 실행할 때 호출
		// 결과값은 실행된 갯수가 반환
		int executeUpdate = statement.executeUpdate(sql);

		// 4. 결과 정리

		// 5. 자원 반납

		statement.close();
		connection.close();

		return executeUpdate;

	}


	
	
	
	
	// 업데이트 - 복사해서 쓰면 이거 쓰기!
	public int updateMemo(MemoVO vo) throws Exception {
		// 0. 드라이버 로딩
		DriverManager.registerDriver(new OracleDriver()); // 방법2

		// 1. 접속
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JHS", "java");

		// 2. 쿼리 작성
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE memo ");
		builder.append("    SET ");
		builder.append("        title = ?, ");
		builder.append("        content = ?, ");
		builder.append("        writer = ?, ");
		builder.append("        modify_date = sysdate ");
		builder.append("WHERE ");
		builder.append("    no = ? ");
		String sql = builder.toString();

		// 3. "준비된" 쿼리에 데이터 입력
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getTitle());// 1번째에 vo에 있는 getTitle 넣기
		statement.setString(2, vo.getContent());
		statement.setString(3, vo.getWriter());
		statement.setInt(4, vo.getNo());
		int executeUpdate = statement.executeUpdate();

		// 4. 자원반납
		statement.close();
		connection.close();
		return executeUpdate;
	}

	// 삭제
	public int deleteMemo(int deleteNo) throws Exception { // 삭제는 하나만 받아오면 되니까 객체 전부 받아올 필요 없이 int deleteNo
		// 0. 드라이버 로딩
		DriverManager.registerDriver(new OracleDriver()); // 방법2

		// 1. 접속
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JHS", "java");

		// 2. 쿼리 작성
		StringBuilder builder = new StringBuilder();
		builder.append("DELETE FROM  ");
		builder.append(" memo ");
		builder.append("		WHERE NO = ? ");
		String sql = builder.toString();

		// 4. 자원반납
		Statement statement = connection.prepareStatement(sql);
		int executeUpdate = statement.executeUpdate(sql);
		statement.close();
		connection.close();
		return executeUpdate;
	}

}
