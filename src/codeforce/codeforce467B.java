package codeforce;
import java.util.Scanner;

public class codeforce467B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int n, m, k;
		int count = 0;

		try {
			n = s.nextInt();
			m = s.nextInt();
			k = s.nextInt();

			int nlimit = (int) Math.pow((double) 2, (double) n) - 1;
			if (k > 20 || k <= 0 || n > 20 || n <= 0 || m > 1000 || m <= 0)
				throw new Exception();
			else {
				int[] array = new int[m + 1];
				String[] binary = new String[m + 1];
				for (int i = 0; i < array.length; i++) {
					while (true) {
						array[i] = s.nextInt();
						if (array[i] > nlimit) {
							System.out.println(nlimit + "ÀÌÇÏ °ª input");
							continue;
						} else
							break;
					}
					binary[i] = Integer.toBinaryString(array[i]);
					int addzero = n - binary[i].length();
					String temp = "";
					for (int j = 0; j < addzero; j++) {
						temp +="0";
					}
					binary[i] = temp + binary[i];
				}
				
				int diff=0;
				for(int i=0;i<m;i++){
					for(int j=0;j<binary[m].length();j++){
						if(binary[i].charAt(j)==binary[m].charAt(j)){
							continue;
						}else{
							diff++;
						}
					}
					if(diff<=k){
						count++;
					}
					diff=0;
				}
				System.out.println(count);
			
			}
		} catch (Exception e) {
			System.out.println("1 <= k <= n <= 20 ; 1 <= m <=1000");
			// TODO: handle exception
		}

	}

}
