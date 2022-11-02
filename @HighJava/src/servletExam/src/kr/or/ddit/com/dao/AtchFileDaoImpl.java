package kr.or.ddit.com.dao;

import java.util.List;

import kr.or.ddit.com.vo.AtchFileVO;

public class AtchFileDaoImpl  extends MyBatisDao implements IAtchFileDao {

	private static IAtchFileDao atchFileDao;
	
	private AtchFileDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static IAtchFileDao getInstance() {
		if(atchFileDao == null) {
			atchFileDao = new AtchFileDaoImpl();
		}
		return atchFileDao;
	}
	
	
	
	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) {
		return insert("atchFile.insertAtchFile", atchFileVO);
	}

	@Override
	public int insertAtchFileDetail(AtchFileVO atchFileVO) {
		return insert("atchFile.insertAtchFileDetail", atchFileVO);
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) {
		return selectList("atchFile.getAtchFileList", atchFileVO);
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {
		return selectOne("atchFile.getAtchFileDetail", atchFileVO);
	}

}
