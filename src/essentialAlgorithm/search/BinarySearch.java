package essentialAlgorithm.search;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] data=new int[]{4,2,1,6,3,7,8,9};
		Arrays.sort(data);
		System.out.println(binarySearch(data,10));
	}

	public static int binarySearch(int[] data, int key) {
		int size=data.length;
		
		int low = 0;
		int high = size - 1;

		while (high >= low) {
			int middle = (low + high) / 2;
			if (data[middle] == key) {
				return middle;
			}
			if (data[middle] < key) {
				low = middle + 1;
			}
			if (data[middle] > key) {
				high = middle - 1;
			}
		}
		return -1;
	}
}

