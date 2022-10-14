package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.member.vo.MemberVO;

public class MyBatisTest {
	public static void main(String[] args) {

		// MyBatis를 이용하여 DB데이터를 처리하는 작업순서
		// 1. MyBatis의 환경설정파일을 읽어와 실행시킨다.
		SqlSessionFactory sqlSessionFactory = null;

		try {

			// 1-1. xml설정파일 읽어오기
			// 설정파일의 인코딩정보 설정하기
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);

			Reader rd = Resources.getResourceAsReader("mybatis-config.xml");

			// 1-2.위에서 읽어온 Reader객체를 이용하여 SqlSessionFactory객체 생성하기
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);

			rd.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		/////////////////////////////////////////

		// 2. 실행할 SQL문에 맞는 쿼리문을 호출하여 원하는 작업을 수행한다.

		// 2-1. insert연습
		System.out.println("insert 작업시작...");

		// 1) 저장할 데이터를 VO에 담는다.
		MemberVO mv = new MemberVO();
		mv.setMemId("d001");
		mv.setMemName("강감찬");
		mv.setMemTel("010-1111-1111");
		mv.setMemAddr("경남진주시");

		// 2) SqlSession 객체를 이용하여 해당 쿼리문을 실행한다.
//		SqlSession sqlSession = sqlSessionFactory.openSession(); // 새로운 세션 열기

//		try {
//			
//			//memberTest(=네임스페이스).insertMember(=해당쿼리아이디)
//			int cnt = sqlSession.insert("memberTest.insertMember", mv);
//
//			if (cnt > 0) {
//				System.out.println("insert작업성공");
//			} else {
//				System.out.println("insert작업실패");
//			}
//
//			sqlSession.commit(); // 커밋
//
//		} catch (PersistenceException e) {
//
//			sqlSession.rollback(); // 예외가 발생했다면 롤백시키기
//			throw new RuntimeException("데이터 등록중 예외발생", e);
//
//		} finally {
//			sqlSession.close(); // 세션종료
//		}

		System.out.println("---------------------");

		
		//2-2. update작업 연습
		System.out.println("update 작업시작..");
		
		mv = new MemberVO();
		mv.setMemId("d001");
		mv.setMemName("김서빈");
		mv.setMemTel("010-1111-1111");
		mv.setMemAddr("대전");
		
		
		//세션열기
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			int cnt = sqlSession.update("memberTest.updateMember", mv);
			
			if (cnt > 0) {
				System.out.println("update작업성공");
			} else {
				System.out.println("update작업실패");
			}
			
			sqlSession.commit(); //커밋
			
			
		} catch (PersistenceException e) {
			sqlSession.rollback();
			
			throw new RuntimeException("수정중 예외발생!!", e);
			
		}finally {
			sqlSession.close(); //세션 닫기
		}
		
		
		
	}
}
