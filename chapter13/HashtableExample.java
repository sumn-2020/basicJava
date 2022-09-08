package chapter13;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashtableExample {
	public static void main(String[] args) {
		
		Map<Object, Object> map = new Hashtable<>();
		
		//아이디와 비밀번호를 미리 저장 
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("아이디와 비밀번호를 입력해주세요.");
			System.out.println("아이디 : ");
			String id = scanner.nextLine(); //키보드로 입력한 아이디를 받음
			System.out.println("비밀번호 :");
			String password = scanner.nextLine();
			System.out.println();
			
			if(map.containsKey(id)) { //아이디인 키가 존재하는지 확인
				if(map.get(id).equals(password)) { //비밀번호를 비교
					System.out.println("로그인되었습니다.");
					break;
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}else {
				System.out.println("입력하신 아이디가 존재하지 않습니다.");
			}
		}
		
		
	}
}
