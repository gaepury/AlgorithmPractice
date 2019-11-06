package codeforce.codeforce_3_24;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//3.21 C. Woodcutters
public class codeforce545C {
	static int[] cut_dir;// 값은 0,1,2 / 0안쓰러짐,1왼쪽,2오른쪽
	static int count = 0;// 자른 수

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int n; // 트리 수
		int x, h; // 좌표, 높이
		ArrayList<int[]> tree = new ArrayList<int[]>(); // 트리
		
		
		tree.add(new int[] { -Integer.MAX_VALUE, 1 });// 트리 0번째꺼 추가.
		try {
			n = s.nextInt();

			if (n < 1 || n > 100000) {
				new Exception();
			} else {
				for (int i = 0; i < n; i++) {
					x = s.nextInt();
					h = s.nextInt();

					tree.add(new int[] { x, h });
				}
				cut_dir = new int[n + 1];

				cut_dir[0] = 0; // 0번째 트리는 세워놈.
				cut_dir[1] = 1; // 1번째 트리는 왼쪽으로 쓰러트림.				
				count++; //1번째 트리 왼쪽으로 쓰러트림
				//예외처리
				if(n!=1){
					cut_dir[n]=2; //n번째 트리 오른쪽으로 쓰러트림
					count++;
				}
				
				for (int i = 2; i < tree.size()-1; i++) { // tree.size() == n+1
					check(i, tree);
				}
				System.out.println(count);
			}
		} catch (Exception e) {
			System.out.println("error");
		}
	}

	public static void check(int i, ArrayList<int[]> tree) {
		if (cut_dir[i - 1] == 2) {
			if (tree.get(i)[0] - tree.get(i - 1)[0] > tree.get(i)[1] + tree.get(i - 1)[1]) {
//				System.out.println(tree.get(i)[0]);
				cut_dir[i] = 1;
				count++;
			} else {
//				System.out.println(tree.get(i)[0]);
				if (tree.get(i + 1)[0] - tree.get(i)[0] > tree.get(i)[1] && (tree.get(i)[0] + tree.get(i)[1] <= 1000000000)) {
					cut_dir[i] = 2;
					count++;
				} else {
					cut_dir[i] = 0;
				}
			}
		} else {
//			System.out.println(tree.get(i)[0]);
			if (tree.get(i)[0] - tree.get(i - 1)[0] > tree.get(i)[1]) {
				cut_dir[i] = 1;
				count++;
			} else {
				if (tree.get(i + 1)[0] - tree.get(i)[0] > tree.get(i)[1] && (tree.get(i)[0] + tree.get(i)[1] <= 1000000000)) {
					cut_dir[i] = 2;
					count++;
				} else {
					cut_dir[i] = 0;
				}
			}
		}
	}

}
