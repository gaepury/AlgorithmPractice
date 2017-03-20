package codeforce;

import java.util.Arrays;
import java.util.Scanner;

public class codeforce492B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);

		int n,l;
		int[] lanterns;
		
		
		try {
			n=s.nextInt();
			l=s.nextInt();
			
			if(n<1 || n>1000 || l<1 || l>1000000000){
				new Exception();
			}else{
				
				lanterns=new int[n+2];
				lanterns[0]=0;
				lanterns[n+1]=l;
				
				lanternsInput(s, lanterns);
				
				Arrays.sort(lanterns);
				
				double d=lanterns[1]-lanterns[0];
				double dout=lanterns[n+1]-lanterns[n];
				
				d = calRadius(lanterns, d, dout);
				
				
				System.out.println(d);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
				
	}

	public static double calRadius(int[] lanterns, double d, double dout) {
		
		double temp;
		for (int i = 1; i < lanterns.length-1; i++) {
			temp=(lanterns[i+1]-lanterns[i])/2.0;
			if(d<temp)
				d=temp;
		}
		if(d<dout){
			d=dout;
		}
		return d;
	}

	public static void lanternsInput(Scanner s, int[] lanterns) {
		for (int i = 1; i < lanterns.length-1; i++) {
			lanterns[i]=s.nextInt();
		}
	}

}
