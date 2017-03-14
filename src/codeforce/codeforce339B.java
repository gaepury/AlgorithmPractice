package codeforce;

import java.util.Arrays;
import java.util.Scanner;

public class codeforce339B {
	public static int n;
	public static int m;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int[] workorder;

		int result ;
		try {
			n = s.nextInt();
			m = s.nextInt();
			workorder = new int[m + 1];
			if (n < 2 || n > 100000 || m < 1 || m > 100000) {
				throw new Exception();
			} else {
				workorder[0] = 1;
				for (int i = 1; i < workorder.length; i++) {
					workorder[i] = Integer.parseInt(s.next());
				}
				result = Ringroad(workorder);
				print(result);
			}
		} catch (Exception e) {
			System.out.println("error");
			// TODO: handle exception
		}

	}

	public static int Ringroad(int[] workorder) {
		int sum = 0;

		for (int i = 0; i < workorder.length - 1; i++) {
			if (workorder[i] > workorder[i + 1]) {
				sum += n - (workorder[i] - workorder[i + 1]);
			} else {
				sum += workorder[i + 1] - workorder[i];
			}
		}
		return sum;
	}
	public static void print(int result){
		System.out.println(result);
	}
}
