
import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int H = scanner.nextInt();
		int M = scanner.nextInt();

		if (H == 0) {
			if (M < 45) {
				H = 23;
				M = M + 15;
			} else if (M > 45) {
				H = 0;
				M = M - 45;
			}
		} else {
			if (M < 45) {
				H = H - 1;
				M = M + 15;
			}else {
				M = M - 45;
			}
		}

		System.out.print(H + " " + M);

	}
}
