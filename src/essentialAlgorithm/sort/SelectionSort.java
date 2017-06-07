package essentialAlgorithm.sort;

import java.util.Arrays;

//O(n2)
public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] { 5, 4, 3, 2, 1 };

		int min;
		for (int i = 0; i < arr.length; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		System.out.println(Arrays.toString(arr));
	}

}
