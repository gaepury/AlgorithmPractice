package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//1로 만들기 . 최소 횟수
public class Dynamic1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N;
		while (true) {
			try {
				N = Integer.parseInt(s.nextLine());
				if (1 <= N && N < 1000000)
					break;
				else {
					throw new Exception();
				}

			} catch (Exception e) {
				System.out.println("Error");
				continue;
			}
		}

		System.out.println(dp(N));
	}

	public static int dp(int N) {
		int count = 0;
		int[] countArr = new int[2];
		if (N == 1) {
			return 0;
		} else {
			count = countArr[0] = dp(N - 1) + 1;
			if (N % 3 == 0) {
				countArr[1] = dp(N / 3) + 1;
				count = countArr[0] >= countArr[1] ? countArr[1] : countArr[0];
			}
			if (N % 2 == 0) {
				countArr[1] = dp(N / 2) + 1;
				count = countArr[0] >= countArr[1] ? countArr[1] : countArr[0];
			}
			return count;
		}

	}
}
