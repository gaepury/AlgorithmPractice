package baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon10942Solution {

	static int[] number = new int[2001];
	
	static boolean[][] result = new boolean[2001][2001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);

		int N = Integer.parseInt(s.nextLine());
		
		for (int i = 1; i <= N; i++) {
			if (!(i == N))
				number[i] = s.nextInt();
			else
				number[i] = Integer.parseInt(s.nextLine().trim());
		}

		int M = Integer.parseInt(s.nextLine());

		for (int i = 1  ; i <= N; i++) {
			result[i][i] = true;
			if (i + 1 <= N) {
				if (number[i] == number[i + 1])
					result[i][i + 1] = true;
			}
		}
		for (int k = 3; k <= N; k++) {
			for (int i = 1; i <= N - k + 1; i++) {
				int j = i + k - 1;
				if (number[i] == number[j] && result[i + 1][j - 1]) {
					result[i][j] = true;
				}
			}
		}
		
		
		for (int i = 0; i < M; i++) {
			int start = s.nextInt();
			int end = Integer.parseInt(s.nextLine().trim());
			System.out.println(result[start][end]==true? 1:0);
		}
	}
}