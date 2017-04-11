package 알고리즘경연대회;

import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		
		char[] str=new char[100];
		char c='a';
		int count=0;
		System.out.println("Enter a String");
		str = s.nextLine().toCharArray();
		
		for (int i = 0; i < str.length; i++) {
			if(str[i]==c){
				count++;
			}
		}
		System.out.println(count);
		
		
		
	}

}
