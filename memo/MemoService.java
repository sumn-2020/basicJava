package memo;

import java.util.List;

public class MemoService {
	//MemoDAO 불러오기
	public List<MemoVO> getMomos() throws Exception {
		MemoDAO dao = new MemoDAO();
		return dao.getMemos();
	}
}
