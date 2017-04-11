package baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

//1로 만들기 . 최소 횟수
public class Baekjoon1463Solution {
	static int[] Dp = new int[1000001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N;
		while (true) {
			try {
				N = Integer.parseInt(s.nextLine().trim());
				if (1 <= N && N <= 1000000)
					break;
				else {
					throw new Exception();
				}

			} catch (Exception e) {
				System.out.println("Error");
				continue;
			}
		}

		for (int i = 2; i <= N; i++) {
			Dp[i] = Dp[i - 1] + 1;

			if (i % 2 == 0)
				Dp[i] = Dp[i] >= Dp[i / 2] + 1 ? Dp[i / 2] + 1 : Dp[i];
			if (i % 3 == 0)
				Dp[i] = Dp[i] >= Dp[i / 3] + 1 ? Dp[i / 3] + 1 : Dp[i];
		}

		System.out.println(Dp[N]);

	}

}
