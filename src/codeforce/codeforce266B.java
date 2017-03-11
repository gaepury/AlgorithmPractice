package codeforce;
import java.util.Scanner;

public class codeforce266B {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int N, T;
		String str=null;
		try {
			N = s.nextInt();
			T = s.nextInt();
			if (N > 50 || N <= 0 || T > 50 || T <= 0)
				throw new Exception();
			else {
				str = s.next();
				while (true) {
					if (str.length() != N){
						System.out.println("N length input!");
						continue;
					}
					else
						break;
				}
				
				for (int i = 0; i < T; i++) {
					str=change(str);
				}
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println("N,T는 1이상, 50이하");
			// TODO: handle exception
		}
	}

	public static String change(String s) {
		return s.replaceAll("BG", "GB");
	}
}
