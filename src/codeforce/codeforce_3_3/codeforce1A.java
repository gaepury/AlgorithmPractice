package codeforce.codeforce_3_3;
import java.util.Scanner;


//3.3 Theatre Square
public class codeforce1A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, m, a;
		int row=0;
		int col=0;
		try {
			n = s.nextInt();
			m = s.nextInt();
			a = s.nextInt();

			if (n <= 0 || n > 1000000000 || m <= 0 || m > 1000000000 || a <= 0 || a > 1000000000) {
				throw new Exception();
			} else {
				if (n > a) {
					row = n % a == 0 ? n / a : (n / a) + 1;
				} else {
					row = 1;
				}
				if (m > a) {
					col = m % a == 0 ? m / a : (m / a) + 1;
				} else {
					col = 1;
				}
				
				long result = (long)row * (long)col;
				System.out.println(result);

			}
		} catch (Exception e) {
			System.out.println("n,m,a check");
			// TODO: handle exception
		}

	}

}
