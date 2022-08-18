package enumPratice;

import java.util.Calendar;

public class WeekKoreanExample {
	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		int week = calendar.get(Calendar.DAY_OF_WEEK); // 불러온 요일을 담을 변수 : week
		WeekKorean today = null; // enum에서 정보를 가져와서 담을 변수 : today

		switch (week) {
		case 1:
			today = WeekKorean.SUNDAY;
			break;
		case 2:
			today = WeekKorean.MONDAY;
			break;
		case 3:
			today = WeekKorean.WEDENSDAY;
			break;
		case 4:
			today = WeekKorean.THURSDAY;
			break;
		case 5:
			today = WeekKorean.FRIDAY;
			break;
		case 6:
			today = WeekKorean.SATURDAY;
			break;
		}
		
		System.out.println(today.koreanName); //WeekKorean(int code, String koreanName)중에서 koreanname사용하여 출력

	}
}
