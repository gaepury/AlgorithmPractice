package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon3020_version3 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		long length = scanner.nextLong(); // N
		long height = scanner.nextLong(); // H

		ArrayList arrayLow = new ArrayList();
		ArrayList arrayHigh = new ArrayList();

		long temp = 0;

		// 배열에 넣고
		for (long i = 0; i < length / 2; i++) {
			arrayLow.add(scanner.nextLong());
			arrayHigh.add(scanner.nextLong());
		}

		// 소팅
		arrayLow.sort(null);
		arrayHigh.sort(null);

		long low = 0;
		long high = arrayLow.size() - 1;
		long middle = 0;

		long lowNumber = 0;
		long highNumber = 0;

		long min = Long.MAX_VALUE;
		long count = 0;

		for (long i = 1; i < height + 1; i++) {
			if ((long) arrayLow.get((int) high) < i) {
				lowNumber = 0;
			} else if ((long) arrayLow.get(0) >= i) {
				lowNumber = high + 1;
			} else {
				while (low <= high) {
					System.out.println("low:"+low+" high:"+high);
					middle = (low + high) / 2;
					if (i > (long) arrayLow.get((int) middle)) {
						System.out.println("i:"+i +" arrayLow.get((int)middle):"+arrayLow.get((int)middle));
						low = middle + 1;
						System.out.println("m:"+middle);
					} else if (i < (long) arrayLow.get((int) middle)) {
						System.out.println("i:"+i +" arrayLow.get((int)middle):"+arrayLow.get((int)middle));
						high = middle - 1;
						System.out.println("m:"+middle);
					} else {
						System.out.println("i:"+i +" arrayLow.get((int)middle):"+arrayLow.get((int)middle));
						
						if (low != high) {
							high = middle;
							System.out.println("m:"+middle);
						} else {
							System.out.println("m:"+middle);
							break;
						}
					}
					
				}
				if (i > (long) arrayLow.get((int) middle)) {
					middle = high + 1;
				}
				lowNumber = (arrayLow.size() - 1) - middle + 1;
			}
			System.out.println(lowNumber);
			
			high = arrayHigh.size() - 1;
			low = 0;

			if ((long) arrayHigh.get((int) high) < height - i + 1) {
				highNumber = 0;
			} else if (height - i + 1 <= (long) arrayHigh.get(0)) {
				highNumber = high + 1;
			} else {
				while (low <= high) {
					middle = (low + high) / 2;

					if (height - i + 1 > (long) arrayHigh.get((int) middle)) {
						low = middle + 1;
					} else if (height - i + 1 < (long) arrayHigh.get((int) middle)) {
						high = middle - 1;
					} else {
						if (low != high) {
							high = middle;
						} else {
							break;
						}
					}
				}

				if (height - i + 1 > (long) arrayHigh.get((int) middle)) {
					middle = high + 1;
				}
				highNumber = (arrayHigh.size() - 1) - middle + 1;
			}

			System.out.println(highNumber);
			
			high = arrayLow.size() - 1;
			low = 0;
			if (min > lowNumber + highNumber) {
				min = lowNumber + highNumber;
				count = 1;
			} else if (min == lowNumber + highNumber) {
				count++;
			}
		}
		System.out.println(min + " " + count);
	}
}