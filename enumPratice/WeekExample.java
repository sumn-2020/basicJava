package enumPratice;

import java.util.Calendar;

public class WeekExample {
	public static void main(String[] args) {
		
		
		
		Calendar calendar = Calendar.getInstance();//오늘의 날짜를 이용하기 위해서 Calendar.getInstance 가져온다. (날짜 및 시간을 가져오는 클래스-Date,Calendar)
		int week = calendar.get(Calendar.DAY_OF_WEEK); //Calendar라는 클래스에서 해당 요일에 대한 정보를 가져와라
		Week today = null; //enum으로 만들어진 today라는 변수 생성 
		
		switch(week) {
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUESDAY;
			break;
		case 4: 
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}
		
		
		System.out.println(today);
		
		
		
		
		
	}
}
