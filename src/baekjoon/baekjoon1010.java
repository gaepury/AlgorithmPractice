package baekjoon;

import java.util.Scanner;

public class baekjoon1010 {
	public static double[] result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T;
		int N, M;
		T = s.nextInt();

		result = new double[T];
		for (int i = 0; i < T; i++) {
			while (true) {
				try {
					N = s.nextInt();
					M = s.nextInt();
					if(N>M || N<=0 || N>=30 || M<=0 || M>=30){
						throw new Exception();
					}else{
						break;
					}
				} catch (Exception e) {
					System.out.println("N<=M");
					// TODO: handle exception
				}
			}

			result[i]=solution(N,M);
		}
		
		print(result);
	}

	public static double solution(int N, int M) {
		
		double result = factorial(M)/(factorial(N)*factorial(M-N));
		
		return result;
	}
	public static double factorial(long n){
		if(n==0)
			return 1;
		else if(n==1)
			return 1;
		else{
			return (double)n*factorial(n-1);
		}
	}
	
	public static void print(double[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.println(Math.round(result[i]));
		}
	}
}
