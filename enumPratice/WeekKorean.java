package enumPratice;

public enum WeekKorean {
	
	//Calendar.DAY_OF_WEEK에 담긴 요일 정보는 1~7까지로 저장되어있음 
	MONDAY(2, "월요일"), //Calendar.DAY_OF_WEEK정보가 2일땐 "월요일"
	TUESDAY(3,"화요일"), //3일땐 "화요일"
	WEDENSDAY(4, "수요일"),
	THURSDAY(5, "목요일"),
	FRIDAY(6,"금요일"),
	SATURDAY(7, "토요일"),
	SUNDAY(1, "일요일");
	
	WeekKorean(int code, String koreanName) { //
		this.code = code;
		this.koreanName = koreanName;
	}
	
	int code;
	String koreanName;
	
	
	
}
