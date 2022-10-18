package kr.or.ddit.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * sqlSession객체를 제공하는 팩토리 클래스
 * xml 파일 읽어옴
 * 
 */
public class MyBatisUtil {

	private static SqlSessionFactory sessionFactory;

	static {

		try {
			// 1-1. mybatis-config.xml 설정파일 읽어오기
			// 설정파일 인코딩 정보 설정하기delete
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);

			Reader rd = Resources.getResourceAsReader("mybatis-config.xml");

			// 1-2. 위에서 읽어온 Reader 객체를 이용하여 SqlSessionFactory객체 생성하기
			sessionFactory = new SqlSessionFactoryBuilder().build(rd);
			rd.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * sqlSession객체를 제공하는 팩토리 메서드 sqlsession 객체 만든 후 sesson 열어주기
	 */
	public static SqlSession getSqlSession() {
		return sessionFactory.openSession();
	}

	/**
	 * 할때마다 커밋하는거 귀찮으니까 auto커밋 설정
	 * 
	 * @param autoCommit
	 * @return
	 */
	public static SqlSession getSqlSession(boolean autoCommit) {
		return sessionFactory.openSession(autoCommit);
	}

}
