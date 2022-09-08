package jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCEXample {
	public static void main(String[] args) throws Exception { // 모든 에러를 전부 다 던지겠다

		// 0. 드라이버 로딩(리플렉션 기법 사용)
		Class.forName("oracle.jdbc.driver.OracleDriver");

		
		
		// 1. DB접속(서버주소, 아이디, 패스워드)
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JHS", "java");
		// 내 로컬 : 127.0.0.1:1521:xe / localhost:1521:xe
		// 남의 로컬 : 192.168.35.75???

		
		
		// 2. 연결된 DB에 요청할 쿼리 작성
		Statement statement = connection.createStatement(); // sql developer 워크시트 생성
		String sql = ""; // 쿼리 작성
		sql += " SELECT"; // 무조건 앞에 한칸 띄워야됨
		sql += "     mem_id,";
		sql += "     mem_name,";
		sql += "     mem_hp,";
		sql += "     mem_mail";
		sql += " FROM"; // 무조건 앞에 한칸 띄워야됨
		sql += "     member";

		
		
		// 3. 쿼리 실행 후 받기
		ResultSet resultSet = statement.executeQuery(sql);
		// executeQuery : select => 결과집합(ResultSet)을 반환
		// excuteUpate : insert, update, delete => 실행된 갯수 반환

		// 4. 실행결과 받아서 출력
		while (resultSet.next()) { // 그 다음 데이터가 존재 하면 (=각 행을 한줄 씩 점검하면서 데이터가 존재하면)
			String memId = resultSet.getString("mem_id");// 데이터 있으면 꺼내오고 데이터가 없을때까지 계속 반복
			String memName = resultSet.getString("mem_name");
			String memHp = resultSet.getString("mem_hp");
			String memMail = resultSet.getString("mem_mail");
			System.out.printf("%s \t %s \t %s \t %s \n", memId, memName, memHp, memMail);
		}

		
		
		// 5. 접속 종료
		resultSet.close();
		statement.close();
		connection.close();

	}
}
