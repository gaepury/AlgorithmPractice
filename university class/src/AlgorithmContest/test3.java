package AlgorithmContest;

import java.util.Arrays;
import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int m=s.nextInt();
		int[][] a=new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j]=1;
			}
		}
		System.out.println(Arrays.deepToString(a));
	}

}
