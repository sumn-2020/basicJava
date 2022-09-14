package memo;

import java.util.List;

public class MemoController {
	MemoService service = new MemoService();

	public List<MemoVO> getMemos() throws Exception {
		MemoService service = new MemoService();
		return service.getMomos();
	}
	
	public MemoVO getMemo(int searchNo) throws Exception {
		return service.getMemo(searchNo);
	}
	

	// 등록
	public int insertMemo(MemoVO vo) throws Exception {
		return service.insertMemo(vo);
	}

	// 업데이트
	public int updateMemo(MemoVO vo) throws Exception {
		return service.updateMemo(vo);
	}

	// 삭제
	public int deleteMemo(int deleteNo) throws Exception {
		return service.deleteMemo(deleteNo);
	}

}
