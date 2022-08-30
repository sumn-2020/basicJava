package chapter08.intface;

public class Television implements RemoteControl, Searchable {// implements = 구현하다 / RemoteControl클래스를 teleision클래스가 구현하겠다

	private int volume;

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if (volume > MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		} else if (volume < MIN_VOLUME) {
			this.volume = MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨: " + this.volume);
	}

	@Override
	public void search(String word) {
		System.out.println(word + "를 검색한 결과입니다.");
		
	}

}
