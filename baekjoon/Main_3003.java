
import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] array = { 1, 1, 2, 2, 2, 8 };

		int[] result = new int[6];
		for (int i = 0; i < 6; i++) {
			result[i] = scanner.nextInt();
		}

		for (int i = 0; i < 6; i++) {
			System.out.print(array[i] - result[i] + " ");
		}

	}
}
