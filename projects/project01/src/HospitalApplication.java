

import java.util.Scanner;

public class HospitalApplication {
	public static void main(String[] args) {
		
		//view 불러오기 
		HospitalView view = HospitalView.getInstance();
		
		Scanner scanner = new Scanner(System.in);
		
		view.init();
		int menu = Integer.parseInt(scanner.nextLine()); 
		
		
		
	}
}
