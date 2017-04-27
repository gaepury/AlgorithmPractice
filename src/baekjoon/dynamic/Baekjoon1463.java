package baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

//1로 만들기 . 최소 횟수 D[n]=N을 1로 만드는 데 필요한 연산의 최소값 
public class Baekjoon1463 {

	static int[] d = new int[1000001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N;
		int result=0;
		
		try {
			N = s.nextInt();
			if (N < 1 || N > 1000000) {
				new Exception();
			} else {
				result=dp(N);
				System.out.println(result);
			}

		} catch (Exception e) {
			System.out.println("error");
			// TODO: handle exception
		}
	}

	public static int dp(int N) {
		if (N == 1) {
			return 0;
		}
		if(d[N]>0){
			return d[N];
		}
		d[N] = dp(N - 1)+1;
		if(N%2==0 && d[N]>d[N/2]+1){
			d[N]=d[N/2]+1;
		}
		if(N%3==0 && d[N]>d[N/3]+1){
			d[N]=d[N/3]+1;
		}
		
		return d[N];
	}
}
