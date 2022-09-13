package memo;

import java.util.List;

public class MemoController {

	public List<MemoVO> getMemos() throws Exception {
		MemoService service = new MemoService();
		return service.getMomos();
	}
	
}
