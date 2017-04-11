package baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;
//ÆÓ¸°µå·Ò?
public class Baekjoon10942 {
	static int N;
	static int[] number = new int[2001];
	static int M;
	static int[] S = new int[1000001];
	static int[] E = new int[1000001];
	static int[] result = new int[1000001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);

		N = Integer.parseInt(s.nextLine());

		for (int i = 1; i <= N; i++) {
			if (!(i == N))
				number[i] = s.nextInt();
			else
				number[i] = Integer.parseInt(s.nextLine().trim());
		}
		System.out.println(Arrays.toString(number));
		M = Integer.parseInt(s.nextLine());

		for (int i = 0; i < M; i++) {
			S[i] = s.nextInt();
			E[i] = Integer.parseInt(s.nextLine().trim());
			System.out.println(dp(S[i], E[i])==true? 1:0);
		}

	}

	public static boolean dp(int n1, int n2) {
		boolean flag = false;
		
		int temp = (int) ((n1 + n2) / 2.0);

		for (int i = 0; i <= temp - n1; i++) {
			flag = number[n1 + i] == number[n2 - i] ? true : false;
			if (!(flag == false))
				return flag;
		}
		return flag;
	}
}