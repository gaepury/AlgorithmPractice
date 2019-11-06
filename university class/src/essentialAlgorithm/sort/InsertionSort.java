package essentialAlgorithm.sort;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 5, 4, 3, 2, 1 };
		
		int i, j, key;
		for (i = 1; i < arr.length; i++) {
			key = arr[i];
			// 오른쪽 이동
			for (j = i - 1; j >= 0 && arr[j] > key; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = key;
		}
	}

}
