package exercise20220831.exercise3;

public class Poet extends Book{
	
	public Poet(String title, String autor) {
		super(title, autor);
	}
	
	@Override
	public int getLateFee(int lateDays) {
		//하루연체될 때마다 200원
		return  200;
	}
}
