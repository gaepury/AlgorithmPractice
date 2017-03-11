package codeforce;
import java.util.Arrays;
import java.util.Scanner;

public class codeforce339A {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str;
		
			try {
				str = s.nextLine();
				if (str.length() > 100) {
					throw new Exception();
				}
				String[] strarray = str.split("\\+");
				int[] temp = new int[strarray.length];
				for (int i = 0; i < strarray.length; i++) {
					temp[i] = Integer.parseInt(strarray[i]);
				}
				Arrays.sort(temp);
				
				StringBuffer sb = new StringBuffer(100);

				for (int i = 0; i < temp.length; i++) {

					sb.append(temp[i]);
					if (i == temp.length - 1) {
						break;
					} else {
						sb.append("+");
					}
				}

				System.out.println(sb);

			} catch (Exception e) {
				System.out.println("String length limit 100");
				// TODO: handle exception
			}
		

	}
}
