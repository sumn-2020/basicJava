package memo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class MemoTest {
	

	void test() throws Exception {
		MemoDAO dao = new MemoDAO();
		List<MemoVO> list = dao.getMemos();
		assertEquals(0, list.size()); //assertEquals(예측한 데이터, 실제데이터)가 일치하면 성공, 아니면 실패
		//assertNotNull(list);
	}
	

//	void serviceTest() throws Exception {
//		MemoService service = new MemoService();
//		List<MemoVO> list = service.getMomos();
//		assertEquals(0, list.size());
//	}
	
	
	
	@Test
	void insertTest() throws Exception {
		MemoDAO dao = new MemoDAO();
		dao.insertMemo(new MemoVO(0, "두번째 메모", "안녕하세요", "sem", null, null));
		List<MemoVO> list = dao.getMemos();
		assertEquals(9, list.size()); //assertEquals(예측한 데이터, 실제데이터)가 일치하면 성공, 아니면 실패
	}
	
	//둘다 성공해야 성공! 
}
