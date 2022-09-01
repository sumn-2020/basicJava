package exercise20220831.exercise3;

public class ScienceFiction extends Book {
	public ScienceFiction(String title, String autor) {
		super(title, autor);
	}

	@Override
	public int getLateFee(int lateDays) {
		//하루연체될 때마다 600원
		return lateDays * 600;
	}
}
