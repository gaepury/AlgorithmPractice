package AlgorithmContest;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
		int n1=4;
		int n2=6;
		int rowl;
		int cowl;
		int[][] envelopes1=new int[][]{{5,3},{5,7},{3,3},{1,2}};
		int[][] envelopes2=new int[][]{{3,6},{2,3},{7,3},{1,1},{8,6},{4,5}};
		
		int[] ewidth1 = new int[envelopes1.length];
		int[] ewidth2= new int[envelopes2.length];
		
		for (int i = 0; i < ewidth1.length; i++) {
			ewidth1[i]=envelopes1[i][0]*envelopes1[i][1];
		}
		
		for (int i = 0; i < envelopes1.length; i++) {
			for (int j = 0; j < envelopes1[0].length-1; j++) {
				if(envelopes1[i][j]>envelopes1[i][j+1]){
					
				}
			}
		}
		
		
		
		
		int[] order=new int[ewidth1.length];
		for (int i = 0; i < ewidth1.length; i++) {
			int min=envelopes1[0][0]*envelopes1[0][1];
			int index=0;
			for(int j=1;j<ewidth1.length;j++){
				if(min>envelopes1[j][0]*envelopes1[j][1]){
					
					min=envelopes1[j][0]*envelopes1[j][1];
					index=j;
				}
			}
			order[i]=index;
		}
		System.out.println(Arrays.toString(order));
		
		
		
//		int index=0;
//		int miniwidth=envelopes1[0][0]*envelopes1[0][1];
//		for (int i = 0; i < envelopes1.length; i++) {
//			
//		}
		
        
	}

}
