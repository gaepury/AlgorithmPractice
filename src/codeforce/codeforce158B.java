package codeforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class codeforce158B {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;
		int taxinum = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		try {
			n = s.nextInt();
			if (n < 1 || n > 100000) {
				throw new Exception();
			} else {
				int[] si = new int[n];
				//si 입력
				inputSi(s, si);
				//si sort
				Arrays.sort(si);

				for (int i = 0; i < si.length; i++) {
					switch (si[i]) {
					case 1:
						count1++;
						break;
					case 2:
						count2++;
						break;
					case 3:
						count3++;
						break;
					case 4:
						count4++;
						break;
					}
				}
				//택시 계산
				taxinum = calTaxinum(taxinum, count1, count2, count3, count4);
				//출력
				print(taxinum);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void print(int taxinum) {
		System.out.println(taxinum);
		System.out.println();
	}

	public static void inputSi(Scanner s, int[] si) {
		for (int i = 0; i < si.length; i++) {
			si[i] = s.nextInt();
		}
	}

	public static int calTaxinum(int taxinum, int count1, int count2, int count3, int count4) {
		taxinum += count4;
		if (count1 > count3) {
			taxinum += count3;
			count1 -= count3;
		} else {
			taxinum += count3;
			count1 = 0;
		}
		if ((count2 * 2 + count1) % 4 == 0) {
			taxinum += (count2 * 2 + count1) / 4;
		} else {
			taxinum += ((count2 * 2 + count1) / 4) + 1;
		}
		return taxinum;
	}
}
