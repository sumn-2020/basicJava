package operator;

public class Exercise4 {
	public static void main(String[] args) {

		// 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄때
		// 1인당 몇개를 가질수 있고, 몇개가 남는지 구하시오

		int person = 534;
		int pencil = 30;

		int hasPencil = 534 / 30;
		int restPencil = 534 % 30;

		System.out.println("1인당 가질 수 있는 연필의 갯수는 " + hasPencil + "이고, 남는 연필의 갯수는 " + restPencil + "이다.");

	}
}
