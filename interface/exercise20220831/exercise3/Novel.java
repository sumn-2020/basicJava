package exercise20220831.exercise3;

public class Novel extends Book {
	public Novel(String title, String autor) {
		super(title, autor);
	}

	@Override
	public int getLateFee(int lateDays) {
		return 300;
		// 하루연체될 때마다 300원
	}
}
