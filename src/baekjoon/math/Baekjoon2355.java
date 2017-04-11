package baekjoon.math;

import java.util.Scanner;
//½Ã±×¸¶
public class Baekjoon2355 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j;
		
		Scanner s=new Scanner(System.in);
		
		i=s.nextInt();
		j=Integer.parseInt(s.nextLine().trim());
		int sum=0;
		for(int k=i;k<=j;k++){
			sum+=k;
		}
		System.out.println(sum);
	}

}
