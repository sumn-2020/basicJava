package chapter08.confirm;

public class MySqlDao implements DataAccessObject {

	@Override
	public void select() {
		System.out.println("MySql DB에서 검색");

	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("MySql DB에서 삽입");

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("MySql DB에서 수정");

	}

	@Override
	public void delete() {
		System.out.println("MySql DB에서 삭제");
		// TODO Auto-generated method stub

	}

}
