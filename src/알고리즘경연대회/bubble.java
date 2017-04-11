package 알고리즘경연대회;

import java.util.Arrays;

public class bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr=new int[]{5,4,3,2,1};
		
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){				
				if(arr[j+1]<arr[j]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}

}
