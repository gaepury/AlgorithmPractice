package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Math1902Solution {
	static int[] num=new int[100001];
	static int[] d=new int[100001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;

		Scanner s = new Scanner(System.in);

		n = Integer.parseInt(s.nextLine().trim());

		for (int i = 1; i <= n; i++) {
			if (!(i == n))
				num[i] = s.nextInt();
			else
				num[i] = Integer.parseInt(s.nextLine().trim());
		}
		
		d[1]=num[1];
		
		for(int i=2;i<=n;i++){
			d[i]=Math.max(num[i], num[i]+d[i-1]);
		}
		
		int max=d[1];
		
		for(int i=2;i<=n;i++){
			max=Math.max(max, d[i]);
		}
		System.out.println(max);

	}

}
