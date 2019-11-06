package essentialAlgorithm.sort;

import java.util.Arrays;

//O(n2)
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 5, 4, 3, 2, 1 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));

	}

}
