package chapter13;

import chapter11.confirm.Member;

public class MemberBox {
	
	private Member value;

	public Member getValue() {
		return value;
	}

	public void setValue(Member value) {
		this.value = value;
	}

	public MemberBox(Member value) {
		this.value = value;
	}

}
