package assign;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class assign0926 {

	private Scanner scan;
	private Map<String, Customer> cutomerMap;

	public assign0926() {
		scan = new Scanner(System.in);
		cutomerMap = new HashMap<String, Customer>();
	}

	// 메뉴를 출력하는 메서드
	public void displayMenu() {
		System.out.println("**************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("메뉴선택 => ");
	}

	public void customerStart() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");

		while (true) {
			displayMenu(); // 메뉴 출력
			int menu = scan.nextInt(); // 메뉴 번호 입력

			switch (menu) {
			case 1:
				insert(); // 체크인 - 고객정보 입력
				break;
			case 2:
				delete(); // 체크아웃 - 고객정보 삭제
				break;
			case 3:
				displayAll(); // 객실상태 전체 출력
				break;
			case 4:
				System.out.println("감사합니다");
				return;

			}
		}

	}

	public static void main(String[] args) {
		new assign0926().customerStart();
	}

	/**
	 * 고객체크인정보 넣기
	 */
	private void insert() {
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.println("방번호 입력 => ");
		String room = scan.next();

		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 => ");
		String name = scan.next();

		// 이미 등록된 사람인지 체크하기
		if (cutomerMap.get(room) != null) {
			System.out.println(room + "방에는 이미 사람이 있습니다.");
			return; // 메서드 종료
		}

		System.out.println();
		Customer customer = new Customer(room, name);
		cutomerMap.put(room, customer);
		System.out.println("체크인 되었습니다.");
	}

	/**
	 * 체크아웃 고객정보 삭제
	 */
	private void delete() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.println("방번호 입력 => ");
		String room = scan.next();

		// remove(key) => 삭제 성공하면 삭제된 value값을 반환하고 실패하면 null을 리턴함
		if (cutomerMap.remove(room) == null) { // 비어있는 방일 경우
			System.out.println(room + "방에는 체크인한 사람이 없습니다.");
		} else {

			System.out.println(room + "방 체크아웃완료");
		}
	}

	/**
	 * 전체 고객정보 출력하는 메서드 (객실상태 전체 출력)
	 */
	private void displayAll() {
		Set<String> keySet = cutomerMap.keySet();
		if (keySet.size() == 0) {
			System.out.println("객실이 비어있습니다");
		} else {
			Iterator<String> iterator = keySet.iterator();
			while (iterator.hasNext()) {
				String name = iterator.next();
				Customer customer = cutomerMap.get(name);
				System.out.println("방번호 : " + customer.getRoom() + ", 투숙객 :" + customer.getName());
			}
		}

	}

}

/**
 * 
 * 방과 고객 정보를 저장하기 위한 VO클래스
 *
 */
class Customer {
	private String room;
	private String name;

	public Customer() {
	}

	public Customer(String room) {
		super();
		this.room = room;
	}

	public Customer(String room, String name) {
		super();
		this.room = room;
		this.name = name;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [room=");
		builder.append(room);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}