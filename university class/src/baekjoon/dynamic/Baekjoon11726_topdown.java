package baekjoon.dynamic;

import java.util.*;

//2×n 타일링 D[n]=2xN 직사각형을 채우는 방법의 수 
public class Baekjoon11726_topdown {
	static int[] d=new int[1001];
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try {
			int n=s.nextInt();
			
			if(n<1 || n>1000){
				new Exception();
			}else{
				int result=dp(n);
				System.out.println(result);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static int dp(int n){
		if(n<=1){
			return 1;
		}
		if(d[n]>0){
			return d[n];
		}
			d[n]=(dp(n-1)+dp(n-2))%10007;
		
		
		return d[n];
	}
}
