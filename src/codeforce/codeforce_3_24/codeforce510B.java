package codeforce.codeforce_3_24;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


// 3.21 C. Woodcutters
public class codeforce510B {
	static int[][] move = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static Stack<coordinates> stack = new Stack<coordinates>();
	static coordinates temp; 
	static int i = 1; //depth
	static String result = "NO";
	static boolean endFlag;
	static int max_depth; //마지막 순환을 알기 위하여 필요.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, m;

		try {
			n = s.nextInt();
			m = s.nextInt();

			if (n < 2 || n > 50 || m < 2 || m > 50) {
				new Exception();
			} else {
				//map에 테두리를 둘러쌈.
				char[][] map = new char[n + 2][m + 2]; 
				boolean[][] v_map = new boolean[n + 2][m + 2];

				for (int i = 1; i <= n; i++) {
					String temp = s.next();
					for (int j = 1; j <= m; j++) {
						map[i][j] = temp.charAt(j - 1);
					}
				}

//				System.out.println(Arrays.deepToString(map));

				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m; j++) {
						stack.push(new coordinates(i, j));
						dfs(map, v_map, i, j,-1,-1); // i는 y, j는 x
						
						for(int k=1;k<=n;k++){ //v_map초기화
							Arrays.fill(v_map[k], false);
						}
						if(endFlag){
							result="Yes";
							System.out.println("Yes");
							return ;
						}
//						System.out.println("-----"+result+"---------");
					}
				}
					result="No";
					System.out.println("No");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public static void dfs(char[][] map, boolean[][] v_map, int r, int c,int prv_r, int prv_c ) {//r,c는 현재좌표 prv_r,prv_c는 이전좌표
		v_map[r][c] = true; // 방문해봤음
		int y, x; //현재 좌표
		
		int depth = i++;// 뎁스확인.z
		if(depth>max_depth){
			max_depth=depth;
		}
		if(endFlag){
			return;
		}

		int wR, wC; // 미래좌표(상하좌우)
		while (!stack.isEmpty()) { // 스택이 비어있지 않을때
			if(endFlag){
				return;
			}
//			System.out.println(stack.toString());
			
			temp = stack.pop();
			x = temp.getX();
			y = temp.getY();
			
			for (int i = 0; i < 4; i++) { // 0: 상 1:우 2:하 3:좌
				wR = y + move[i][1];
				wC = x + move[i][0];
				
				if (v_map[wR][wC] == false && map[wR][wC] == map[y][x] && (int) map[wR][wC] != 0 && ( wR!=prv_r || wC!=prv_c) ) {
						stack.push(new coordinates(wR, wC));
						dfs(map, v_map, wR, wC,y,x);
				}
				if(v_map[wR][wC] == true && map[wR][wC] == map[y][x] && (int) map[wR][wC] != 0 && ( wR!=prv_r || wC!=prv_c) && max_depth ==depth){
					endFlag=true;
					return;
				}
			}
		}

		// System.out.println(depth);
	}
	public static class coordinates {
		int x;
		int y;

		public coordinates(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public String toString() {
			return "[" + x + "," + y + "]";
		}
	}
}
