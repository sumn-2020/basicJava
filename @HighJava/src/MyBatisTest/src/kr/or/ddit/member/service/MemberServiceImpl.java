package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.dao.MemberDaoImplForJDBC;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	// 데이터베이스 관련된 작업은 Dao에게 위임
	// 나머지 비즈니스로직은 service본인이 함
	private IMemberDao memDao;

	
	//싱글톤으로 변경하기
	private static IMemberService memService;
	private MemberServiceImpl() {
		//memDao = new MemberDaoImpl();
		//memDao = MemberDaoImplForJDBC.getIntance();
		memDao = MemberDaoImpl.getInstance();
	}
	public static IMemberService getInstance() {
		if(memService == null) {
			memService = new MemberServiceImpl();
		}
		return memService;
	}
	
	
	

	@Override
	public int registMember(MemberVO mv) {

		// 야! Dao야! insert 좀 해줘!
		int cnt = memDao.insertMember(mv);
		
		
		/*
		if(cnt > 0) {
			//메일 발송 기능 호출
		}
		*/

		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {

		boolean exist = memDao.checkMember(memId);

		return exist;
	}

	@Override
	public int modifyMember(MemberVO mv) {

		int cnt = memDao.updateMember(mv);

		return cnt;
	}

	@Override
	public int removeMember(String memId) {

		int cnt = memDao.deleteMember(memId);

		return cnt;
	}

	@Override
	public List<MemberVO> selectAllMember() {

		List<MemberVO> memList = memDao.selectAllMember();

		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		
		List<MemberVO> memList = memDao.searchMember(mv);
		
		return memList;
	}
	
	

}
