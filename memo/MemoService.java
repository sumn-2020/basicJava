package memo;

import java.util.List;

public class MemoService {
	MemoDAO dao = new MemoDAO();

	// MemoDAO 불러오기
	public List<MemoVO> getMomos() throws Exception {
		MemoDAO dao = new MemoDAO();
		return dao.getMemos();
	}
	
	//목록 하나만 뜨게 
	public MemoVO getMemo(int searchNo) throws Exception {
		return dao.getMemo(searchNo);
	}


	// 등록
	public int insertMemo(MemoVO vo) throws Exception {
		return dao.insertMemo(vo);
	}

	// 업데이트
	public int updateMemo(MemoVO vo) throws Exception {
		return dao.updateMemo(vo);
	}

	// 삭제
	public int deleteMemo(int deleteNo) throws Exception {
		return dao.deleteMemo(deleteNo);
	}

}
