package operator;

public class Exercise6 {
	public static void main(String[] args) {

		// 사다리꼴 넓이는 구하시오.
		// 정확히 소수 자릿수가 나올 수 있도록 하시오.
		// (윗변 + 아랫변) × 높이 ÷ 2

		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;

		double result = (lengthTop + lengthBottom) * height / 2.0; // 소수 자릿수가 나와야 한다고 했으니까 소수 자리로 나눈 수를 double타입에 담아줘야 함
		System.out.println(result);

	}
}
