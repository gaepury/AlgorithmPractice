package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

//°³¶Ë¹ú·¹
public class baekjoon3020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int N, H;
		int[] Harray;
		Integer[] resultbyH;
		Integer[] even;
		Integer[] odd;

		int barriar;

		try {
			N = s.nextInt(); // Ç×»ó Â¦¼ö
			H = s.nextInt();

			if (N % 2 != 0 || N < 2 || N > 200000 || H < 2 || H > 500000) {
				new Exception();
			} else {
				Harray = new int[N];
				resultbyH=new Integer[H];
				odd = new Integer[N / 2];
				even = new Integer[N / 2];
				
				for (int i = 1; i <= Harray.length; i++) {
					Harray[i-1] = s.nextInt();
					if (i % 2 != 0) {
						odd[i / 2] = Harray[i-1];
						
					} else {
						even[(i / 2) - 1] = Harray[i-1];
					}
				}

				
				ArrayList lodd = new ArrayList(Arrays.asList(odd));
				ArrayList leven = new ArrayList(Arrays.asList(even));

				Collections.sort(lodd);
				Collections.sort(leven);
				
//				System.out.println(lodd);
//				System.out.println(leven);
				
				for (int i = 1; i <= H; i++) {

					int bottom=0;
					int top=0;
//					for(int j = 0; j<lodd.size();j++){
//						if((int)lodd.get(j) >= i){
//							count++;
//						}
//						if((int)leven.get(j)>=H-i+1){
//							count++;
//						}
//					}
					if(lodd.indexOf(i)==-1 &&  i <= (int)lodd.get(lodd.size()-1)) {
						for(int j=i+1;j<H;j++){
							if(lodd.indexOf(j)!=-1){
								bottom=lodd.size()-lodd.indexOf(j);
								break;
							}
						}
					}else if(lodd.indexOf(i)==-1){
						bottom=0;
					}
					else{
						bottom=lodd.size()-lodd.indexOf(i);
					}
					
//					System.out.println("b:"+bottom);
					
					if(leven.indexOf(H-i+1)==-1 && H-i+1 <= (int)leven.get(leven.size()-1)){
						int temp=H-i+1;
						for(int j=temp;j<H;j++){
							if(leven.indexOf(j)!=-1){
								top=leven.size()-leven.indexOf(j);
								break;
							}
						}
					}else if(leven.indexOf(H-i+1)==-1){
						top=0;
					}
					else{
						top=leven.size()-leven.indexOf(H-i+1);
					}
					
//					System.out.println("t:"+top);
					resultbyH[i-1]=bottom+top;
				}
				System.out.println(Arrays.toString(resultbyH));
				Arrays.sort(resultbyH);
				ArrayList result=new ArrayList(Arrays.asList(resultbyH));
				System.out.println(result);
				int num=result.lastIndexOf(result.get(0))+1;
				System.out.printf("%d %d",resultbyH[0],num);
			}

		} catch (Exception e) {
			System.out.println("error");
			// TODO: handle exception
		}
	}

}
