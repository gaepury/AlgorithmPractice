package codeground;
import java.util.Arrays;
import java.util.Scanner;

public class Problem21 {
	static int[] x;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T;
		while (true) {
			try {
				T = Integer.parseInt(s.nextLine().trim());
				if (T < 1 || T > 200) {
					throw new Exception();
				}else
					break;
			} catch (Exception e) {
				System.out.println("error");
				// TODO: handle exception
			}
		}
		System.out.println("a");
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(s.nextLine().trim());
			int r = Integer.parseInt(s.nextLine().trim());
			int L = Integer.parseInt(s.nextLine().trim());
			x = new int[N];
			for (int j = 0; j < N; j++) {

				if (!(j == (N - 1))) {
					x[j] = s.nextInt();
				} else {
					x[j] = Integer.parseInt(s.nextLine().trim());
				}
			}

		}
		

	}

}
