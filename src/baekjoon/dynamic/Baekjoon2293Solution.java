package baekjoon.dynamic;

import java.util.Scanner;
//동전1 , 입력받은 동전으로 합해서 k를 만들수 있는 경우의 수 구하기.
public class Baekjoon2293Solution {
	static int[] result;
    static int[] coin;
    static int n,k;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
        k = Integer.parseInt(scan.nextLine().trim());

        result = new int[k + 1];
        coin = new int[n];

        for (int i = 0; i < coin.length; i++) {
            coin[i] = Integer.parseInt(scan.nextLine().trim());
        }
        coinDP();
        System.out.println(result[k]);

	}
	static public void coinDP() {
        result[0] = 1;
        for (int j = 0; j < coin.length; j++) { // j = 0,1,2
            for (int i = 1; i <= k ; i++) {
                if (coin[j] <= i){
                    result[i] = result[i] + result[i - coin[j]]; 
                	System.out.print(result[i-coin[j]]);
                }
            }
            System.out.println();
        }
    }


}
