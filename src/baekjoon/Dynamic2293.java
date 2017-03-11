package baekjoon;

import java.util.Scanner;
//동전1 , 입력받은 동전으로 합해서 k를 만들수 있는 경우의 수 구하기
public class Dynamic2293 {
	static int[] coin;
	static int[] Dp;
	static int n, k;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		while (true) {
			try {
				String str = s.nextLine().trim();
				n = Integer.parseInt(str.substring(0, str.indexOf(" ")));
				k = Integer.parseInt(str.substring(str.indexOf(" ") + 1));

				if (1 <= n && n <= 100 && 1 <= k && k <= 10000)
					break;
				else
					throw new Exception();
			} catch (Exception e) {
				System.out.println("Error");
				continue;
				// TODO: handle exception
			}
		}
		Dp = new int[k + 1];
		coin = new int[n];
		for (int i = 0; i < coin.length; i++) {
			coin[i] = Integer.parseInt(s.nextLine().trim());
		}
		System.out.println(dp(k));

	}

	public static int dp(int k) {
		int count = 0;
		if (k < 0)
			return 0;
		if (k == 0)
			return 1;
		for (int i = 0; i < coin.length; i++) {
			count += dp(k - coin[i]);
		}
		return count;

	}

}
