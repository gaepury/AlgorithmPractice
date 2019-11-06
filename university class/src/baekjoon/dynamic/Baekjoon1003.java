package baekjoon.dynamic;

import java.util.Scanner;

//fibonacci 함수호출 횟수 구하기
public class Baekjoon1003 {
	private static int count1 = 0;
	private static int count2 = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int testCase = 0;
		try {
			while (true) {
				testCase = Integer.parseInt(s.nextLine().trim());
				if (testCase <= 0) {
					System.out.println("1이상의 숫자를 입력하세요");
				} else
					break;
			}
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요");
			
			// TODO: handle exception
		}

		for (int i = 0; i < testCase; i++) {
			int N = Integer.parseInt(s.nextLine().trim());
			fibonacci(N);
			System.out.println(count1 + " " + count2);
			count1 = 0;
			count2 = 0;
		}
		int a = 1;
		a = a();
//		System.out.println(a);
	}

	public static int fibonacci(int n) {
		if (n == 0) {
			count1++;
			return 0;
		} else if (n == 1) {
			count2++;
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static int a() {
		return 0;
	}
}
