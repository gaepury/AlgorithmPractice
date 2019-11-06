package baekjoon.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//DFS와 BFS
public class Baekjoon1260my {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N, M, V;// N:정점의개수, M:간선의개수, V:시작점
		boolean[] v_node;
		boolean[][] edge_map;
		int a, b; // 간선이 연결하는 두 정점;
		try {
			N = s.nextInt();
			M = s.nextInt();
			V = s.nextInt();

			if (N < 1 || N > 1000 || M < 1 || M > 10000) {
				new Exception();
			} else {
				v_node = new boolean[N + 1];
				edge_map = new boolean[N + 1][N + 1];

				for (int i = 0; i < M; i++) {
					a = s.nextInt();
					b = s.nextInt();
					edge_map[a][b] = true;
					edge_map[b][a] = true;
				}
				
				// System.out.print("DFS:");
				dfs(v_node, edge_map, V); 
				System.out.println();

				Arrays.fill(v_node, false); // 초기화

				// System.out.printf("BFS:");
				bfs(v_node, edge_map, V);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void dfs(boolean[] v_node, boolean[][] edge_map, int start) {

		v_node[start] = true;
		System.out.print(start + " ");
		
		for (int i = 1; i <= v_node.length - 1; i++) { // v_node.length는 N+1
			if (v_node[i] == false && edge_map[start][i] == true) {
				dfs(v_node, edge_map, i);
			}
		}
	}

	public static void bfs(boolean[] v_node, boolean[][] edge_map, int start) {
		Queue<Integer> q = new LinkedList();

		v_node[start] = true;
		q.add(start);
		
		while (!q.isEmpty()) {
			int x = q.remove();// 큐에서 하나 빼서 x를 저장
			System.out.print(x + " ");
			for (int i = 1; i <= v_node.length - 1; i++) {
				if (v_node[i] == false && edge_map[x][i] == true) {
					v_node[i] = true;
					q.add(i);
				}
			}

		}
	}
}
