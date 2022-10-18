package kr.or.ddit.Board.com.dao;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisUtil;

public class MyBatisDao {

	// sql문에서 select 실행 후, db정보를 뽑아올때 selectOne, selectList를 이용하여 반환값을 하나만 뽑아올 것인지,
	// List로 뽑아올 것인지 정하기
	// selectOne : id에 대한 select문을 실행한 후 한개의 레코드를 지정한 타입으로 반환
	// selectList : id에 대한 select문을 실행한 후 레코드를 List로 반환

	// 반환값 걍 하나
	public <T> T selectOne(String statement, Object parameter) {

		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		T obj = null;

		try {

			obj = sqlSession.selectOne(statement, parameter);

		} catch (PersistenceException e) {

			throw new RuntimeException("데이터 조회중 예외발생", e);

		} finally {
			sqlSession.close();
		}

		return obj;

	}

	// 반환값이 List
	public <T> List<T> selectList(String statement, Object parameter) {

		List<T> list = Collections.emptyList();

		SqlSession sqlSession = MyBatisUtil.getSqlSession();

		try {

			if (parameter == null) {
				list = sqlSession.selectList(statement);
			} else {
				list = sqlSession.selectList(statement, parameter);
			}

		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회중 예외발생", e);
		} finally {
			sqlSession.close();
		}

		return list;

	}

	/**
	 * insert
	 */
	public int insert(String statement, Object parameter) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();

		int cnt = 0;

		try {

			cnt = sqlSession.insert(statement, parameter);

			sqlSession.commit();

		} catch (PersistenceException e) {
			sqlSession.rollback();
			throw new RuntimeException("데이터 등록중 예외발생", e);
		} finally {
			sqlSession.close();
		}

		return cnt;
	}

	/**
	 * update
	 */
	public int update(String statement, Object parameter) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();

		int cnt = 0;

		try {
			cnt = sqlSession.update(statement, parameter);
			sqlSession.commit();
		} catch (PersistenceException e) {

			sqlSession.rollback();
			throw new RuntimeException("데이터 수정중 예외발생", e);
		}finally {
			sqlSession.close();
		}
		
		return cnt; 
	}
	
	/**
	 * delete
	 */
	public int delete(String statement, Object parameter) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = sqlSession.delete(statement, parameter);
			sqlSession.commit();
		} catch (PersistenceException e) {
			sqlSession.rollback();
			throw new RuntimeException("데이터 삭제중 예외발생", e);
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	

}
