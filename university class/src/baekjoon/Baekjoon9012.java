package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
//°ýÈ£
public class Baekjoon9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Stack st = new Stack();

		int n;
		String[] array;
		String vps;
		String[] result;
		try {
			n = s.nextInt();
			array = new String[n];
			result = new String[n];
			for (int i = 0; i < array.length; i++) {
				array[i] = s.next();
			}

			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length(); j++) {
					if (array[i].charAt(j) == '(') {
						st.push(array[i].charAt(j));
					} else if (array[i].charAt(j) == ')') {
						if (st.isEmpty() == true) {
							result[i] = "NO";
							break;
						} else {
							st.pop();
						}
					} else {
						System.out.println("error");
					}
				}
				if (result[i] == "NO") {
					continue;
				} else if (st.isEmpty() != true) {
					result[i] = "NO";
				} else if (result[i] != "NO" && st.isEmpty() && true) {
					result[i] = "YES";
				}

				st.clear();
			}
			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}

		} catch (

		Exception e) {
			// TODO: handle exception
		}

	}

}
