package baekjoon;

import java.util.Scanner;

public class Math1111 {
	static int[] arr;
	static boolean[] b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner s = new Scanner(System.in);
		while (true) {
			try {

				n = Integer.parseInt(s.nextLine());
				if(1<=n && n<50)
					break;
				else
					new Exception();
			} catch (Exception e) {
				System.out.println("Error");
				continue;
				// TODO: handle exception
			}
		}

		arr = new int[n + 1];
		b=new boolean[n+1];
		
		for(int i=1;i<=n;i++){
			if(!(i==n)){
				arr[i]=s.nextInt();
				if(Math.abs(arr[i])>100){
					i--;
					continue;
				}
			
			}
			else{
				arr[i]=Integer.parseInt(s.nextLine().trim());
				if(Math.abs(arr[i])>100){
					i--;
					continue;
				}
			
		}
		
		/*x*a+b=y
		a=y-n/x;
		b=y-xa;
		*/
		
//		a+b=4;
//		4a+b=13;
//		13a+b=40;
		
		
//		case1) 무수히 많다 case2) 해가 없다. 
//		arr[1]*a+b=arr[2];
//		arr[2]*a+b=arr[3];
		
		
		
		
	}
	}
}
