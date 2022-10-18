package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.member.vo.MemberVO;

public class MyBatisTest {
	public static void main(String[] args) {

		// MyBatis를 이용하여 DB데이터를 처리하는 작업순서
		// SqlSessionFactory : sql을 찍어내는 객체
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

		// 2-2. update작업 연습
		System.out.println("update 작업시작..");

		mv = new MemberVO();
		mv.setMemId("d001");
		mv.setMemName("김서빈");
		mv.setMemTel("010-1111-1111");
		mv.setMemAddr("대전");

		// 세션열기
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {

			int cnt = sqlSession.update("memberTest.updateMember", mv);

			if (cnt > 0) {
				System.out.println("update작업성공");
			} else {
				System.out.println("update작업실패");
			}

			sqlSession.commit(); // 커밋

		} catch (PersistenceException e) {
			sqlSession.rollback();

			throw new RuntimeException("수정중 예외발생!!", e);

		} finally {
			sqlSession.close(); // 세션 닫기
		}

		// 2-3. delete 연습
		System.out.println("delete 작업시작...");

		sqlSession = sqlSessionFactory.openSession(); // 세션 열고 필요한 작업하기

		try {

			// delete 메서드의 반환값 : 성공한 레코드 수
			int cnt = sqlSession.delete("memberTest.deleteMember", "d001");

			if (cnt > 0) {
				System.out.println("delete 작업성공");
				sqlSession.commit();
			} else {
				System.out.println("delete 작업실패");
			}

		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException("삭제 중 예외발생!", e);
		} finally {
			sqlSession.close(); // 세션 닫기
		}

		// 2-4. select 연습
		// 1) 응답의 결과가 어러개일 경우 (LIst로 받고 싶을 경우)
		System.out.println("select연습(결과가 여러개인경우)...");

		sqlSession = sqlSessionFactory.openSession();

		List<MemberVO> memList = new ArrayList<MemberVO>();

		// 응답결과가 여러개인 경우에는 selectList메서드를 사용한다.
		try {

			memList = sqlSession.selectList("memberTest.selectAllMember");

			if (memList.size() == 0) {
				System.out.println("조회된 정보가 없습니다.");
			} else {
				for (MemberVO mv3 : memList) {
					System.out.println("ID : " + mv3.getMemId());
					System.out.println("이름 : " + mv3.getMemName());
					System.out.println("전화번호 : " + mv3.getMemTel());
					System.out.println("주소 : " + mv3.getMemAddr());
					System.out.println("---------------------");
				}

				System.out.println("출력 끝...");
			}

		} finally {
			sqlSession.close();
		}

		// 2) 응답결과가 1개일 경우..
		System.out.println("select 연습(결과가 1개인 경우)...");

		sqlSession = sqlSessionFactory.openSession();

		// 응답결과가 1개일 경우에는 selectOne() 메서드를 사용한다.
		try {

			MemberVO mv4 = (MemberVO) sqlSession.selectOne("memberTest.selectMember", "a001");

			System.out.println("ID : " + mv4.getMemId());
			System.out.println("이름 : " + mv4.getMemName());
			System.out.println("전화번호 : " + mv4.getMemTel());
			System.out.println("주소 : " + mv4.getMemAddr());
			System.out.println("---------------------");

		} finally {
			sqlSession.close();

		}

	}
}
