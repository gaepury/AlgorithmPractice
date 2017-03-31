package codeforce.codeforce_3_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//3.21 Queue
public class codeforce490B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n; // the number of students
		int[] f_order;
		int[] s_order;
		int[] result;

		try {
			n = s.nextInt();
			if (n < 2 || n > 200000) {
				new Exception();
			} else {
				f_order = new int[n]; //첫번째 열
				s_order = new int[n]; //두번째 열
				result = new int[n];

				//입력
				for (int i = 0; i < n; i++) {
					f_order[i] = s.nextInt();
					s_order[i] = s.nextInt();
				}

				//카피, Sorting 할려고
				int[] f_order_temp = Arrays.copyOf(f_order, f_order.length);
				int[] s_order_temp = Arrays.copyOf(s_order, s_order.length);

				Arrays.sort(f_order_temp);
				Arrays.sort(s_order_temp);

				//rank매기기(순위매기기)
				int[] rank = new int[n];
				for (int i = 0; i < rank.length; i++) {
					rank[i] = Arrays.binarySearch(f_order_temp, f_order[i]);
				}
				
				// System.out.println(Arrays.toString(rank));

				// 첫번째 열 기준으로 소팅하기 위해 필요.
				int[] s2_order_temp = new int[n]; //첫번째 행 소팅한거에 맞게 두번째 행 연결
				int id = 0;
				for (int i : rank) {
					// System.out.println(i);
					s2_order_temp[i] = s_order[id];
					id++;
				}

				// System.out.println(Arrays.toString(s2_order_temp));
				int head = 0; //첫번째 위치값
				
				int index_1 = 0; //첫번째 위치의 인덱스
				int index_2 = 0; //두번째 위치의 인덱스
				
				
				for (int i = 0; i < n; i++) { // 첫번째 인덱스 값 찾음. index_1=0 이 됨.
					int index = Arrays.binarySearch(s_order_temp, f_order_temp[i]);
					if (index < 0) {
						head = f_order_temp[i];
						break;
					}
				}
				
				index_1 = Arrays.binarySearch(f_order_temp, head); //92가 있는 위치 = head
				index_2 = Arrays.binarySearch(f_order_temp, 0);  //0이 잇는 위치

				// System.out.println(index_1+","+index_2);
//				result[0] = head;
//				System.out.println(head);
				result[0] = f_order_temp[index_1]; //첫번째 값 삽입 (두번째열이랑 첫번째열 비교해서 첫번째열만 있는수)
				result[1] = s2_order_temp[index_2]; //두번째값 삽입(첫번째 열이 0인거)

				//head 에서 두칸 씩 뛰면서 insert
				for (int i = 2; i < n; i = i + 2) {
					result[i] = s2_order_temp[index_1];
					index_1 = Arrays.binarySearch(f_order_temp, result[i]);
				}
				
				//head+1에서 두칸 씩 뛰면서 insert
				for (int i = 3; i < n; i = i + 2) {
					index_2 = Arrays.binarySearch(f_order_temp, result[i - 2]);
					result[i] = s2_order_temp[index_2];
				}

				print(result);

			}

		} catch (Exception e) {
			System.out.println("error");
			// TODO: handle exception
		}

	}

	public static void print(int[] result) {
		for (int i = 0; i < result.length; i++) {
			if (i != result.length - 1)
				System.out.print(result[i] + " ");
			else
				System.out.println(result[i]);
		}
	}

}
